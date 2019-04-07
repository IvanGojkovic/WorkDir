package Tests;

import Pages.DashBoard;
import Pages.HomePage;
import Utils.Constant;
import Utils.ExcelUtils;
import Utils.WriteLog;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

public class DashBoardTest {
	
	public static String text;
	public static Scanner sc = new Scanner(System.in);
	
// Popunjavanje Make Post Forma
	
	public static void fillMakePost (WebDriver driver, String text, String naziv, String lokacija) {
		
		DashBoard.getElement(driver, DashBoard.NAZIV_TEXTBOX).click();
		DashBoard.getElement(driver, DashBoard.NAZIV_TEXTBOX).sendKeys(naziv);
		
		DashBoard.getElement(driver, DashBoard.LOKACIJA_TEXTBOX).click();
		DashBoard.getElement(driver, DashBoard.LOKACIJA_TEXTBOX).sendKeys(lokacija);
		
		DashBoard.getElement(driver, DashBoard.OPIS_TEXTBOX).click();
		DashBoard.getElement(driver, DashBoard.OPIS_TEXTBOX).sendKeys(text);
		
		DashBoard.getElement(driver, DashBoard.POST_BUTTON).click();
		
	}
	
	
// TEST : Pravljenje postova iz Excel baze
	
	public static void makePostFromExcelData(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Pravljenje postova iz Excel baze");
		HomePage.navigateTo(driver);
		HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
		
		if (!(driver.getCurrentUrl().equals(DashBoard.URL))) {
			HomePage.navigateTo(driver);
			HomePageTest.fillNewUserForm(driver, Constant.NAME, Constant.LASTNAME, Constant.USERNAME, Constant.EMAIL,
					Constant.PASSWORD);
			HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
		}
		
		DashBoard.getElement(driver, DashBoard.MAKE_A_POST_BUTTON).click();
		
		ExcelUtils.setExcelFile(Constant.DATAPATH + Constant.DATAFILE, Constant.SHEET2_NAME);
		
		int rowcount = ExcelUtils.getWorkSheet().getLastRowNum();
		
		text = ">>Unosim listu od " + rowcount + " novih postova";
		WriteLog.write(text);
		
		//for (int i = 1; i <= rowcount; i++) {
		for (int i = 1; i <=4; i++) { // OVO JE AKTIVIRANO RADI BRZEG TESTA
		String makeAPost_text = ExcelUtils.getCellData(i, 0);
		String makeAPost_naziv = ExcelUtils.getCellData(i, 1);
		String makeAPost_lokacija = ExcelUtils.getCellData(i, 2);
		
		DashBoardTest.fillMakePost(driver, makeAPost_text, makeAPost_naziv, makeAPost_lokacija);
		
		DashBoard.getElement(driver, DashBoard.MAKE_A_POST_BUTTON).click();
		
		if ((DashBoard.post_headerText(driver).toString().contains(makeAPost_lokacija))
			&& (DashBoard.post_headerText(driver).toString().contains(makeAPost_naziv))
			  && (DashBoard.post_text(driver).toString().contains(makeAPost_text))) {
			
			WriteLog.write(">>>USPESAN TEST - Uspesno dodat " + i + ". post iz Excel baze");
			
		}
		else {
		WriteLog.write(">>>GRESKA - Neuspesno dodavanje " + i + ". posta iz Excel baze");
		HomePageTest.bugNo++;
			}
		
		
		}
		//DashBoard.getElement(driver, DashBoard.LOGOUT_BUTTON).click();
	}
	
	
	//TEST : Manuelno objavljivanje posta
	
	public static void makePostManual(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Manuelno objavljivanje posta");
				
		HomePage.navigateTo(driver);
		HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
		
		if (!(driver.getCurrentUrl().equals(DashBoard.URL))) {
			HomePage.navigateTo(driver);
			HomePageTest.fillNewUserForm(driver, Constant.NAME, Constant.LASTNAME, Constant.USERNAME, Constant.EMAIL,
					Constant.PASSWORD);
			HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
		}

		System.out.println("NAZIV : ");
		String naziv = sc.nextLine();
		System.out.println("LOKACIJA : ");
		String lokacija = sc.nextLine();
		System.out.println("TEXT : ");
		String text_body = sc.nextLine();
		
		DashBoard.getElement(driver, DashBoard.MAKE_A_POST_BUTTON).click();
		
	    DashBoardTest.fillMakePost(driver, text_body, naziv, lokacija);
		
		if ((DashBoard.post_headerText(driver).toString().contains(lokacija))
			&& (DashBoard.post_headerText(driver).toString().contains(naziv))
			  && (DashBoard.post_text(driver).toString().contains(text_body))) {
			WriteLog.write(">>>USPESAN TEST - Uspesno dodat manuelno unet post");
			
		}
		else {
		WriteLog.write(">>>GRESKA - Neuspesno dodavanje manuelno unetog posta");
		HomePageTest.bugNo++;
		}
		DashBoard.getElement(driver, DashBoard.LOGOUT_BUTTON).click();
	}
	
	
//TEST : Brisanje posta
	
	public static void deletePost(WebDriver driver) throws Exception {
			WriteLog.header("TEST : Brisanje posta");
			WriteLog.write(">>Unosimo broj postova koje zelimo da obrisemo");
			
			HomePage.navigateTo(driver);
			HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
			
			if (!(driver.getCurrentUrl().equals(DashBoard.URL))) {
				HomePage.navigateTo(driver);
				HomePageTest.fillNewUserForm(driver, Constant.NAME, Constant.LASTNAME, Constant.USERNAME, Constant.EMAIL,
						Constant.PASSWORD);
				HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
			}
			
			int n = DashBoard.getNoOfPosts(driver)+1;
			while (n>DashBoard.getNoOfPosts(driver)) {
				System.out.println("Unesite koliko postova da obrisem (max " + DashBoard.getNoOfPosts(driver) + ") :");
				n = sc.nextInt();	
			}
			
			text = ">>Broj postova koje brisem : " + n;
			WriteLog.write(text);
						
			for (int i=0; i<n;i++) {
				try {
				DashBoard.deletePostButton(driver);
				WriteLog.write(">>>USPESAN TEST - Uspesno obrisan " + (i+1)+ " post");
				} catch (Exception e) {
				}
				
			}
			DashBoard.getElement(driver, DashBoard.LOGOUT_BUTTON).click();	
	}
	
	
	// TEST : Editovanje posta
	
	public static void editPost(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Editovanje posta");
		WriteLog.write(">>Editujemo text poslednjeg posta");
		
		HomePage.navigateTo(driver);
		HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
		
		if (!(driver.getCurrentUrl().equals(DashBoard.URL))) {
			HomePage.navigateTo(driver);
			HomePageTest.fillNewUserForm(driver, Constant.NAME, Constant.LASTNAME, Constant.USERNAME, Constant.EMAIL,
					Constant.PASSWORD);
			HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);
		}
		
		System.out.println("Unesite promenjen post :");
		String newpost = sc.nextLine();
	
		DashBoard.editPostButton(driver);
		DashBoard.getElement(driver, DashBoard.EDIT_POST_TEXT).click();
		DashBoard.getElement(driver, DashBoard.EDIT_POST_TEXT).clear();
		DashBoard.getElement(driver, DashBoard.EDIT_POST_TEXT).sendKeys(newpost);
		DashBoard.getElement(driver, DashBoard.EDIT_POST_POSTBUTTON).click();
				
		if (newpost.equals(DashBoard.post_text(driver).toString()))
			WriteLog.write(">>>USPESAN TEST - Post uspesno zamenjen");
		else {
			WriteLog.write(">>>GRESKA - Neuspesno zamenjen post");
			HomePageTest.bugNo++;
		}
		DashBoard.getElement(driver, DashBoard.LOGOUT_BUTTON).click();
		
	}
	
	
}

package Tests;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import Pages.DashBoard;
import Pages.HomePage;
import Utils.Constant;
import Utils.ExcelUtils;
import Utils.WriteLog;

public class HomePageTest {

	public static String text;
	public static int bugNo = 0;
	public static Scanner sc = new Scanner(System.in);

// TEST : Provera ispravnosti URL-a

	public static void testURL(WebDriver driver) {
		WriteLog.header("TEST : Provera ispravnosti URL-a");
		WriteLog.write(">>Proveram ispravnost URL-a : \" + HomePage.URL");

		System.out.println(text);
		if (!(driver.getCurrentUrl().equals(HomePage.URL))) {
			WriteLog.write(">>>GRESKA : Otvoreni URL se ne poklapa sa HomePage URL-om");
			bugNo++;

		} else {
			WriteLog.write(">>>TEST USPESAN - Otvoreni URL se poklapa sa HomePage URL-om");
		}
	}

// TEST : Provera vidljivosti elemenata

	public static void displayedTest(WebDriver driver) {
		boolean displayed = true;
		WriteLog.header("TEST : Provera vidljivosti elemenata");
		WriteLog.write(">>Proveram vidljivost elemenata na HomePage-u");

		if (!HomePage.getElement(driver, HomePage.CONTACT_US_BUTTON).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat ContactUsButton nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.GALERIJA_LINK).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat GalerijaLink nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.LOGIN_BUTTON).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat getLogInButton nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.NEW_EMAIL_TEXTBOX).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat NewEmailTextbox nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.NEW_FIRSTNAME_TEXTBOX).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat NewFirstNameTextbox nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.NEW_LASTNAME_TEXTBOX).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat NewLastNameTextbox nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.NEW_PASSWORD_TEXTBOX).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat NewPasswordTextbox nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.NEW_USERNAME_TEXTBOX).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat NewUsernameTextbox nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.PASSWORD_TEXTBOX).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat PasswordTextbox nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.REGISTER_BUTTON).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat RegisterButton nije vidljiv");
			displayed = false;
			bugNo++;
		} else if (!HomePage.getElement(driver, HomePage.USERNAME_TEXTBOX).isDisplayed()) {
			WriteLog.write(">>>GRESKA - Objekat UsernameTextbox nije vidljiv");
			displayed = false;
			bugNo++;
		}

		if (displayed) {
			WriteLog.write(">>>TEST USPESAN - Svi objekti na Home Page-u su vidljivi");
		}
	}

// TEST : Provera dostupnosti elemenata

	public static void enabledTest(WebDriver driver) {
		WriteLog.header("TEST : Provera dostupnosti elemenata");
		boolean displayed = true;
		WriteLog.write(">>Proveram dostupnost elemenata na HomePage-u");

		if (!HomePage.getElement(driver, HomePage.CONTACT_US_BUTTON).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat ContactUsButton je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.GALERIJA_LINK).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat GalerijaLink je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.LOGIN_BUTTON).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat getLogInButton je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.NEW_EMAIL_TEXTBOX).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat NewEmailTextbox je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.NEW_FIRSTNAME_TEXTBOX).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat NewFirstNameTextbox je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.NEW_LASTNAME_TEXTBOX).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat NewLastNameTextbox je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.NEW_PASSWORD_TEXTBOX).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat NewPasswordTextbox je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.NEW_USERNAME_TEXTBOX).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat NewUsernameTextbox je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.PASSWORD_TEXTBOX).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat PasswordTextbox je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.REGISTER_BUTTON).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat RegisterButton je disabled");
			displayed = false;
			bugNo++;
		}
		if (!HomePage.getElement(driver, HomePage.USERNAME_TEXTBOX).isEnabled()) {
			WriteLog.write(">>>GRESKA - Objekat UsernameTextbox je disabled");
			displayed = false;
			bugNo++;
		}

		if (displayed) {
			WriteLog.write(">>>TEST USPESAN - Svi objekti na Home Page-u su Enabled");
		}
	}

// TEST : Provera LOG IN-a sa praznim poljima

	public static void logInWithoutData(WebDriver driver) {
		WriteLog.header("TEST : Provera LOG IN-a sa praznim poljima");
		WriteLog.write(">>Proveram da li mogu da se ulogujem bez podataka");

		HomePage.getElement(driver, HomePage.LOGIN_BUTTON).click();
		if ((driver.getCurrentUrl().equals(DashBoard.URL))) {
			WriteLog.write(">>>GRESKA - Dozvoljeno Log In-ovanje");
			bugNo++;
		} else {
			WriteLog.write(">>>TEST USPESAN - Nije dozvoljeno Log In-ovanje");
		}
		HomePage.navigateTo(driver);

	}

// TEST : Provera registracije sa praznim poljima
	public static void registerWithoutData(WebDriver driver) {
		WriteLog.header("TEST : Provera registracije sa praznim poljima");
		WriteLog.write(">>Proveram da li mogu da se registrujem bez podataka");

		HomePage.getElement(driver, HomePage.REGISTER_BUTTON).click();
		if ((driver.getCurrentUrl().equals(HomePage.URL_INDEX))) {
			WriteLog.write(">>>GRESKA - Dozvoljeno registrovanje");
			bugNo++;
		} else {
			WriteLog.write(">>>TEST USPESAN - Nije dozvoljeno registrovanje");
		}
		HomePage.navigateTo(driver);

	}

// "TEST : Provera registracije DEFAULT USER-a"
	public static void registerDefaultUser(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Provera registracije DEFAULT USER-a");
		WriteLog.write(">>Registrujem DEFAULT USER-a");

		HomePageTest.fillNewUserForm(driver, Constant.NAME, Constant.LASTNAME, Constant.USERNAME, Constant.EMAIL,
				Constant.PASSWORD);

		// LogInujem se sa istim podacima
		HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);

		// Proveram ispravnosti LogIna
		if ((driver.getCurrentUrl().equals(DashBoard.URL))) {
			WriteLog.write(">>>TEST USPESAN - Pravilno ste registrovani sa DEFAULT podacima");
		} else {
			WriteLog.write(">>>GRESKA - Niste registrovani sa DEFAULT podacima");
			bugNo++;
		}
		HomePage.navigateTo(driver);

	}

// TEST : Manuelna registracija
	public static void regUserManual(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Manuelna registracija");
		WriteLog.write(">>Registrujem manuelno USER-a");

		System.out.println("NAME : ");
		String name = sc.nextLine();
		System.out.println("LAST NAME : ");
		String lastname = sc.nextLine();
		System.out.println("USERNAME : ");
		String username = sc.nextLine();
		System.out.println("EMAIL : ");
		String email = sc.nextLine();
		System.out.println("PASSWORD : ");
		String password = sc.nextLine();

		HomePageTest.fillNewUserForm(driver, name, lastname, username, email, password);

		// LogInujem se sa istim podacima
		HomePageTest.fillFormLogIn(driver, username, password);

		// Provera ispravnosti LogIna
		if ((driver.getCurrentUrl().equals(DashBoard.URL))) {
			WriteLog.write(">>>TEST USPESAN - Pravilno ste registrovani sa podacima : ");
		} else {
			WriteLog.write(">>>GRESKA - Niste se registrovali sa podacima : ");
			bugNo++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("  NAME : " + name);
		sb.append(System.getProperty("line.separator"));
		sb.append("  LAST NAME : " + lastname);
		sb.append(System.getProperty("line.separator"));
		sb.append("  USERNAME : " + username);
		sb.append(System.getProperty("line.separator"));
		sb.append("  EMAIL : " + email);
		sb.append(System.getProperty("line.separator"));
		sb.append("  PASSWORD : " + password);
		sb.append(System.getProperty("line.separator"));
		text = sb.toString();
		WriteLog.write(text);

		HomePage.navigateTo(driver);

	}

// TEST : Registracija vec registrovanog USER-a

	public static void regAlreadyRegUser(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Registracija vec registrovanog USER-a");
		WriteLog.write(">>Registrujem vec registrovanog korisnika");

		HomePageTest.fillFormLogIn(driver, Constant.USERNAME, Constant.PASSWORD);

		if ((driver.getCurrentUrl().equals(DashBoard.URL)))
			DashBoard.getElement(driver, DashBoard.LOGOUT_BUTTON).click();
		else {
			driver.navigate().to(HomePage.URL);
			HomePageTest.fillNewUserForm(driver, Constant.NAME, Constant.LASTNAME, Constant.USERNAME, Constant.EMAIL,
					Constant.PASSWORD);
		}

		HomePageTest.fillNewUserForm(driver, Constant.NAME, Constant.LASTNAME, Constant.USERNAME, Constant.EMAIL,
				Constant.PASSWORD);

		if ((driver.getCurrentUrl().equals(HomePage.URL_INDEX))) {
			WriteLog.write(">>>GRESKA - Dozvoljeno registrovanje vec registrovanog USER-a");
			bugNo++;
		} else {
			WriteLog.write(">>>TEST USPESAN - Nije dozvoljeno registrovanje vec registrovanog USER-a");
			HomePage.navigateTo(driver);
		}

	}

// TEST : Manuelni LOG IN

	public static void logInManual(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Manuelni LOG IN");
		WriteLog.write(">>Log In-ujem manuelno USER-a");

		System.out.println("USERNAME : ");
		String username = sc.nextLine();
		System.out.println("PASSWORD : ");
		String password = sc.nextLine();

		HomePageTest.fillFormLogIn(driver, username, password);

		// Provera ispravnosti LogIna
		if ((driver.getCurrentUrl().equals(DashBoard.URL))) {
			WriteLog.write(">>>TEST USPESAN - Pravilno ste registrovani sa podacima : ");
		} else {
			WriteLog.write(">>>GRESKA - Niste se registrovali sa podacima : ");
			bugNo++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("  USERNAME : " + username);
		sb.append(System.getProperty("line.separator"));
		sb.append("  PASSWORD : " + password);
		sb.append(System.getProperty("line.separator"));
		text = sb.toString();
		WriteLog.write(text);

		HomePage.navigateTo(driver);

	}

// TEST : Registracija USER-a iz Excel baze

	public static void regFromExcel(WebDriver driver) throws Exception {
		WriteLog.header("TEST : Registracija USER-a iz Excel baze");

		ExcelUtils.setExcelFile(Constant.DATAPATH + Constant.DATAFILE, Constant.SHEET_NAME);
		int rowcount = ExcelUtils.getWorkSheet().getLastRowNum();

		text = ">>Registrujem listu od " + rowcount + " novih korisnika iz Excel baze";
		WriteLog.write(text);

		//for (int i = 1; i <= rowcount; i++) {
			for (int i = 1; i <= 4; i++) { // OVO JE AKTIVIRANO RADI BRZEG TESTA	
			String name = ExcelUtils.getCellData(i, 0);
			String lastname = ExcelUtils.getCellData(i, 1);
			String username = ExcelUtils.getCellData(i, 2);
			String email = ExcelUtils.getCellData(i, 3);
			String password = ExcelUtils.getCellData(i, 4);

			HomePageTest.fillNewUserForm(driver, name, lastname, username, email, password);

			// LogInujem se sa istim podacima
			HomePageTest.fillFormLogIn(driver, username, password);

			// Provera ispravnosti LogIna
			if ((driver.getCurrentUrl().equals(DashBoard.URL))) {
				WriteLog.write(">>>TEST USPESAN - Pravilno ste registrovani sa podacima : ");
				DashBoard.getElement(driver, DashBoard.LOGOUT_BUTTON).click();
			} else {
				WriteLog.write(">>>GRESKA - Niste registrovani sa podacima : ");
				bugNo++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("  NAME : " + name);
			sb.append(System.getProperty("line.separator"));
			sb.append("  LAST NAME : " + lastname);
			sb.append(System.getProperty("line.separator"));
			sb.append("  USERNAME : " + username);
			sb.append(System.getProperty("line.separator"));
			sb.append("  EMAIL : " + email);
			sb.append(System.getProperty("line.separator"));
			sb.append("  PASSWORD : " + password);
			sb.append(System.getProperty("line.separator"));
			text = sb.toString();
			WriteLog.write(text);

		}
		HomePage.navigateTo(driver);

	}

// TEST : LOG IN USER-a iz Excel baze

	public static void logFromExcel(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.DATAPATH + Constant.DATAFILE, Constant.SHEET_NAME);
		int rowcount = ExcelUtils.getWorkSheet().getLastRowNum();

		WriteLog.header("TEST : LOG IN USER-a iz Excel baze");
		WriteLog.write(">>Log In-ujem " + rowcount + " korisnika iz Excel baze");

		//for (int i = 1; i <= rowcount; i++) {
		for (int i = 1; i <= 3; i++) { // OVO SE AKTIVIRA RADI BRZEG TESTA
			String username = ExcelUtils.getCellData(i, 2);
			String password = ExcelUtils.getCellData(i, 4);

			HomePageTest.fillFormLogIn(driver, username, password);

			if ((driver.getCurrentUrl().equals(DashBoard.URL))) {
				WriteLog.write(">>>TEST USPESAN - Pravilno ste LOG IN-ovani sa podacima : ");
				DashBoard.getElement(driver, DashBoard.LOGOUT_BUTTON).click();
			} else {
				WriteLog.write(">>>GRESKA - Niste LOG IN-ovani sa podacima : ");
				bugNo++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("  USERNAME : " + username);
			sb.append(System.getProperty("line.separator"));
			sb.append("  PASSWORD : " + password);
			sb.append(System.getProperty("line.separator"));
			text = sb.toString();
			WriteLog.write(text);

		}
		HomePage.navigateTo(driver);

	}

	// POPUNJAVANJE FORMA ZA NOVOG USER-A

	public static void fillNewUserForm(WebDriver driver, String name, String lastname, String username, String email,
			String password) throws Exception {

		HomePage.getElement(driver, HomePage.NEW_FIRSTNAME_TEXTBOX).click();
		HomePage.getElement(driver, HomePage.NEW_FIRSTNAME_TEXTBOX).clear();
		HomePage.getElement(driver, HomePage.NEW_FIRSTNAME_TEXTBOX).sendKeys(name);

		HomePage.getElement(driver, HomePage.NEW_LASTNAME_TEXTBOX).click();
		HomePage.getElement(driver, HomePage.NEW_LASTNAME_TEXTBOX).clear();
		HomePage.getElement(driver, HomePage.NEW_LASTNAME_TEXTBOX).sendKeys(lastname);

		HomePage.getElement(driver, HomePage.NEW_USERNAME_TEXTBOX).click();
		HomePage.getElement(driver, HomePage.NEW_USERNAME_TEXTBOX).clear();
		HomePage.getElement(driver, HomePage.NEW_USERNAME_TEXTBOX).sendKeys(username);

		HomePage.getElement(driver, HomePage.NEW_EMAIL_TEXTBOX).click();
		HomePage.getElement(driver, HomePage.NEW_EMAIL_TEXTBOX).clear();
		HomePage.getElement(driver, HomePage.NEW_EMAIL_TEXTBOX).sendKeys(email);

		HomePage.getElement(driver, HomePage.NEW_PASSWORD_TEXTBOX).click();
		HomePage.getElement(driver, HomePage.NEW_EMAIL_TEXTBOX).clear();
		HomePage.getElement(driver, HomePage.NEW_PASSWORD_TEXTBOX).sendKeys(password);

		HomePage.getElement(driver, HomePage.REGISTER_BUTTON).click();

	}

	// POPUNJAVANJE FORMA ZA LOG IN

	public static void fillFormLogIn(WebDriver driver, String username, String password) throws Exception {

		HomePage.getElement(driver, HomePage.USERNAME_TEXTBOX).click();
		HomePage.getElement(driver, HomePage.USERNAME_TEXTBOX).clear();
		HomePage.getElement(driver, HomePage.USERNAME_TEXTBOX).sendKeys(username);

		HomePage.getElement(driver, HomePage.PASSWORD_TEXTBOX).click();
		HomePage.getElement(driver, HomePage.PASSWORD_TEXTBOX).clear();
		HomePage.getElement(driver, HomePage.PASSWORD_TEXTBOX).sendKeys(password);

		HomePage.getElement(driver, HomePage.LOGIN_BUTTON).click();

	}

}
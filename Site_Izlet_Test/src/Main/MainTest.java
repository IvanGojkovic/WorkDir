package Main;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.DashBoard;
import Pages.HomePage;
import Tests.DashBoardTest;
import Tests.HomePageTest;
import Utils.Constant;
import Utils.ExcelUtils;
import Utils.WriteBug;
import Utils.WriteLog;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		

		WebDriver driver=new ChromeDriver();
		ExcelUtils.setExcelFile(Constant.DATAPATH + Constant.DATAFILE, Constant.SHEET_NAME);
		long start = System.currentTimeMillis();
		
		System.out.println("Unesite ime testera : ");
		String testerName = sc.nextLine();
		System.out.println(Constant.headerText(testerName));
        WriteLog.newTest(Constant.headerText(testerName).toString());
	  
        WriteLog.header("HOME PAGE TESTOVI");

//OTVARANJE HOME PAGE-A
		HomePage.openPage(driver);

// TEST URL-A HomePage-a
		HomePageTest.testURL(driver);
		
// TEST VIDLJIVOSTI I DOSTUPNOSTI ELEMENATA
		HomePageTest.displayedTest(driver);
		HomePageTest.enabledTest(driver);
		
// TEST LOG IN-A BEZ PODATAKA
        HomePageTest.logInWithoutData(driver);

        HomePageTest.registerWithoutData(driver);
		
// TEST PRIJAVE JEDNOG NOVOG KORISNIKA
		
		HomePageTest.registerDefaultUser(driver);
	
// TEST PRIJAVE VEC REGISTROVANOG KORISNIKA

		HomePageTest.regAlreadyRegUser(driver);

// TEST MANUELNOG REGISTROVANJA KORISNIKA
		
		HomePageTest.regUserManual(driver);

// TEST MANUELNOG LOG IN-a
		
		HomePageTest.logInManual(driver);

// TEST REGISTROVANJE IZ EXCEL BAZE
		HomePageTest.regFromExcel(driver);

// TEST LOG IN IZ EXCEL BAZE
		HomePageTest.logFromExcel(driver);

// DASHBOARD TESTOVI
		
		WriteLog.header("DASHBOARD TESTOVI");
	
// POSTOVANJE IZ EXCEL TABELE		
		DashBoardTest.makePostFromExcelData(driver);
// MANUELNO POSTOVANJE
		DashBoardTest.makePostManual(driver);
// BRISANJE POSTA
		DashBoardTest.deletePost(driver);
// EDITOVANJE POSTA		
		DashBoardTest.editPost(driver);
		
System.out.println("Test izvrsen uspesno");
	
	long elapsedTimeMillis = System.currentTimeMillis()-start;
	float elapsedTimeMin = elapsedTimeMillis/(60*1000F);
	WriteLog.endTest(elapsedTimeMin,HomePageTest.bugNo);
	}
	
	

}

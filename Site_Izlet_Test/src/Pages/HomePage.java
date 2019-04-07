package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.HomePageTest;
import Utils.WriteLog;

public class HomePage {

	// Metoda za otvaranje stranice
	public static void openPage(WebDriver driver) {
		WriteLog.write(">Otvaram url : " + URL);
		driver.get(URL);
	}

	// Metoda za navodjenje do stranice HomePage URL
	public static void navigateTo(WebDriver driver) {
		WriteLog.write(">Prelazim na url : " + URL);
		driver.navigate().to(URL);
	}

	/*
	 * Metoda za univerzalni geter - Potrebno je poslati driver i xpath elementa u
	 * Stringu koji je vec definisan u ovoj klasi
	 */
	public static WebElement getElement(WebDriver driver, String element) {
		WebElement wb = driver.findElement(By.xpath(element));
		return wb;
	}

	// DEFINICIJA PROMENJIVIH

	// URL
	public static final String URL = "http://localhost/izlet/";
	public static final String URL_INDEX = "http://localhost/izlet/index.php";

	// WEB ELEMENTS

	public static final String GALERIJA_LINK = "//nav[@class='main-nav']//a[@class='a_bold'][contains(text(),'Galerija')]";
	public static final String CONTACT_US_BUTTON = "//a[@id='contact_btn']";
	public static final String USERNAME_TEXTBOX = "//input[@placeholder='username']";
	public static final String PASSWORD_TEXTBOX = "//input[@placeholder='password']";
	public static final String LOGIN_BUTTON = "//input[@value='Log in']";
	public static final String NEW_FIRSTNAME_TEXTBOX = "//input[@name='firstname']";
	public static final String NEW_LASTNAME_TEXTBOX = "//input[@name='lastname']";
	public static final String NEW_USERNAME_TEXTBOX = "//form[@action='processregister.php']//input[@name='username']";
	public static final String NEW_EMAIL_TEXTBOX = "//input[@name='email']";
	public static final String NEW_PASSWORD_TEXTBOX = "//form[@action='processregister.php']//input[@name='password']";
	public static final String REGISTER_BUTTON = "//input[@id='blue_btn']";

}

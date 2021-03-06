package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.HomePageTest;
import Utils.WriteLog;

public class DashBoard {

	// UNIVERZALNI GETER
	// Potrebno je poslati driver i xpath elementa u Stringu koji je vec definisan u
	// ovoj klasi
	public static WebElement getElement(WebDriver driver, String element) {
		WebElement wb = driver.findElement(By.xpath(element));
		return wb;
	}
	
	// Metoda za Log Out
	public static void logOut(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(LOGOUT_BUTTON));
		wb.click();
	}

	// Geter za postove
	public static WebElement getPosts(WebDriver driver) {
		WebElement element = driver.findElement(POSTS);
		return element;
	}

	// Geter za tekst u postu
	public static WebElement getHeaderPostText(WebDriver driver) {
		WebElement element = driver.findElement(POST_HEADER_TEXT);
		return element;
	}

	// Geter za dugme 'Tri tacke'
	public static WebElement getPostThreeDots(WebDriver driver) {
		WebElement element = driver.findElement(POST_THREEDOTS_BUTTON);
		return element;
	}

	// Geter za tekst u postu
	public static WebElement getPostText(WebDriver driver) {
		WebElement element = driver.findElement(POST_TEXT);
		return element;
	}

	// Geter za
	public static WebElement getMenuPostButton(WebDriver driver) {
		WebElement element = driver.findElement(POST_THREEDOTS_BUTTON);
		return element;
	}

	// Geter za dugme za brisanje posta
	public static WebElement getDelPostButton(WebDriver driver) {
		WebElement element = driver.findElement(DELETE_POST_BUTTON);
		return element;
	}

	// Geter za dugme za editovanje posta
	public static WebElement getEditPostButton(WebDriver driver) {
		WebElement element = driver.findElement(EDIT_POST_BUTTON);
		return element;
	}

	// Geter za snimanje promene posta
	public static WebElement getPostChangeSave(WebDriver driver) {
		WebElement element = driver.findElement(POST_CHANGE_SAVE);
		return element;
	}

	// Metoda za klik na dugme za snimanje editovanog posta
	public static void postChangeSave(WebDriver driver) {
		List<WebElement> list = driver.findElements(POST_CHANGE_SAVE);
		list.get(0).click();
	}

	// Metoda za vracanje header texta iz posta
	public static String post_headerText(WebDriver driver) {
		List<WebElement> list = driver.findElements(POST_HEADER_TEXT);
		return list.get(0).getText();
	}

	// Geter za tekst u postu
	public static String post_text(WebDriver driver) {
		List<WebElement> list = driver.findElements(POST_TEXT);
		return list.get(0).getText();
	}

	// Metoda za ukupan broj postova
	public static int getNoOfPosts(WebDriver driver) {
		List<WebElement> list = driver.findElements(POSTS);
		return list.size();
	}

	// Metoda za klik na dugme 'Tri tacke'
	public static void postThreeDots(WebDriver driver) {
		List<WebElement> list = driver.findElements(POST_THREEDOTS_BUTTON);
		list.get(0).click();
	}

	// Metoda za klik na dugme za brisanje posta
	public static void deletePostButton(WebDriver driver) {
		postThreeDots(driver);
		List<WebElement> delete = driver.findElements(DELETE_POST_BUTTON);
		delete.get(0).click();
	}

	// Metoda za klik na dugme za edit posta
	public static void editPostButton(WebDriver driver) {
		List<WebElement> list = driver.findElements(EDIT_POST_BUTTON);
		list.get(0).click();
	}

	// Metoda za navigaciju ka DashBoard URLu
	public static void navigateTo(WebDriver driver) {
		WriteLog.write(">Prelazim na url : " + URL);
		driver.navigate().to(URL);
	}

	// DEFINICIJA PROMENJIVIH

	// URL
	public static final String URL = "http://localhost/izlet/dashboard.php";

	// WEB ELEMENTS

	public static final String MAKE_A_POST_BUTTON = "//a[contains(text(),'Make a post')]";

	// WEB ELEMENTS (MAKE A POST WINDOW)
	public static final String NAZIV_TEXTBOX = "//input[@placeholder='Naziv']";
	public static final String LOKACIJA_TEXTBOX = "//input[@placeholder='Lokacija']";
	public static final String BROWSE_BUTTON = "//label[@class='custom-file-upload']";
	public static final String TRANSPORT_DROPBOX = "//select[@name='transport']";
	public static final String OPIS_TEXTBOX = "//textarea[@placeholder='Opis']";
	public static final String POST_BUTTON = "//input[@value='Post']";
	public static final String LOGOUT_BUTTON = "/html[1]/body[1]/div[2]/div[2]/a[1]";

	// WEB ELEMENTS (POST)
	public static final By POSTS = By.className("posts");
	public static final By POST_THREEDOTS_BUTTON = By.className("fa-ellipsis-v");
	public static final By DELETE_POST_BUTTON = By.className("fa-trash-alt");
	public static final By EDIT_POST_BUTTON = By.className("fa-edit");
	public static final By POST_HEADER_TEXT = By.className("headertxt");
	public static final By POST_TEXT = By.className("textbody");
	public static final By POST_CHANGE_SAVE = By.xpath("//div[@class='popupEdit']//input[@value='Post']");

	// public static final String EDIT_POST_POSTBUTTON =
	// "//div[@class='popupEdit']//input[@value='Post']";

	// WEB ELEMENTS (EDIT POST)
	public static final String EDIT_POST_TEXT = "//textarea[@id='description']";

}

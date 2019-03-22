package test3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
		
		driver.get(Data.url);
		WebElement register_button = driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]"));
	    register_button.click();
	    
	    WebElement firstName_textbox = driver.findElement(By.xpath("//input[@name='firstName']"));
	    firstName_textbox.sendKeys(Data.firstName);
	   
	    WebElement lastName_textbox = driver.findElement(By.xpath("//input[@name='lastName']"));
	    lastName_textbox.sendKeys(Data.lastName);
	    
	    WebElement phone_textbox = driver.findElement(By.xpath("//input[@name='phone']"));
	    phone_textbox.sendKeys(Data.phone);
	    
	    WebElement email_textbox = driver.findElement(By.xpath("//input[@id='userName']"));
	    email_textbox.sendKeys(Data.email);
	    
	    WebElement address_textbox = driver.findElement(By.xpath("//input[@name='address1']"));
	    address_textbox.sendKeys(Data.address);
	    
	    WebElement city_textbox = driver.findElement(By.xpath("//input[@name='city']"));
	    city_textbox.sendKeys(Data.city);
	    
	    WebElement state_textbox = driver.findElement(By.xpath("//input[@name='state']"));
	    state_textbox.sendKeys(Data.statePro);
	    
	    WebElement postal_textbox = driver.findElement(By.xpath("//input[@name='postalCode']"));
	    postal_textbox.sendKeys(Data.postalCode);
	    
	    WebElement country_dropbox = driver.findElement(By.xpath("//select[@name='country']"));
	    country_dropbox.sendKeys(Data.country);
	    country_dropbox.click();
	    
	    WebElement username_textbox = driver.findElement(By.xpath("//input[@id='email']"));
	    username_textbox.sendKeys(Data.userName);
	    
	    WebElement password_textbox = driver.findElement(By.xpath("//input[@name='password']"));
	    password_textbox.sendKeys(Data.password);
	    
	    WebElement confirmPassword_textbox = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
	    confirmPassword_textbox.sendKeys(Data.confirmPassword);
	    
	    WebElement submit_textbox = driver.findElement(By.xpath("//input[@name='register']"));
	    submit_textbox.click();;
	  
	  
	
	    
	    
	    
	    
	   
	    
	    Thread.sleep(4000);
	      
	    
	    
	    } catch (Exception ex) {
			System.out.println(ex.toString());
		} finally { 
		//driver.close();
		}

	}

}

package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// Create Web driver
		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//Open browser to "Account Management"
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//find the element on the page for "Create Account" and click on "Create Account"
		driver.findElement(By.linkText("Create Account")).click();
		
		// Fill out form
		//fill out name
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Jane Doe");
		//fill out email
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("jdoe@ksglerkgj.invalid");
		
		// fill out phone number,by relative x-path
		driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("123-456-7890");
		
		// fill out password, and fill out verify password
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("Password123");
		//driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Password123");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("Password123");
		
		// interacting with form elements
		// radio button
		driver.findElement(By.id("MainContent_Male")).click();
		
		// working with dropdown menus
		// the tag is a "Select" tag for dropdowns, which means it requires a new selector
		// from the Selenium support library
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("France");
		
		//click checkbox
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		
		//click submit
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		

		// get confirmation
		// retrieves text from confirmation method
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		
		if(confirmation.contains("Customer information added successfully")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
		// close browser, and quit browser
		driver.quit();

	}

}

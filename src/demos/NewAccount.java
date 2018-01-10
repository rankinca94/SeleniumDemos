package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		//Parameters for form
		String name = "Jane Doe";
		String email = "jdoe@ksglerkgj.invalid";
		String password = "Password123";
		String phoneNumber = "123-456-7890";
		String country = "France";
		String browserType = "firefox";
		
		// Define Webdriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
		
		String gender = "Female";
		// required values to be tested
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occasionalEmail = true;

		// go to start page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

		// Click "Create Account" to get to "Create Account" page
		driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		

		// Define web elements, must define after navigation to start page, and "Create Account" page
		WebElement nameText = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailText = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneText = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordText = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordText = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryText = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		WebElement monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occasionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		
		// fill out form
		nameText.sendKeys(name);
		emailText.sendKeys(email);
		phoneText.sendKeys(phoneNumber);
		passwordText.sendKeys(password);	
		verifyPasswordText.sendKeys(password);
		new Select(countryText).selectByVisibleText(country);

		// Gender radio button
		if (gender.equalsIgnoreCase("Male")) {
			maleRadio.click();
		} 
		else {
			femaleRadio.click();
		}
		
		
		// check if weekly email should be selected
		if (weeklyEmail) {
			// check if box is not selected
			if (!weeklyCheckbox.isSelected()) {
				// select checkbox
				weeklyCheckbox.click();
			}
		}
		else {
			// if the box should not be selected
			// check if the box is selected
			if(weeklyCheckbox.isSelected()) {
				// de-select the box
				weeklyCheckbox.click();
			}
		}
		
		// check if Monthly email should be selected
		if (monthlyEmail) {
			// check if box is not selected
			if (!monthlyCheckbox.isSelected()) {
				// select checkbox
				monthlyCheckbox.click();
			}
		}
		else {
			// if the box should not be selected
			// check if the box is selected
			if(monthlyCheckbox.isSelected()) {
				// de-select the box
				monthlyCheckbox.click();
			}
		}
		
		// check if Occasional email should be selected
		if (occasionalEmail) {
			// check if box is not selected
			if (!occasionalCheckbox.isSelected()) {
				// select checkbox
				occasionalCheckbox.click();
			}
		}
		else {
			// if the box should not be selected
			// check if the box is selected
			if(occasionalCheckbox.isSelected()) {
				// de-select the box
				occasionalCheckbox.click();
			}
		}
		
		// click "Submit"
		submitButton.click();

		// get confirmation
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();

		if (confirmation.contains("Customer information added successfully")) {
			System.out.println("'Customer information added successfully': Test passed");
		} else {
			System.out.println("Customer information not added seccefully: Test failed");
		}

		// close browser, and quit browser
		driver.quit();
	}

}

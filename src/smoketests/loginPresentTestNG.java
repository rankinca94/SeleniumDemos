package smoketests;
/*
 * Demonstrates how to use TestNG assertions and Annotations for the framework. 
 * 
 * By convention, the "BeforeMethod" and "AfterMethod" annotations appear at the end of
 * the class. 
 * Testing is annotated by "Test". "BeforeMethod" sets up preconditions before testing.
 * "AfterMethod" removes unneeded items produced by testing; including the Web driver. 

 * The results produced include logging statements added by the TestNG "assertTrue" method.
 * */
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPresentTestNG {
	
	//web driver instance
	WebDriver driver;
	
	//refers to TestNG library 
	@Test
	public void loginElementPresentTest () {
		System.out.println("Running Test");

		//test whether the "Username" element and the "Password" elements are present in
		//in the login page
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		//if assertion is true the test will pass; 
		//if assertion fails the string parameter provides an explanation
		Assert.assertTrue("Login box is present.", loginEmailBox);
		Assert.assertTrue("Password box is present",passwordBox);
	}
	
	//should include all shared properties within testing
	@BeforeMethod
	public void setUp() {
		System.out.println("Starting test");
		
		driver = utilities.DriverFactory.open("chrome");
		
		System.out.println("Driver created. Opening browser.");
		
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webURL);
		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing test");
		driver.quit();
		System.out.println("Driver closed, and removed from RAM");
		System.out.println("Test closed");
	}

}

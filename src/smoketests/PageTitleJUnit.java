package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

	WebDriver driver;
	
	// locator string for home page
	String webURL  = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

	// annotation to be used before any testing begins
	@Before
	public void setUp() {
		
		System.out.println("Initializing driver");
		driver = utilities.DriverFactory.open("chrome");
	}

	// a single test
	@Test
	public void pageTitleTest() {
		
		System.out.println("Running test 1");
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	// action(s) to be performed after all testing is complete
	@After
	public void tearDown() {
		// environment tear-down, placeholder
		driver.quit();
		System.out.println("Test closed");
	}
}

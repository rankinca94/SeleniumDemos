package smoketests;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {

		WebDriver driver;

		@Test
		public void loginElementPresentTest () {
			System.out.println("Running Test");
			
			//assume that the link "CREATE ACCOUNT" is not present
			boolean createAccountPresent = false;
			
			//test the presence of A tags (meaning hyperlinks)
			List <WebElement> aElements = driver.findElements(By.tagName("a")); 
			int quantityOfElements = aElements.size();
			System.out.println("There are " + quantityOfElements + " links on the login page.");
			
			//test each hyperlink found
			for (WebElement aElement : aElements) {
				
				//print any text for a link found (some links may not have text)
				System.out.println("Text: " +(aElement.getText()));
				
				//check target test link for correct text
				if(aElement.getText().equals("CREATE ACCOUNT")) {
					//only set "CREATE ACCOUNT" to true if the link text is found on the page
					createAccountPresent = true;
					System.out.println("--Target text found.--");
				}
				
			}
			
			//Assertion
			Assert.assertTrue(createAccountPresent);
			
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

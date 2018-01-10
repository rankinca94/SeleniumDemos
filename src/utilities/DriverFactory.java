package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	
	// this method will return a WebDriver object
	public static WebDriver open(String browserType) {
		
		if (browserType.equalsIgnoreCase("firefox")) {
			
			// code for FF
			System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\geckodriver.exe");
			return new FirefoxDriver();
		} 
		else if(browserType.equalsIgnoreCase("ie")) {
			
			//code for IE
			System.setProperty("webdriver.ie.driver", "C:\\BrowserDrivers\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else {
			
			// code for Chrome
			System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}

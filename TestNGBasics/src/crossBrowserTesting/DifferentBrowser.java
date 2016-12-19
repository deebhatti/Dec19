package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DifferentBrowser {
	
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.get("https://facebook.com");
		
		System.setProperty("webdriver.ie.driver", "C:\\Webdrivers\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		
		
		
	}

}

package crossBrowserTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBT {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) {
		if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equals("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Webdrivers\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
	}

	@Test(priority = 0)
	public void verifyTitle() {
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1)
	public void verifyText() {
		String expectedText = "Facebook helps you connect and share with the people in your life.";
		String actualText = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/div/div")).getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}

}

package SingletonSelenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Apptest {
	
	private WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String Browser) {
		
	driver=	WebDriverManager.getInstance(Browser).getDriver();
		
//		driver=	(WebDriver) WebDriverManager.getInstance("chrome");
//		((WebDriverManager) driver).getDriver();
	}
	
	@Test
	public void testGoogle() {
		driver.get("https://www.google.com/");
		System.out.println(Thread.currentThread().getName() + ":" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		WebDriverManager.quitBrowser();
	}

}

package SingletonSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	
	//volatile -Each thread will get fresh copy or proper copy of instance 
	
	private static volatile WebDriverManager instance;
	private static ThreadLocal<WebDriver> tldriver=new ThreadLocal<>();
	
	private WebDriverManager() {
		
	}
	
	//set method is used to initialize driver
	
	private void initDriver(String browser) {
		switch(browser) {
		case "chrome":
			tldriver.set(new ChromeDriver());
			break;
		case "firefox":
			tldriver.set(new FirefoxDriver());
			break;
		case "edge":
			tldriver.set(new EdgeDriver());
			break;
			default:
			throw new IllegalArgumentException("unsupported browser:" +browser);
		}
	}
	
	// entire method is not synchronized (thread safe) only particular block inside method is synchronized
	public static WebDriverManager getInstance(String browser) {
		if(instance==null) {
			synchronized (WebDriverManager.class) {
				if(instance==null) {
					instance=new WebDriverManager();
				}
				
			}
		}
		if(tldriver.get()==null) {
			instance.initDriver(browser);
		}
		return instance;
		
	}
	
	public WebDriver getDriver() {
		return tldriver.get();
	}
	
	public static void quitBrowser() {
		if(tldriver.get() != null) {
			tldriver.get().quit();
			tldriver.remove();
		}
	}

}

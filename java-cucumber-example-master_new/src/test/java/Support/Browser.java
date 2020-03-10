package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import CustomeListener.EventCapture;

public class Browser {
	
	public static EventFiringWebDriver eventhandlerdriver;
	
	public static EventFiringWebDriver launch() {
		String browser = System.getProperty("browser");
		System.out.println("Browser Value:"+browser);
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", System.getProperty("driverPath"));
			eventhandlerdriver = new EventFiringWebDriver(new FirefoxDriver()); 
			 EventCapture eCapture = new EventCapture();
			 eventhandlerdriver.register(eCapture); 
			return eventhandlerdriver;
		} else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("driverPath"));
			eventhandlerdriver = new EventFiringWebDriver(new ChromeDriver()); 
			 EventCapture eCapture = new EventCapture();
			 eventhandlerdriver.register(eCapture); 
			return eventhandlerdriver;
		} else {
			throw new RuntimeException("Unrecognized system property 'browser': " + browser);
		}
	}
}

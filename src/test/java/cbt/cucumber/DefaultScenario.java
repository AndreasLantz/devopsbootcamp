package cbt.cucumber;

import io.cucumber.java.*;
import io.cucumber.java.en.*;


import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class DefaultScenario {

    private WebDriver driver;
    private String TargetURL;
    private String SeleniumGridURL;
    private String Browser;
    private String username;
    private String password;

    @Before
    public void setUp() throws Throwable {
        
    	TargetURL = System.getProperty("TargetURL");    
        SeleniumGridURL = System.getProperty("SeleniumGridURL");  
        Browser = System.getProperty("browser");
        username = System.getProperty("username");
        password = System.getProperty("password");
        
        System.out.println("TargetURL ="+TargetURL);
        System.out.println("SeleniumGridURL ="+SeleniumGridURL);
        System.out.println("Browser ="+Browser);
        System.out.println("Username ="+username);
        System.out.println("Password ="+password);        
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");
        
    	DesiredCapabilities dc = new DesiredCapabilities();
    	dc.setBrowserName(Browser);
    	dc.setCapability(ChromeOptions.CAPABILITY, opt);
    	
        driver = new RemoteWebDriver(new URL(SeleniumGridURL), dc);
        driver.get("https://google.com");

    }

    @Given("I open Google")
    public void I_open_Google() {
         driver.findElement(By.id("L2AGLb")).click();
    	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    @When("I search for cats")
    public void I_search_for_cats() {

        WebElement searchbar = driver.findElement(By.id("APjFqb"));
        searchbar.click();
        searchbar.clear();
        searchbar.sendKeys("cats");
        searchbar.sendKeys(Keys.RETURN);

        String result_prop = driver.findElement(By.id("result-stats")).getText();
        assertTrue(result_prop.contains("Ungefär"));

    	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

/**
 * Created by zhabenya on 16.03.16.
 */
public class WebDriverFactory {

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    /*Browsers constants*/
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    public static WebDriver driverWrapper;

    public WebDriverFactory() {
    }

    public static WebDriver initDriver(){

        if(FIREFOX.equals(browserName)){
            driverWrapper = new FirefoxDriver();

        } else if(CHROME.equals(browserName)){
            driverWrapper = new ChromeDriver();
        }

        else {
            Assert.fail("Invalid driver name");
        }

        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();

        return driverWrapper;
    }

}

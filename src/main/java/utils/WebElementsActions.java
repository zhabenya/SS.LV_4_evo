package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by zhabenya on 16.03.16.
 */
public class WebElementsActions {

    private WebDriver driver;
    private ConfigData config;
    public static WebDriverWait waitForElement;
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public WebElementsActions(WebDriver driver) {
        this.driver = driver;
        this.config = ConfigData.getConfig();
        waitForElement = new WebDriverWait(driver, 20);
    }

    /**
     * CLick element
     */
    public void clickElement(String elementLocator) {
        driver.findElement(config.ui(elementLocator)).click();
        LOG.info("Click " + elementLocator);
    }

    public void clickElementById(String elementId) {
        driver.findElement(By.id(elementId)).click();
    }

    /**
     * Insert value into field
     */
    public void fillField(String inputLocator, String inputData) {
        driver.findElement(config.ui(inputLocator)).sendKeys(inputData);
        LOG.info("Fill " + inputLocator + " with " + inputData);
    }

    public void selectFromDropdown(String elementLocator, String value) {
        new Select(driver.findElement(config.ui(elementLocator))).selectByVisibleText(value);
    }

    /**
    * Get text from element
    */
    public String getElementText(String elementLocator) {
        return driver.findElement(config.ui(elementLocator)).getText();
    }

    public String getElementTextById(String elementId) {
        return driver.findElement(By.id(elementId)).getText();
    }

    public List<WebElement> findElements(String elementLocator) {
        return driver.findElements(config.ui(elementLocator));
    }


}

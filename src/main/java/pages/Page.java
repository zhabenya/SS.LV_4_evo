package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.ClassNameUtil;
import utils.ConfigData;
import utils.WebElementsActions;

/**
 * Created by zhabenya on 17.03.16.
 */
public class Page {

    protected static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public WebDriver driver;
    public WebElementsActions web;
    private ConfigData config;

    public Page(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
        config = ConfigData.getConfig();
    }

    public void scrollPageToElementId(String elementId) {
        new Actions(driver).moveToElement(driver.findElement(By.id(elementId))).perform();
    }

    public void scrollPageToElement(String elementLocator) {
        new Actions(driver).moveToElement(driver.findElement(config.ui(elementLocator))).perform();
    }
}

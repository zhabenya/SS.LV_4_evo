package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by zhabenya on 16.03.16.
 */
public class Site {
    public MainPage mainPage;
    public SearchPage searchPage;
    public AdsPage adsPage;

    public Site(WebDriver driver) {
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        adsPage = new AdsPage(driver);
    }

}

package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by zhabenya on 17.03.16.
 */
public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void chooseLanguage(String language) {
        if (language.equalsIgnoreCase(web.getElementText("MenuLanguageSpan"))) {
            web.clickElement("MenuLanguageSpan");
        }
    }

    public void chooseElectronicsCategory() {
        web.clickElement("ElectronicsLink");
    }

    public void goToSearch() {
        web.clickElement("SearchLink");
    }
}

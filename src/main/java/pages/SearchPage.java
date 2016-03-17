package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by zhabenya on 17.03.16.
 */
public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String key) {
        web.fillField("SearchInput", key);
        web.clickElement(key + "Word");
    }

    public void selectCity(String city) {
        web.selectFromDropdown("CityDropdown", city);
    }

    public void selectPeriod(String period) {
        web.selectFromDropdown("PeriodDropdown", period);
    }

    public void startSearch() {
        web.clickElement("SearchButton");
    }

    public void setPriceLimits(String min, String max) {
        web.fillField("MinPriceInput", min);
        web.fillField("MaxPriceInput", max);
    }

}

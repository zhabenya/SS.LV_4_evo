package pages;

import data.Advertisement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static data.Advertisement.getAdIdFromTable;
import static utils.Randomizer.getRandomNumbers;

/**
 * Created by zhabenya on 17.03.16.
 */
public class AdsPage extends Page {

    public AdsPage(WebDriver driver) {
        super(driver);
    }

    public void sortResultsByPrice() {
        web.selectFromDropdown("SortDropdown", "Цена");
    }

    public void selectDealCategory(String value) {
        web.selectFromDropdown("DealCategoryDropdown", value);
    }

    public void goToAdvancedSearch() {
        web.clickElement("AdvancedSearchLink");
    }

    public List<Advertisement> selectAds(int quantity) {
        List<WebElement> adTableRows = web.findElements("AdTableRow");
        List<Advertisement> ads = new ArrayList<>();

        for (int i : getRandomNumbers(adTableRows.size(), quantity)) {
            String trId = adTableRows.get(i).getAttribute("id");
            scrollPageToElementId(trId);

            int adId = getAdIdFromTable(trId);
            /**Select ad*/
            web.clickElementById("c" + adId);
            LOG.info("Select ad with id " + adId);

            Advertisement ad = new Advertisement();
            ad.setId(adId);
            ad.setHeader(getAdText(adId));

            ads.add(ad);
        }
        return ads;
    }

    private String getAdText(int adId) {
        return web.getElementTextById("dm_" + adId);
    }

    public void showSelectedAds() {
        scrollPageToElement("ShowSelectedAdsButton");
        web.clickElement("ShowSelectedAdsButton");
    }

    public boolean checkSelectedElements(List<Advertisement> selected){
        List<WebElement> adTableRows = web.findElements("AdTableRow");

        if (selected.size() == adTableRows.size()) {
            int found = 0;
            for (Advertisement ad : selected) {
                int i = 0;
                while (i < adTableRows.size()) {
                    if (ad.getId() == getAdIdFromTable(adTableRows.get(i).getAttribute("id"))) {
                        LOG.info("Advertisement with id " + ad.getId() + " found");
                        found++;
                        adTableRows.remove(i);
                        i = adTableRows.size();
                    } else if (i == adTableRows.size() - 1) {
                        LOG.error("Advertisement with id " + ad.getId() + " not found");
                    }
                    i++;
                }
            }
            return found == selected.size();
        }
        return false;
    }

    public void clearSelectedAds() {
        web.clickElement("ClearSelectedButton");
    }
}

import data.Ad;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by zhabenya on 16.03.16.
 */
public class SiteTest extends ClassFixture {

    @Test
    public void CheckAdsTest(){
        ss.mainPage.chooseLanguage("RU");
        ss.mainPage.chooseElectronicsCategory();
        ss.mainPage.goToSearch();
        ss.searchPage.searchByKeyword("Компьютер");
        ss.searchPage.selectCity("Рига");
        ss.searchPage.selectPeriod("За последний месяц");
        ss.searchPage.startSearch();
        ss.adsPage.sortResultsByPrice();
        ss.adsPage.selectDealCategory("Продажа");
        ss.adsPage.goToAdvancedSearch();
        ss.searchPage.setPriceLimits("0", "300");
        ss.searchPage.startSearch();
        List<Ad> ads = ss.adsPage.selectAds(3);
        ss.adsPage.showSelectedAds();
        Assert.assertTrue(ss.adsPage.checkSelectedElements(ads));
    }

    @AfterMethod
    public void afterTest(){
        ss.adsPage.clearSelectedAds();
    }
}

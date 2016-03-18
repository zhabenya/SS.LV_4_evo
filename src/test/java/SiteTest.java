import data.Advertisement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by zhabenya on 16.03.16.
 */
public class SiteTest extends ClassFixture {

    @Test
    public void CheckAdsTest(){
        site.mainPage.chooseLanguage("RU");
        site.mainPage.chooseElectronicsCategory();
        site.mainPage.goToSearch();
        site.searchPage.searchByKeyword("Компьютер");
        site.searchPage.selectCity("Рига");
        site.searchPage.selectPeriod("За последний месяц");
        site.searchPage.startSearch();
        site.adsPage.sortResultsByPrice();
        site.adsPage.selectDealCategory("Продажа");
        site.adsPage.goToAdvancedSearch();
        site.searchPage.setPriceLimits("0", "300");
        site.searchPage.startSearch();
        List<Advertisement> ads = site.adsPage.selectAds(3);
        site.adsPage.showSelectedAds();
        Assert.assertTrue(site.adsPage.checkSelectedElements(ads));
    }

    @AfterMethod
    public void afterTest(){
        site.adsPage.clearSelectedAds();
    }
}

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.Site;
import utils.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhabenya on 16.03.16.
 */
public class BrowserFixture {

    public static WebDriver driver;
    public static Site ss;
    public static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    public static final String wait = PropertyLoader.loadProperty("wait.timeout");

    @BeforeSuite(alwaysRun = true)
    public static void setBrowser() throws Exception {
        driver = WebDriverFactory.initDriver();
        ss = new Site(driver);

        driver.manage().timeouts().implicitlyWait(Long.parseLong(wait), TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("site.url"));
        LOG.info("Start test suite");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() throws Exception {
        LOG.info("End test");
        driver.quit();
    }
}

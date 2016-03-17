import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import static utils.ScreenshotUtil.takeScreenshot;

/**
 * Created by zhabenya on 16.03.16.
 */
public class ClassFixture extends BrowserFixture {

    @AfterMethod(alwaysRun = true)
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(driver, testResult);
        }
    }

}

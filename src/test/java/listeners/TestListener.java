package listeners;

import com.aventstack.extentreports.ExtentReports;
package listeners;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;

// Import custom utility classes (ensure these exist in your project)
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;
public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        ExtentTestManager.setTest(test);
    }

    public void onTestFailure(ITestResult result) {

        Object obj = result.getInstance();

        try {
            WebDriver driver = (WebDriver) obj.getClass()
                    .getDeclaredField("driver").get(obj);

            String path = ScreenshotUtil.capture(driver, result.getName());
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);


        } catch (Exception e) {}
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
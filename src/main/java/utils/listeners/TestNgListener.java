package utils.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.testng.*;
import utils.extentHandle.ExtentManager;
import utils.ScreenShotCapture;

public class TestNgListener extends ExtentManager implements ITestListener, ISuiteListener, IClassListener {
    ScreenShotCapture sc;
    String methodName;
    Logger logger = Logger.getLogger(TestNgListener.class);

    public synchronized void onStart(ISuite suite) {
    }

    public synchronized void onFinish(ISuite suite) {
    }

    public synchronized void onTestStart(ITestResult result) {
        childTest = parentTest.createNode(result.getName());
        childTest.log(Status.INFO, "Test Started");
    }

    public synchronized void onTestSuccess(ITestResult result) {
        //childTest.log(Status.PASS, "Test: " + result.getName() + " Passed");
        childTest.log(Status.INFO, "Test: " + result.getName() + " Ended with STATUS: PASS");
    }

    public synchronized void onTestFailure(ITestResult result) {
        //childTest.log(Status.FAIL, "Test: " + result.getName() + " Failed");
        methodName = result.getName();
        childTest.log(Status.INFO, "Test: " + result.getName() + " Ended with STATUS: FAIL");
    }

    public synchronized void onTestSkipped(ITestResult result) {
        //childTest.log(Status.SKIP, "Test: " + result.getName() + " Skipped");
        childTest.log(Status.INFO, "Test: " + result.getName() + " Ended with STATUS: SKIP");
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public synchronized void onStart(ITestContext context) {
        extentReports = ExtentManager.getInstance();
    }

    public synchronized void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public synchronized void AssertFailAndContinue(boolean result, String description) {
        try {
            if (result) {
                childTest.log(Status.PASS, description);
            } else {
                String s = System.getProperty("user.dir") + "/src/main/resources/" + methodName + " .png";
                sc.captureScreenshot(driver, s);
                childTest.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(s).build());
                ITestResult result1 = Reporter.getCurrentTestResult();
                result1.setStatus(2);
            }
        } catch (Exception e) {
            logger.info("Exception occured foe screenshot capture" + e);
        }
    }

    public synchronized void logInfo(String info) {
        childTest.log(Status.INFO, info);
        //TODO: Need screenshot
    }

    public synchronized void logWarning(String info) {
        childTest.log(Status.WARNING, info);
        //TODO: Need screenshot
    }

    public void onBeforeClass(ITestClass testClass) {
        parentTest = extentReports.createTest(testClass.getName());
    }

    public void onAfterClass(ITestClass testClass) {
    }
}

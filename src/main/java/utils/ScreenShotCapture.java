package utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotCapture extends BrowserInit {
    Logger logger = Logger.getLogger(ScreenShotCapture.class);
    WebDriver driver;

    public ScreenShotCapture(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(String path) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File fs = ts.getScreenshotAs(OutputType.FILE);

        //String path = System.getProperty("user.dir") + "/reports/screenshots/" + screensShotName + ".png";
        File dest = new File(path);

        try {
            FileUtils.copyFile(fs, dest);
        } catch (IOException e) {
            logger.info("Exception while coping screenshot");
        }
    }
}

package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelsPage {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelsPage.class);

    public HotelsPage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

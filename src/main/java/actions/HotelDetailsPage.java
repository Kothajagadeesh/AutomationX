package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelDetailsPage {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelDetailsPage.class);

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelSearchResultsPage {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelSearchResultsPage.class);

    public HotelSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

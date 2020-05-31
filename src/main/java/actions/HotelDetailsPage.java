package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import repo.HotelDetailsRepo;
import utils.SafeElementsActions;

public class HotelDetailsPage extends SafeElementsActions implements HotelDetailsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelDetailsPage.class);

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

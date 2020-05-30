package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelDetailsPage {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelDetailsPage.class);

    private By roomsTab = By.id("detpg_hotel_rooms");
    private By roomsType = By.id(".roomWrap h2"); //get list and retrieve innerText from first index

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

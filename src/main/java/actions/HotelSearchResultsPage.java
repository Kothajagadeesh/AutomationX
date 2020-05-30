package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelSearchResultsPage {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelSearchResultsPage.class);

    private By hotelsLoading = By.cssSelector("div.listingLoading");
    private By userRatingLabels = By.cssSelector("div#hlistpg_fr_user_rating>ul>li label"); //get in list
    private By hotelNames = By.cssSelector("div.listingRowOuter p#hlistpg_hotel_name>span[id^='htl_id']"); //get list of hotels. If count is < x then scroll and again get hotels.

    public HotelSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public class HotelSearchResultsRepo extends SafeElementsActions {

    private By hotelsLoading = By.cssSelector("div.listingLoading");
    private By userRatingLabels = By.cssSelector("div#hlistpg_fr_user_rating>ul>li label"); //get in list
    private By hotelNames = By.cssSelector("div.listingRowOuter p#hlistpg_hotel_name>span[id^='htl_id']"); //get list of hotels. If count is < x then scroll and again get hotels.
}

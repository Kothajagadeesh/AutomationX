package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public interface HotelDetailsRepo {

    public By roomsTab = By.id("detpg_hotel_rooms");
    public By roomsType = By.id(".roomWrap h2"); //get list and retrieve innerText from first index
    public By hotelName = By.id("detpg_hotel_name");
    public By selectRoomButton = By.cssSelector("div.roomRight div.roomTypePrice a");
}

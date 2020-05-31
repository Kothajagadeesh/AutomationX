package repo;

import org.openqa.selenium.By;

public interface HotelDetailsRepo {

    public By roomsTab = By.id("detpg_hotel_rooms");
    public By roomsType = By.cssSelector(".roomWrap h2"); //get list and retrieve innerText from first index
    public By hotelName = By.id("detpg_hotel_name");
    public By selectRoomButton = By.cssSelector("div.roomRight div.roomTypePrice .primaryBtn");
    public By hotelLocation = By.cssSelector("span#detpg_hotel_location");
}

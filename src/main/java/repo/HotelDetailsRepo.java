package repo;

import org.openqa.selenium.By;

public interface HotelDetailsRepo {

    By roomsTab = By.id("detpg_hotel_rooms");
    By roomsType = By.cssSelector(".roomWrap h2");
    By hotelName = By.id("detpg_hotel_name");
    By selectRoomButton = By.cssSelector("div.roomRight div.roomTypePrice .primaryBtn");
    By hotelLocation = By.cssSelector("span#detpg_hotel_location");
    By makeOwnChoiceHeader = By.cssSelector("div#viewMoreRooms>p.ownChoice");
    By comboRoomType = By.cssSelector("div.comboWrap div.roomRow p.blueText");
    By bookComboButton = By.id("detpg_book_combo_btn");
}

package repo;

import org.openqa.selenium.By;

public interface HotelDetailsRepo {

    public By roomsTab = By.id("detpg_hotel_rooms");
    public By roomsType = By.id(".roomWrap h2"); //get list and retrieve innerText from first index
}

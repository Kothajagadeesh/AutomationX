package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public interface HotelDetailsRepo {

    By roomsTab = By.id("detpg_hotel_rooms");
    By roomsType = By.id(".roomWrap h2"); //get list and retrieve innerText from first index
}

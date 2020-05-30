package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public class HotelDetailsRepo extends SafeElementsActions {

    private By roomsTab = By.id("detpg_hotel_rooms");
    private By roomsType = By.id(".roomWrap h2"); //get list and retrieve innerText from first index
}

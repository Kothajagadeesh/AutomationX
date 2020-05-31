package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import repo.HotelDetailsRepo;
import utils.SafeElementsActions;

import java.util.List;

public class HotelDetailsPage extends SafeElementsActions implements HotelDetailsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelDetailsPage.class);

    public HotelDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getHotelName(){
        return getText(hotelName);
    }

    public void clickRoomsTab(){
        click(roomsTab);
    }

    public String getFirstRoomType(){
        List<WebElement> roomTypes = driver.findElements(roomsType);
        return roomTypes.get(0).getText();
    }

    public void selectFirstRoom(){
        List<WebElement> selectRoomButtons = driver.findElements(selectRoomButton);
        selectRoomButtons.get(0).click();
    }
}

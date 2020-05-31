package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import repo.HotelDetailsRepo;
import utils.SafeElementsActions;

import java.util.ArrayList;
import java.util.List;

public class HotelDetailsPage extends SafeElementsActions implements HotelDetailsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelDetailsPage.class);

    public HotelDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getHotelName() {
        return getText(hotelName);
    }

    public void clickRoomsTab() {
        click(roomsTab);
    }

    public String getHotelLocation() {
        return getText(hotelLocation);
    }

    public List<String> getNthRoomType(int roomNumber) {
        List<WebElement> roomTypes = driver.findElements(roomsType);
        List<String> selectedRooms = new ArrayList<>();
        selectedRooms.add(roomTypes.get(roomNumber-1).getText());
        return selectedRooms;
    }

    public void selectFirstRoom() {
        List<WebElement> selectRoomButtons = driver.findElements(selectRoomButton);
        selectRoomButtons.get(0).click();
    }

    public List selectRoom(int roomNumber){
        List<WebElement> makeRoomChoice = driver.findElements(makeOwnChoiceHeader);
        List<WebElement> comboRoomsType = driver.findElements(comboRoomType);
        List<String> selectedRooms = new ArrayList<>();
        if(makeRoomChoice.size() > 0){
            for(int i=0;i<comboRoomsType.size()-1;i++){
                selectedRooms.add(comboRoomsType.get(i).getText());
            }
        }
        else{
            selectedRooms = getNthRoomType(roomNumber);
        }
        return selectedRooms;
    }
}

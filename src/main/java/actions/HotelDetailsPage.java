package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import repo.HotelDetailsRepo;
import utils.SafeElementsActions;

import java.util.*;

public class HotelDetailsPage extends SafeElementsActions implements HotelDetailsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelDetailsPage.class);

    public HotelDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickRoomsTab() {
        click(roomsTab);
    }

    public String getHotelLocation() {
        return getText(hotelLocation);
    }

    public Set<String> getNthRoomType(int roomNumber) {
        List<WebElement> roomTypes = driver.findElements(roomsType);
        Set<String> selectedRooms = new HashSet<>();
        selectedRooms.add(roomTypes.get(roomNumber - 1).getText());
        return selectedRooms;
    }

    public void selectFirstRoom() {
        List<WebElement> selectRoomButtons = driver.findElements(selectRoomButton);
        selectRoomButtons.get(0).click();
    }

    public Set<String> selectRoom(int roomNumber) {
        List<WebElement> makeRoomChoice = driver.findElements(makeOwnChoiceHeader);
        List<WebElement> comboRoomsType = driver.findElements(comboRoomType);
        Set<String> selectedRooms = new HashSet<>();
        if (makeRoomChoice.size() > 0) {
            for (int i = 0; i < comboRoomsType.size() - 1; i++) {
                String value = comboRoomsType.get(i).getText();
                selectedRooms.add(value);
            }
            click(bookComboButton);

        } else {
            selectedRooms = getNthRoomType(roomNumber);
            selectFirstRoom();
        }
        return selectedRooms;
    }
}

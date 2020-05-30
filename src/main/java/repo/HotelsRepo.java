package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public interface HotelsRepo {

    By citySelection = By.className("selectHtlCity");
    By cityField = By.className("input[placeholder='Enter city/ Hotel/ Area/ Building']");
    By citySuggestionList = By.className(".react-autosuggest__section-container ul li"); //get list and text
    By checkInDateField = By.cssSelector("label[for='checkin']");
    By nextMonthNavButton = By.className("DayPicker-NavButton--next"); //click 3 times
    By dayPickerDays = By.className(".DayPicker-Month div[class='DayPicker-Day'][aria-disabled='false']"); //get list, click indexes 8, 10. get property aria-label for both
    By roomGuestsField = By.className("roomGuests");
    By room1Adults2 = By.cssSelector("div[data-cy='roomRow1'] li[data-cy='adults-2']");
    By room1Children2 = By.cssSelector("div[data-cy='roomRow1'] ul.guestCounter li[data-cy='children-2']");
    By addAnotherRoomButton = By.className("btnAddRoom");
    By room2Adults2 = By.cssSelector("div[data-cy='roomRow2'] li[data-cy='adults-2']");
    By room2Children2 = By.cssSelector("div[data-cy='roomRow2'] ul.guestCounter li[data-cy='children-2']");
    By roomAndGuestsApplyButton = By.className("btnApply");
    By travelForOption = By.cssSelector("div.travelFor");
    By travelForLeisure = By.cssSelector("li[data-cy='travelFor-Leisure']");
    By SearchButton = By.id("hsw_search_button");
}

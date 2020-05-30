package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public class HotelsRepo extends SafeElementsActions {

    private By citySelection = By.className("selectHtlCity");
    private By cityField = By.className("input[placeholder='Enter city/ Hotel/ Area/ Building']");
    private By citySuggestionList = By.className(".react-autosuggest__section-container ul li"); //get list and text
    private By checkInDateField = By.cssSelector("label[for='checkin']");
    private By nextMonthNavButton = By.className("DayPicker-NavButton--next"); //click 3 times
    private By dayPickerDays = By.className(".DayPicker-Month div[class='DayPicker-Day'][aria-disabled='false']"); //get list, click indexes 8, 10. get property aria-label for both
    private By roomGuestsField = By.className("roomGuests");
    private By room1Adults2 = By.cssSelector("div[data-cy='roomRow1'] li[data-cy='adults-2']");
    private By room1Children2 = By.cssSelector("div[data-cy='roomRow1'] ul.guestCounter li[data-cy='children-2']");
    private By addAnotherRoomButton = By.className("btnAddRoom");
    private By room2Adults2 = By.cssSelector("div[data-cy='roomRow2'] li[data-cy='adults-2']");
    private By room2Children2 = By.cssSelector("div[data-cy='roomRow2'] ul.guestCounter li[data-cy='children-2']");
    private By roomAndGuestsApplyButton = By.className("btnApply");
    private By travelForOption = By.cssSelector("div.travelFor");
    private By travelForLeisure = By.cssSelector("li[data-cy='travelFor-Leisure']");
    private By SearchButton = By.id("hsw_search_button");
}

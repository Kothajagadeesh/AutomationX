package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public interface HotelsRepo {

    public By citySelection = By.className("selectHtlCity");
    public By cityField = By.className("input[placeholder='Enter city/ Hotel/ Area/ Building']");
    public By citySuggestionList = By.className(".react-autosuggest__section-container ul li"); //get list and text
    public By checkInDateField = By.cssSelector("label[for='checkin']");
    public By nextMonthNavButton = By.className("DayPicker-NavButton--next"); //click 3 times
    public By dayPickerDays = By.className(".DayPicker-Month div[class='DayPicker-Day'][aria-disabled='false']"); //get list, click indexes 8, 10. get property aria-label for both
    public By roomGuestsField = By.className("roomGuests");
    public By room1Adults2 = By.cssSelector("div[data-cy='roomRow1'] li[data-cy='adults-2']");
    public By room1Children2 = By.cssSelector("div[data-cy='roomRow1'] ul.guestCounter li[data-cy='children-2']");
    public By addAnotherRoomButton = By.className("btnAddRoom");
    public By room2Adults2 = By.cssSelector("div[data-cy='roomRow2'] li[data-cy='adults-2']");
    public By room2Children2 = By.cssSelector("div[data-cy='roomRow2'] ul.guestCounter li[data-cy='children-2']");
    public By roomAndGuestsApplyButton = By.className("btnApply");
    public By travelForOption = By.cssSelector("div.travelFor");
    public By travelForLeisure = By.cssSelector("li[data-cy='travelFor-Leisure']");
    public By SearchButton = By.id("hsw_search_button");
}

package repo;

import org.openqa.selenium.By;

public interface HotelsRepo {
	
	public By hotelsMenuLink = By.cssSelector(".menu_Hotels>a");
    public By citySelection = By.className("selectHtlCity");
    public By cityField = By.cssSelector("input[placeholder='Enter city/ Hotel/ Area/ Building']");
    public By citySuggestionList = By.cssSelector(".react-autosuggest__section-container ul li"); //get list and text
    public By checkInDateField = By.cssSelector("label[for='checkin']");
    public By nextMonthNavButton = By.className("DayPicker-NavButton--next"); //click 3 times
    public By dayPickerDays = By.className(".DayPicker-Month div[class='DayPicker-Day'][aria-disabled='false']"); //get list, click indexes 8, 10. get property aria-label for both
    public By roomGuestsField = By.className("roomGuests");
    public By room1Adults = By.cssSelector("div[data-cy='roomRow1'] li[data-cy*='adults-']");
    public By room1Children = By.cssSelector("div[data-cy='roomRow1'] ul.guestCounter li[data-cy*='children-']");
    public By addAnotherRoomButton = By.className("btnAddRoom");
    public By room2Adults = By.cssSelector("div[data-cy='roomRow2'] li[data-cy*='adults-']");
    public By room2Children = By.cssSelector("div[data-cy='roomRow2'] ul.guestCounter li[data-cy*='children-']");
    public By roomAndGuestsApplyButton = By.className("btnApply");
    public By travelForOption = By.cssSelector("div.travelFor");
    public By travelForLeisure = By.cssSelector("li[data-cy='travelFor-Leisure']");
    public By SearchButton = By.id("hsw_search_button");
    public By checkInDate = By.cssSelector("p[data-cy='checkInDate']");
    public By checkOutDate = By.cssSelector("p[data-cy='checkOutDate']");
}

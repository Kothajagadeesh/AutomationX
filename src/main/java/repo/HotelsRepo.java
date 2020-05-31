package repo;

import org.openqa.selenium.By;

public interface HotelsRepo {

    By hotelsMenuLink = By.cssSelector(".menu_Hotels>a");
    By citySelection = By.className("selectHtlCity");
    By cityField = By.cssSelector("input[placeholder='Enter city/ Hotel/ Area/ Building']");
    By citySuggestionList = By.cssSelector(".react-autosuggest__section-container ul li");
    By datePicker = By.cssSelector(".dayPickerHotelWrap");
    By checkInDateField = By.cssSelector("label[for='checkin']");
    By nextMonthNavButton = By.className("DayPicker-NavButton--next");
    By dayPickerDays = By.cssSelector(".DayPicker-Month div[class='DayPicker-Day']");
    By roomGuestsField = By.className("roomGuests");
    By guestSelectPopup = By.cssSelector(".roomsGuestsTop");
    By applyButton = By.cssSelector(".primaryBtn.btnApply");
    By room1Adults = By.cssSelector("div[data-cy='roomRow1'] li[data-cy*='adults-']");
    By room1Children = By.cssSelector("div[data-cy='roomRow1'] ul.guestCounter li[data-cy*='children-']");
    By addAnotherRoomButton = By.className("btnAddRoom");
    By room2Adults = By.cssSelector("div[data-cy='roomRow2'] li[data-cy*='adults-']");
    By room2Children = By.cssSelector("div[data-cy='roomRow2'] ul.guestCounter li[data-cy*='children-']");
    By roomAndGuestsApplyButton = By.className("btnApply");
    By travelForOption = By.cssSelector("div.travelFor");
    By travelForLeisure = By.cssSelector("li[data-cy='travelFor-Leisure']");
    By SearchButton = By.id("hsw_search_button");
    By checkInDate = By.cssSelector("p[data-cy='checkInDate']");
    By checkOutDate = By.cssSelector("p[data-cy='checkOutDate']");
    By adultCountLocator = By.cssSelector("li[data-cy='adults-dynamicNo']");
}

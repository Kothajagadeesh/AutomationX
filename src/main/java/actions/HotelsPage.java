package actions;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import repo.HotelsRepo;
import utils.SafeElementsActions;

public class HotelsPage extends SafeElementsActions implements HotelsRepo {

    WebDriver driver;
    Random random ;
    Logger logger = Logger.getLogger(HotelsPage.class);

    public HotelsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        random = new Random();
    }
    
    public void selectHotelMenu() {
    	click(hotelsMenuLink);
    }
    
    public void selectCity(String city)
    {
    	click(citySelection);
    	fillText(cityField, city);
    	List<WebElement> cities = driver.findElements(citySuggestionList);
    	//int randomNumber = random.nextInt(cities.size())-1;
    	cities.get(0).click();
    }
    
    public void selectRndVacationDates() {
    	click(checkInDateField);
    	for(int i=0;i<3;i++)
    		click(nextMonthNavButton);
    	List<WebElement> dates = driver.findElements(dayPickerDays);
    	int randomNumber = random.nextInt(dates.size()-5)-1;
    	dates.get(randomNumber).click();
    	dates.get(randomNumber+3).click();
    }
    
    public void selectNoOfAdultsInRoom1(int numberOfAdults) {
    	if(!isDisplayed(roomGuestsField))
    		click(roomGuestsField);
    	List<WebElement> adults = driver.findElements(room1Adults);
    	adults.get(numberOfAdults-1).click();
    }
    
    public void selectNoOfChildsInRoom1(int numberOfChilds) {
    	if(!isDisplayed(roomGuestsField))
    		click(roomGuestsField);
    	List<WebElement> childs = driver.findElements(room1Children);
    	childs.get(numberOfChilds-1).click();
    }
    
    public void addRoom() {
    	click(addAnotherRoomButton);
    }
    public void selectNoOfAdultsInRoom2(int numberOfAdults) {
    	if(!isDisplayed(roomGuestsField))
    		click(roomGuestsField);
    	List<WebElement> adults = driver.findElements(room2Adults);
    	adults.get(numberOfAdults-1).click();
    }
    
    public void selectNoOfChildsInRoom2(int numberOfChilds) {
    	if(!isDisplayed(roomGuestsField))
    		click(roomGuestsField);
    	List<WebElement> childs = driver.findElements(room2Children);
    	childs.get(numberOfChilds-1).click();
    }
    
    public void applyFilter()
    {
    	click(roomAndGuestsApplyButton);
    }
    
    public void searchHotels() {
    	click(SearchButton);
    }
    
    public void getCheckInDate() {
    	getText(checkInDate);
    }
    
    public void getCheckOutDate() {
    	getText(checkOutDate);
    }
}
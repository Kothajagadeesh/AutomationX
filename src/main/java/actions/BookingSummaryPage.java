package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import repo.BookingSummaryRepo;
import utils.SafeElementsActions;

public class BookingSummaryPage  extends SafeElementsActions implements BookingSummaryRepo{

	WebDriver driver;
    Random random ;
    Logger logger = Logger.getLogger(HotelsPage.class);

    public BookingSummaryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        random = new Random();
    }
    
    public String getHotelName() {
    	return getText(hotelName);
    }
    
    public String getHotelLocation() {
    	return getText(hotelLocation);
    }
    
    public String getTravellerName() {
    	return getText(travellerName);
    }
    
    public String getContactInto() {
    	return getText(contactInfo);
    }
    
    public String getFinalPayableAmount() {
    	return getText(finalAmmount);
    }
    
    public String getPaymentAmount() {
    	return getText(hotelName);
    }
    
    public String getCheckInTime() {
    	return getText(checkInTime);
    }
    
    public String getCheckOutTime() {
    	return getText(checkOutTime);
    }
    
    public ArrayList<String> roomsInfo() {
    	ArrayList<String> roomNames = null;
    	List<WebElement> rooms = driver.findElements(roomsInfo);
    	for(WebElement room:rooms)
    		roomNames.add(room.getText());
    	
    	return roomNames;
    }
    
    public ArrayList<String> adultsInfo() {
    	ArrayList<String> adultNames = null;
    	List<WebElement> adults = driver.findElements(adultsInfo);
    	for(WebElement adult:adults)
    		adultNames.add(adult.getText());
    	
    	return adultNames;
    }
    
    public String getPriceBreakUpInfo() {
    	return getText(priceBreakUp);
    }
}

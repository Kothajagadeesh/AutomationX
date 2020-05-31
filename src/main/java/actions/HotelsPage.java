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
    	
    }
    
    public void selectCity()
    {
    	click(citySelection);
    	fillText(cityField, "Hyderabad");
    	List<WebElement> cities = driver.findElements(citySuggestionList);
    	int randomNumber = random.nextInt(cities.size())-1;
    	cities.get(randomNumber).click();
    }
    
    public void selectCheckInCheckOutDate() {
    	for(int i=0;i<3;i++)
    		click(nextMonthNavButton);
    	List<WebElement> dates = driver.findElements(dayPickerDays);
    	int randomNumber = random.nextInt(dates.size()-5)-1;
    	dates.get(randomNumber).click();
    	dates.get(randomNumber+3).click();
    }
    
    public void selectNumberOfRooms() {
    	
    }
}

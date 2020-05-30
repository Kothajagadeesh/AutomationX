package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import repo.HotelSearchResultsRepo;
import utils.SafeElementsActions;

public class HotelSearchResultsPage extends SafeElementsActions implements HotelSearchResultsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelSearchResultsPage.class);

    public HotelSearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import repo.HotelSearchResultsRepo;
import utils.SafeElementsActions;

import java.util.List;

public class HotelSearchResultsPage extends SafeElementsActions implements HotelSearchResultsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelSearchResultsPage.class);

    public HotelSearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectUserRating(String sRating) {
        List<WebElement> ratings = driver.findElements(userRatingLabels);
        for (int i = 0; i < ratings.size() - 1; i++) {
            String userRating = ratings.get(i).getText();
            if (userRating.contains(sRating)) {
                ratings.get(i).click();
            }
        }
    }

    public void hotelsLoading() {
        List<WebElement> loadingSymbol = driver.findElements(hotelsLoading);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        if (loadingSymbol.size() > 0)
            wait.until(ExpectedConditions.invisibilityOfElementLocated(hotelsLoading));
    }

    public String selectHotel(int result) {
        String selectedHotel = "";
        for (int i = 0; i < 5; i++) {
            List<WebElement> hotelResults = driver.findElements(hotelNames);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (hotelResults.size() >= result) {
                hotelResults.get(result - 1).click();
                selectedHotel = hotelResults.get(result - 1).getText();
                break;
            } else
                js.executeScript("window.scrollBy(0,1000)");
        }
        return selectedHotel;
    }
}

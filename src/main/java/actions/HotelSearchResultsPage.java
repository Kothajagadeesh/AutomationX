package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import repo.HotelSearchResultsRepo;
import utils.Config;
import utils.SafeElementsActions;

import java.util.List;
import java.util.Set;

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
        hotelsLoading();
    }

    public void dismissLocationPopUp() {
        if (waitUntilElementDisplayed(locationPopUp,  Config.getTimeOut())) {
            driver.navigate().refresh();
        }
    }

    public void selectMinPriceRangeFromFilter(int minPriceRange) {
        waitUntilElementDisplayed(sliderMinRange,  Config.getTimeOut());
        Actions ac = new Actions(driver);
        switch (minPriceRange) {
            case 1000:
                ac.dragAndDropBy(driver.findElement(sliderMinRange), 8, 0);
                break;
            case 1500:
                ac.dragAndDropBy(driver.findElement(sliderMinRange), 10, 0);
                break;
            case 2000:
                ac.dragAndDropBy(driver.findElement(sliderMinRange), 12, 0);
                break;
        }
        ac.build().perform();
        hotelsLoading();
    }

    public void hotelsLoading() {
        List<WebElement> loadingSymbol = driver.findElements(hotelsLoading);
        WebDriverWait wait = new WebDriverWait(driver, Config.getTimeOut());
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

    public void switchToNewTab(String parentWindow) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equalsIgnoreCase(parentWindow)) {
                logger.info("Switch to window: " + handle);
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}

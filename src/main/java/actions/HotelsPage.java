package actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import repo.HotelsRepo;
import utils.SafeElementsActions;

public class HotelsPage extends SafeElementsActions implements HotelsRepo {

    WebDriver driver;
    Random random;
    Logger logger = Logger.getLogger(HotelsPage.class);

    public HotelsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        random = new Random();
    }

    public void selectHotelMenu() {
        click(hotelsMenuLink);
    }

    public void selectCity(String city) {
        click(citySelection);
        fillText(cityField, city);
        staticWait(2000);
        List<WebElement> cities = driver.findElements(citySuggestionList);
        cities.get(0).click();
    }

    public void selectRndVacationDates() {
        if (!waitUntilElementDisplayed(datePicker, 3))
            click(checkInDateField);
        for (int i = 0; i < 3; i++)
            click(nextMonthNavButton);
        waitUntilElementDisplayed(dayPickerDays, 5);
        List<WebElement> dates = driver.findElements(dayPickerDays);
        int randomNumber = random.nextInt(dates.size() - 5) - 1;
        dates.get(randomNumber).click();
        dates.get(randomNumber + 3).click();
    }

    public void selectAdultAndChildCount(int adultCount, int childCount) {
        click(roomGuestsField);
        By adultCountLocator = By.cssSelector("li[data-cy='adults-" + adultCount + "']");
        click(adultCountLocator);
        if (!waitUntilElementDisplayed(guestSelectPopup, 5))
            click(roomGuestsField);
        By childCountLocator = By.cssSelector("li[data-cy='children-" + childCount + "']");
        click(childCountLocator);
    }

    public void getTravelingFor(String reason) {
        click(travelForOption);
        click(travelForLeisure);
    }

    public void clickApplyButton() {
        if (waitUntilElementDisplayed(applyButton, 5))
            click(applyButton);
    }

    public void addRoom() {
        click(addAnotherRoomButton);
    }

    public void searchHotels() {
        click(SearchButton);
    }

    public String getCheckInDate() {
        return convertDate(checkInDate);
    }

    private String convertDate(By checkInDate) {
        String sDate1 = getText(checkInDate);
        SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMMyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MMM/yyyy");
        sDate1 = sDate1.replace("'", "").replace("  ", "").replace(" ", "");
        Date date = null;
        try {
            date = formatter1.parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter2.format(date);
    }

    public String getCheckOutDate() {
        return convertDate(checkOutDate);
    }
}
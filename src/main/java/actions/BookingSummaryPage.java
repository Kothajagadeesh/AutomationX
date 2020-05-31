package actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import repo.BookingSummaryRepo;
import utils.SafeElementsActions;

public class BookingSummaryPage extends SafeElementsActions implements BookingSummaryRepo {

    WebDriver driver;
    Random random;
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
        return getText(travellerName).trim();
    }

    public String getContactInfo() {
        return getText(contactInfo);
    }

    public String getRoomType() {
        return getText(roomType).trim();
    }

    public String getFinalPayableAmount() {
        return getText(finalAmmount);
    }

    public String getCheckInTime() {
        return convertDate(checkInTime);
    }

    public String getCheckOutTime() {
        return convertDate(checkOutTime);
    }

    private String convertDate(By checkInDate) {
        String sDate1 = getText(checkInDate);
        SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMMyyyy");
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
}

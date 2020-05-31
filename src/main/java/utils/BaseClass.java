package utils;

import actions.*;
import org.openqa.selenium.WebDriver;
import repo.HotelDetailsRepo;

public class BaseClass extends BrowserInit {

    public HomePage homePage;
    public BookingSummaryPage bookingSummaryPage;
    public HotelDetailsPage hotelDetailsPage;
    public HotelSearchResultsPage hotelSearchResultsPage;
    public HotelsPage hotelsPage;
    public ReviewBookingPage reviewBookingPage;

    public void initPages(WebDriver driver) {
        homePage = new HomePage(driver);
        bookingSummaryPage = new BookingSummaryPage(driver);
        hotelDetailsPage = new HotelDetailsPage(driver);
        hotelSearchResultsPage = new HotelSearchResultsPage(driver);
        hotelsPage = new HotelsPage(driver);
        reviewBookingPage = new ReviewBookingPage(driver);
    }
}

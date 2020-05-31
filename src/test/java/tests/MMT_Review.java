package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.BaseClass;
import utils.Config;
import utils.listeners.TestNgListener;

@Listeners(TestNgListener.class)
public class MMT_Review extends BaseClass {

    WebDriver driver;
    TestNgListener testNgListener = new TestNgListener();
    String firstName = Config.getFirstName();
    String lastName = Config.getLastName();
    String email = Config.getEmail();
    String phone = Config.getMobileNo();
    String country = Config.getCountry();
    String city = Config.getCity();
    String rating = Config.getRating();
    String leasire = Config.getRating();


    @BeforeClass
    public void setup() {
        initDriver();
        driver = getDriver();
        initPages(driver);
    }

    @BeforeMethod
    public void init() {
        driver.get(Config.getUrl());
    }

    @Test
    public void TTT_Atuomation() {

        String windowHandle = driver.getWindowHandle();
        homePage.selectCountry(country);
        homePage.getLoginFrame();
        homePage.login(Config.getUserName(), Config.getPassword());
        homePage.checkLoggedInUser();

        //hotel filter
        hotelsPage.selectHotelMenu();
        hotelsPage.selectCity(city);
        hotelsPage.selectRndVacationDates();
        hotelsPage.selectAdultAndChildCount(2, 2);

        hotelsPage.addRoom();
        hotelsPage.selectAdultAndChildCount(2, 2);
        hotelsPage.getTravelingFor(leasire);

        hotelsPage.clickApplyButton();
        String actualCheckInDate = hotelsPage.getCheckInDate();
        String actualCheckOutDate = hotelsPage.getCheckOutDate();
        hotelsPage.searchHotels();

        hotelSearchResultsPage.dismissLocationPopUp();
        hotelSearchResultsPage.selectMinPriceRangeFromFilter(1000);

        //hotels search
        hotelSearchResultsPage.selectUserRating(rating);
        String actualHotelName = hotelSearchResultsPage.selectHotel(5);
        hotelSearchResultsPage.switchToNewTab(windowHandle);

        String actualLocation = hotelDetailsPage.getHotelLocation();

        //hotel details page
        hotelDetailsPage.clickRoomsTab();
        String firstRoomType = hotelDetailsPage.getFirstRoomType();
        // hotelDetailsPage.selectFirstRoom(); //TODO Handle

        reviewBookingPage.enterName(firstName, lastName);
        reviewBookingPage.enterEmailID(email);
        reviewBookingPage.enterIndianMobile(phone);

        reviewBookingPage.selectCommonRequests("Large bed");
        reviewBookingPage.selectCommonRequests("Twin beds");

        reviewBookingPage.setDonationCheckbox(false);
        String actualPrice = reviewBookingPage.getTotalPrice();

        reviewBookingPage.clickPayNowButton();

        //actual assertions
        String expectedHotelName = bookingSummaryPage.getHotelName();
        String expectedLocation = bookingSummaryPage.getHotelLocation();
        String expectedCheckInDate = bookingSummaryPage.getCheckInTime();
        String expectedCheckOutDate = bookingSummaryPage.getCheckOutTime();
        String expectedFullName = bookingSummaryPage.getTravellerName();
        String expectedContactInfo = bookingSummaryPage.getContactInfo();
        String expectedRoomType = bookingSummaryPage.getRoomType();
        String expectedFinalPrice = bookingSummaryPage.getFinalPayableAmount();

        testNgListener.assertFailAndContinue(driver, expectedHotelName.equalsIgnoreCase(actualHotelName), "Expected hotel name not matched with actual");
        testNgListener.assertFailAndContinue(driver, expectedLocation.contains(actualLocation), "Expected hotel location not matched with actual");
        testNgListener.assertFailAndContinue(driver, expectedCheckInDate.contains(actualCheckInDate), "Expected hotel location not matched with actual");
        testNgListener.assertFailAndContinue(driver, expectedCheckOutDate.contains(actualCheckOutDate), "Expected hotel location not matched with actual");
        testNgListener.assertFailAndContinue(driver, expectedFullName.equalsIgnoreCase(firstName + " " + lastName), "Expected full name not matched with actual");
        testNgListener.assertFailAndContinue(driver, expectedContactInfo.equalsIgnoreCase(phone + ", " + email), "Expected contact info not matched with actual");
        testNgListener.assertFailAndContinue(driver, expectedRoomType.contains(firstRoomType), "Expected room type not matched with actual");
        testNgListener.assertFailAndContinue(driver, actualPrice.contains(expectedFinalPrice), "Expected price not matched with actual");

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}

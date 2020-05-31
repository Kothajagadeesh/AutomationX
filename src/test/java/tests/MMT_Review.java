package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.BaseClass;
import utils.listeners.TestNgListener;

@Listeners(TestNgListener.class)
public class MMT_Review extends BaseClass {

    WebDriver driver;
    TestNgListener testNgListener = new TestNgListener();

    @BeforeClass
    public void setup() {
        initDriver();
        driver = getDriver();
        initPages(driver);
    }

    @BeforeMethod
    public void init() {
        driver.get("https://www.makemytrip.com/");
    }

    @Test
    public void TTT_Atuomation() {
        String firstName = "jk";
        String lastName = "kl";
        String email = "jk@yopmail.com";
        String phone = "9898989898";
        String windowHandle = driver.getWindowHandle();
        //homePage.login("", "");

        //hotel filter
        hotelsPage.selectHotelMenu();
        hotelsPage.selectCity("Hyderabad");  //TODO: need to remove static waits
        hotelsPage.selectRndVacationDates();
        hotelsPage.selectAdultAndChildCount(2, 2);

        hotelsPage.addRoom();
        hotelsPage.selectAdultAndChildCount(2, 2);
        hotelsPage.clickApplyButton();
        String actualCheckInDate = hotelsPage.getCheckInDate();
        String actualCheckOutDate = hotelsPage.getCheckOutDate();
        hotelsPage.searchHotels();

        hotelSearchResultsPage.selectMinPriceRangeFromFilter(1000);

        //hotels search
        hotelSearchResultsPage.selectUserRating("4 & above (Very Good)");
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


        //exp check in date  > 16 Sep ' 2020 Wed
        //actual exp date> 16 Sep20
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}

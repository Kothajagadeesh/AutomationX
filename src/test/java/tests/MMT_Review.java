package tests;

import actions.HotelSearchResultsPage;
import actions.HotelsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.BaseClass;
import utils.listeners.TestNgListener;

@Listeners(TestNgListener.class)
public class MMT_Review extends BaseClass {

    WebDriver driver;
    TestNgListener listener = new TestNgListener();

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
        //homePage.login("", "");

        //hotel filter
        hotelsPage.selectHotelMenu();
        hotelsPage.selectCity("Hyderabad");  //TODO: need to remove static waits
        hotelsPage.selectRndVacationDates();
        hotelsPage.selectNoOfAdultsInRoom1(2);
        hotelsPage.selectNoOfChildsInRoom1(2);
        hotelsPage.addRoom();
        hotelsPage.selectNoOfAdultsInRoom2(2);
        hotelsPage.selectNoOfChildsInRoom2(2);
        hotelsPage.searchHotels();

        //hotels search
        hotelSearchResultsPage.selectUserRating("4");
        hotelSearchResultsPage.hotelsLoading();
        hotelSearchResultsPage.selectHotel(5);

        //hotel details page
        hotelDetailsPage.clickRoomsTab();
        hotelDetailsPage.getFirstRoomType();

        reviewBookingPage.enterName("jk", "kl");
        reviewBookingPage.enterEmailID("jk@testemail.com");
        reviewBookingPage.enterIndianMobile("");

        reviewBookingPage.selectCommonRequests("Large bed");
        reviewBookingPage.selectCommonRequests("Twin beds");

        reviewBookingPage.setDonationCheckbox(false);
        reviewBookingPage.clickPayNowButton();

    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}

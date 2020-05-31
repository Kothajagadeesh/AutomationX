package repo;

import org.openqa.selenium.By;

public interface BookingSummaryRepo {

    By hotelName = By.cssSelector("p.pymt-htlInfo-name");
    By hotelLocation = By.cssSelector("p.pymt-htlInfo-loc");
    By travellerName = By.className("traveler_name");
    By contactInfo = By.className("contact_info");
    By finalAmmount = By.id("top_rail_totalAmount");
    By paymentAmount = By.id("PAYMENT_amount");
    By checkInTime = By.cssSelector("div.checkin p.checkin_time span");
    By checkOutTime = By.cssSelector("div.checkout p.checkin_time span");
    By roomsInfo = By.cssSelector("div.hotel_room_details span.labelinfo");
    By adultsInfo = By.cssSelector("div.hotel_room_details span.adult_info");
    By priceBreakUp = By.className("flightsidebar_trigger");
    By roomType = By.cssSelector(".room_heading.lato-semibold");
}

package repo;

import org.openqa.selenium.By;

public interface BookingSummaryRepo {
	public By hotelName = By.cssSelector("p.pymt-htlInfo-name");
    public By hotelLocation = By.cssSelector("p.pymt-htlInfo-loc");
    public By travellerName = By.className("traveler_name");
    public By contactInfo = By.className("contact_info");
    public By finalAmmount = By.id("top_rail_totalAmount");
    public By paymentAmount = By.id("PAYMENT_amount");
    public By checkInTime = By.cssSelector("div.checkin p.checkin_time");
    public By checkOutTime = By.cssSelector("div.checkout p.checkin_time");
    public By roomsInfo = By.cssSelector("div.hotel_room_details span.labelinfo");
    public By adultsInfo = By.cssSelector("div.hotel_room_details span.adult_info");
    public By priceBreakUp = By.className("flightsidebar_trigger");
}

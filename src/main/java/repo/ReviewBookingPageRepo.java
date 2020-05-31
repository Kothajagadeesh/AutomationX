package repo;

import org.openqa.selenium.By;

public interface ReviewBookingPageRepo {
    public By modal = By.cssSelector("div.modalCont");
    public By modalClose = By.cssSelector("div.modalCont>span");
    public By reviewBookingHeader = By.cssSelector("div.hotelReviewHeader h4");
    public By titleList = By.cssSelector("select#title");
    public By titleListOption = By.cssSelector("select#title option[value='Mrs']");
    public By firstNameField = By.cssSelector("input#fName");
    public By lastNameField = By.cssSelector("input#lName");
    public By emailIDField = By.cssSelector("input#email");
    public By mobileNoField = By.cssSelector("input#mNo");
    public By commonRequests = By.cssSelector("div._SpecialRequest>ul>li span.makeFlex");
    public By donationCheckbox = By.cssSelector("input#donation");
    public By agreeCheckbox = By.cssSelector("input#agree");
    public By payNowButton = By.cssSelector("a.btnPayNow");
}

package repo;

import org.openqa.selenium.By;

public interface ReviewBookingPageRepo {
    By modal = By.cssSelector("div.modalCont");
    By modalClose = By.cssSelector("div.modalCont>span");
    By reviewBookingHeader = By.cssSelector("div.hotelReviewHeader h4");
    By titleList = By.cssSelector("select#title");
    By titleListOption = By.cssSelector("select#title option[value='Mrs']");
    By firstNameField = By.cssSelector("input#fName");
    By lastNameField = By.cssSelector("input#lName");
    By emailIDField = By.cssSelector("input#email");
    By mobileNoField = By.cssSelector("input#mNo");
    By commonRequests = By.cssSelector("div._SpecialRequest>ul>li span.makeFlex");
    By donationCheckbox = By.cssSelector("input#donation");
    By donationCheckboxTest = By.cssSelector("label[for='donation']");
    By agreeCheckbox = By.cssSelector("input#agree");
    By payNowButton = By.cssSelector("a.btnPayNow");
    By finalPrice = By.id("revpg_total_payable_amt");
}

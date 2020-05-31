package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import repo.ReviewBookingPageRepo;
import utils.SafeElementsActions;

import java.util.List;

public class ReviewBookingPage extends SafeElementsActions implements ReviewBookingPageRepo {

    WebDriver driver;

    public ReviewBookingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void closeModalIfExists() {
        List<WebElement> modalDialog = driver.findElements(modal);
        if (modalDialog.size() > 0)
            click(modalClose);
    }

    public boolean isHeaderExists() {
        return isDisplayed(reviewBookingHeader);
    }

    public void setTitle() {
        click(titleList);
        click(titleListOption);
    }

    public void enterName(String sFname, String sLanme) {
        clearAndFillText(firstNameField, sFname);
        clearAndFillText(lastNameField, sLanme);
    }

    public String getTotalPrice() {
        return getText(finalPrice);
    }

    public void enterEmailID(String sEmailID) {
        clearAndFillText(emailIDField, sEmailID);
    }

    public void enterIndianMobile(String sMobileNo) {
        clearAndFillText(mobileNoField, sMobileNo);
    }

    public void selectCommonRequests(String sCommonRequest) {
        List<WebElement> requests = driver.findElements(commonRequests);
        for (int i = 0; i < requests.size() - 1; i++) {
            String sRequest = requests.get(i).getAttribute("innerText");
            if (sRequest.contains(sCommonRequest)) {
                requests.get(i).click();
                break;
            }
        }
    }

    public boolean isDonationChecked() {
        return isSelected(donationCheckbox);
    }

    public void setDonationCheckbox(boolean checkIt) {
        boolean alreadySelected = isDonationChecked();

        //only click if the test's intent does not match the current state
        if ((checkIt && !alreadySelected) || (!checkIt && alreadySelected)) {
            click(donationCheckboxTest);
        }
    }

    public boolean isAgreeChecked() {
        return isSelected(agreeCheckbox);
    }

    public void setAgreeCheckbox(boolean checkIt) {
        boolean alreadySelected = isAgreeChecked();

        //only click if the test's intent does not match the current state
        if ((checkIt && !alreadySelected) || (!checkIt && alreadySelected)) {
            click(agreeCheckbox);
        }
    }

    public void clickPayNowButton() {
        click(payNowButton);
    }
}

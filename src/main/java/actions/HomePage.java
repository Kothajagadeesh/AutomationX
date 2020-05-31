package actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import repo.HomePageRepo;
import utils.Config;
import utils.SafeElementsActions;

public class HomePage extends SafeElementsActions implements HomePageRepo {
    WebDriver driver;
    Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectCountry(String sCountry) {
        click(countrySelect);
        List<WebElement> countries = driver.findElements(countryList);
        for (WebElement country : countries)
            if (country.getText().equals(sCountry))
                country.click();
    }

    public void getLoginFrame() {
        click(accountButton);
    }

    public void enterUserName(String userName) {
        fillText(usernameField, userName);
    }

    public void enterPassword(String sPassword) {
        fillText(passwordField, sPassword);
    }

    public void clickContinueButton() {
        waitUntilElementDisplayed(continueButton);
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(continueButton));
        click(continueButton);
        click(continueButton);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void login(String sUserName, String sPassword) {
        enterUserName(sUserName);
        clickContinueButton();
        enterPassword(sPassword);
        clickLoginButton();
    }

    public void checkLoggedInUser(){
        waitUntilElementDisplayed(loggedInUser,10);
    }
}

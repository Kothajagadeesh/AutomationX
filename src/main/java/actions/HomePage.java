package actions;

import java.util.List;

import org.apache.log4j.Logger;
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

    public void selectCountry() {
        click(countrySelect);
        List<WebElement> countries = driver.findElements(countryList);
        for (WebElement country : countries)
            if (country.getText().equals("India"))
                country.click();
    }

    public void getLoginFrame() {
        click(accountButton);
    }

    public void enterUserName() {
        fillText(usernameField, Config.getUserName());
    }

    public void enterPassword() {
        fillText(usernameField, Config.getPassword());
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void login(String sUserName, String sPassword) {
        enterUserName();
        clickContinueButton();
        enterPassword();
        clickLoginButton();
    }
}

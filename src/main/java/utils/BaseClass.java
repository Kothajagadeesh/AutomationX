package utils;

import actions.HomePage;
import org.openqa.selenium.WebDriver;

public class BaseClass extends BrowserInit {

    public HomePage homePage;

    public void initPages(WebDriver driver) {
        homePage = new HomePage(driver);

    }
}

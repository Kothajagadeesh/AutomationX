package actions;

import repo.HomePageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomePageRepo {
    WebDriver driver;
    Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

package actions;

import org.openqa.selenium.By;
import repo.HomePageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.SafeElementsActions;

public class HomePage extends SafeElementsActions implements HomePageRepo{
    WebDriver driver;
    Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

package actions;

import org.openqa.selenium.By;
import repo.HomePageRepo;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomePageRepo {
    WebDriver driver;
    Logger logger = Logger.getLogger(HomePage.class);

    private By countrySelect = By.className("ctrySelect"); //check for visibility first
    private By countryList = By.className("div.ctryList span.countryName"); //Get list of elements and text. click on by text passed from method
    private By accountButton = By.cssSelector("li[data-cy='account']");
    private By loginModal = By.className("modalMain"); //confirm if modal is loaded
    private By usernameField = By.id("username");
    private By continueButton = By.cssSelector("button[data-cy='continueBtn']");
    private By passwordField = By.cssSelector("button[data-cy='login']");
    //login verification with below locators. First click above accountButton then below
    private By loggedInUser = By.cssSelector("li[data-cy='account'] .userDropdown>p"); //get text and verify email
    private By hotelsMenuLink = By.cssSelector(".menu_Hotels>a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //setDriver(driver);
    }
}

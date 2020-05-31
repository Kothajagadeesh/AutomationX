package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public interface HomePageRepo  {

    public By countrySelect = By.className("ctrySelect"); //check for visibility first
    public By countryList = By.className("div.ctryList span.countryName"); //Get list of elements and text. click on by text passed from method
    public By accountButton = By.cssSelector("li[data-cy='account']");
    public By loginModal = By.className("modalMain"); //confirm if modal is loaded
    public By usernameField = By.id("username");
    public By continueButton = By.cssSelector("button[data-cy='continueBtn']");
    public By passwordField = By.cssSelector("button[data-cy='login']");
    //login verification with below locators. First click above accountButton then below
    public By loggedInUser = By.cssSelector("li[data-cy='account'] .userDropdown>p"); //get text and verify email
    public By hotelsMenuLink = By.cssSelector(".menu_Hotels>a");
}

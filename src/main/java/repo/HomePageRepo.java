package repo;

import org.openqa.selenium.By;
import utils.SafeElementsActions;

public interface HomePageRepo {

    By countrySelect = By.className("ctrySelect"); //check for visibility first
    By countryList = By.className("div.ctryList span.countryName"); //Get list of elements and text. click on by text passed from method
    By accountButton = By.cssSelector("li[data-cy='account']");
    By loginModal = By.className("modalMain"); //confirm if modal is loaded
    By usernameField = By.id("username");
    By continueButton = By.cssSelector("button[data-cy='continueBtn']");
    By passwordField = By.cssSelector("button[data-cy='login']");
    //login verification with below locators. First click above accountButton then below
    By loggedInUser = By.cssSelector("li[data-cy='account'] .userDropdown>p"); //get text and verify email
    By hotelsMenuLink = By.cssSelector(".menu_Hotels>a");
}

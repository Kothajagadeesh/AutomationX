package repo;

import org.openqa.selenium.By;

public interface HomePageRepo {

    public By countrySelect = By.className("ctrySelect"); //check for visibility first
    public By countryList = By.className("div.ctryList span.countryName"); //Get list of elements and text. click on by text passed from method
    public By accountButton = By.cssSelector("li[data-cy='account']");
    public By loginModal = By.className("modalMain"); //confirm if modal is loaded
    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By continueButton = By.cssSelector(".btnContainer button span");
    public By loginButton = By.cssSelector("button[data-cy='login']");
    //login verification with below locators. First click above accountButton then below
    public By loggedInUser = By.cssSelector("p[data-cy='account']"); //get text and verify email
}

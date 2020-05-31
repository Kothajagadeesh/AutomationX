package repo;

import org.openqa.selenium.By;

public interface HomePageRepo {

	By countrySelect = By.className("ctrySelect");
	By countryList = By.className("div.ctryList span.countryName");
	By accountButton = By.cssSelector("li[data-cy='account']");
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By continueButton = By.cssSelector("button[data-cy='continueBtn']");
	By loginButton = By.cssSelector("button[data-cy='login']");
	By loggedInUser = By.cssSelector("p[data-cy='account']");
}

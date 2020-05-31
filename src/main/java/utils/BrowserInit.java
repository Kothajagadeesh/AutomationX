package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserInit {

    public WebDriver driver;
    public static String projectPath = System.getProperty("user.dir");
    public static String osType = System.getProperty("os.name").toLowerCase();
    Logger logger = Logger.getLogger(BrowserInit.class);

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        if (driver == null) initDriver();
        return driver;
    }

    public WebDriver initDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browser = Config.getBrowserType().toLowerCase();
        String execType = Config.getExecType().toLowerCase();

        if (execType.equalsIgnoreCase("local")) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            maximizeDriverWindow(driver);
        } else if (execType.equalsIgnoreCase("headspin")) {
            try {
                capabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("https://dev-us-pao-0.headspin.io:9093/v0/2963762127b64f39bc1e91f5bf50bd81/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                logger.warn("Exception with remote web driver URL" + e);
            }
        }

        setDriver(driver);
        return driver;
    }

    private void maximizeDriverWindow(WebDriver driver) {
        if (driver != null) driver.manage().window().maximize();
    }

}

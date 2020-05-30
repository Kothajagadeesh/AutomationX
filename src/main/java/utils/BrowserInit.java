package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserInit {

    public WebDriver driver;
    public static String projectPath = System.getProperty("user.dir");
    public static String osType = System.getProperty("os.name").toLowerCase();

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        if (driver == null) initDriver();
        return driver;
    }

    public WebDriver initDriver() {
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        String browser = Config.getBrowserType();
        String execType = Config.getExecType();

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
        setDriver(driver);
        return driver;
    }

    private void maximizeDriverWindow(WebDriver driver) {
        if (driver != null) driver.manage().window().maximize();
    }

}

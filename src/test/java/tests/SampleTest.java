package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import utils.BaseClass;
import utils.listeners.TestNgListener;

@Listeners(TestNgListener.class)
public class SampleTest extends BaseClass {

    WebDriver driver;
    TestNgListener testNgListener3 = new TestNgListener();

    @BeforeClass
    public void setUp() {
        initDriver();
        driver = getDriver();
        initPages(driver);
    }

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&checkin=06012020&checkout=06022020&city=CTGOI&country=IN&locusId=CTGOI&locusType=city&roomStayQualifier=2e0e&searchText=Goa%2C%20India&visitorId=137b3a9d-94b9-4e6b-bbd2-fbb48b3e344e");
    }

    /*@Test
    public void googleType() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("hello");

        testNgListener3.AssertFailAndContinue(1 == 1, "checking Test1 assertion passed");
    }*/

    @Test
    public void googleType2() {
        By na = By.cssSelector("div.input-range__slider");
        //driver.findElement(By.name("q")).sendKeys("hello world");
        Actions ac = new Actions(driver);
        ac.dragAndDropBy(driver.findElement(na), 8, 0).build().perform();
        //homePage.fillText(na, "test");
        driver.navigate().refresh();

        //8:1000
        //10:1500
        //12:2000
        //26:2500

        //testNgListener3.logWarning("This method is for entering warning message");
        testNgListener3.assertFailAndContinue(driver, 1 == 1, "checking Test1 assertion");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}

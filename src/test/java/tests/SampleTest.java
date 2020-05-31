package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.get("http://www.google.com");
    }

    /*@Test
    public void googleType() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("hello");

        testNgListener3.AssertFailAndContinue(1 == 1, "checking Test1 assertion passed");
    }*/

    @Test
    public void googleType2() throws InterruptedException {
        By na = By.name("q");
        //driver.findElement(By.name("q")).sendKeys("hello world");
        homePage.fillText(na, "test");

        //testNgListener3.logWarning("This method is for entering warning message");
        testNgListener3.AssertFailAndContinue(driver, 1 == 2, "checking Test1 assertion");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}

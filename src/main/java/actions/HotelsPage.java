package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import repo.HotelsRepo;
import utils.SafeElementsActions;

public class HotelsPage extends SafeElementsActions implements HotelsRepo {

    WebDriver driver;
    Logger logger = Logger.getLogger(HotelsPage.class);

    public HotelsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

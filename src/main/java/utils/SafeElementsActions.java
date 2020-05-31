package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafeElementsActions {
    Logger logger = Logger.getLogger(SafeElementsActions.class);
    WebDriver driver;

    public SafeElementsActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * If the locator is a text entry element(input or textarea), this will clear the value.
     *
     * @param locator to be clear
     */
    public void clear(By locator) {
        waitUntilElementDisplayed(locator);
        driver.findElement(locator).clear();
        logger.info("Text in the locator -  " + locator + " - is removed");
    }

    /**
     * Click this element
     *
     * @param locator to be clicked
     */
    public void click(By locator) {
        waitUntilElementDisplayed(locator);
        try {
            driver.findElement(locator).click();
            logger.info("Clicked on locator - " + locator);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the value of the given attribute of the driver.findElement(locator).
     *
     * @param locator   to be performed
     * @param attribute of the element
     * @return string if the attribute found else return null
     */
    public String getAttribute(By locator, String attribute) {
        waitUntilElementDisplayed(locator);
        return driver.findElement(locator).getAttribute(attribute);
    }

    /**
     * Get the css property of the element
     *
     * @param locator     to be performed
     * @param cssProperty the css property name of the element
     * @return The current, computed value of the property.
     */
    public String getCssvalue(By locator, String cssProperty) {
        waitUntilElementDisplayed(locator);
        logger.info("getting css value for locaor " + locator);
        return driver.findElement(locator).getCssValue(cssProperty);
    }

    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element, including sub-elements,
     * without any leading or trailing whitespace.
     *
     * @param locator to be found
     * @return The innerText of this driver.findElement(locator).
     */
    public String getText(By locator) {
        logger.info("getting Text for locaor " + locator);
        return driver.findElement(locator).getText();
    }

    /**
     * Get the tag name of this driver.findElement(locator).
     *
     * @param locator to be found
     * @return The tag name of this driver.findElement(locator).
     */
    public String getTagName(By locator) {
        logger.info("getting tag name for locaor " + locator);
        waitUntilElementDisplayed(locator);
        try {
            return driver.findElement(locator).getTagName();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Is this locator displayed or not?
     *
     * @param locator to be found
     * @return Whether or not the locator is displayed
     */
    public boolean isDisplayed(By locator) {
        logger.info("Checking element visibility" + locator);
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Is the locator currently enabled or not?
     *
     * @param locator to be found
     * @return True if the locator is enabled, false otherwise.
     */
    public boolean isEnabled(By locator) {
        logger.info("Checking element enable" + locator);
        try {
            return driver.findElement(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determine whether or not this locator is selected or not
     * This operation only applies to input elements such as checkboxes, options in a select and radio buttons.
     *
     * @param locator to be found
     * @return True if the locator is currently selected or checked, false otherwise
     */
    public boolean isSelected(By locator) {
        logger.info("Checking element selection" + locator);
        waitUntilElementDisplayed(locator, 5);
        try {
            return driver.findElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to simulate typing into an element, which may set its value.
     *
     * @param locator to be found
     * @param text    to send to the element
     */
    public void fillText(By locator, String text) {
        logger.info("entering text in element field" + locator);
        waitUntilElementDisplayed(locator);
        try {
            driver.findElement(locator).sendKeys(text);
        } catch (IllegalArgumentException e) {
            logger.info("Please check the text you have passed: " + text);
        }
    }

    /**
     * This method will perform both clear and fill text
     *
     * @param locator to be found
     * @param text    to send to the element
     */
    public void clearAndFillText(By locator, String text) {
        logger.info("clearing and entering text in element field" + locator);
        try {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        } catch (IllegalArgumentException e) {
            logger.info("Please check the text you have passed: " + text);
        }
    }

    /**
     * If the current locator is a form, or an locator within a form,
     * then this will be submitted to the remote server.
     *
     * @param locator to be found
     */
    public void submit(By locator) {
        logger.info("submit form" + locator);
        try {
            driver.findElement(locator).submit();
        } catch (NoSuchElementException e) {
            logger.info("element: " + locator + " - is not found in the current page");
        }
    }

    /**
     * waits until the locator is found
     *
     * @param locator to be found
     * @return True if elements is found
     */
    public boolean waitUntilElementDisplayed(By locator) {
        try {
            logger.info("checking element" + locator);
            return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            logger.info("Element - " + locator + " is not found after 20 seconds wait");
            return false;
        }
    }

    /**
     * waits until the locator is found
     *
     * @param locator to be found
     * @return True if elemenet is found
     */
    public boolean waitUntilElementDisplayed(By locator, int timeout) {
        logger.info("entering text in element field " + locator + " with timeout " + timeout);
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            logger.info("Element - " + locator + " is not found after 20 seconds wait");
            return false;
        }
    }

    /**
     * Select the drop-down by index no
     *
     * @param selectElement to perform action
     * @param index         to be selected
     */
    public void selectDropDownByIndex(WebElement selectElement, int index) {
        logger.info("select value from select drop-down with index" + index);
        Select dropdown = new Select(selectElement);
        dropdown.selectByIndex(index);
    }

    /**
     * Select drop-down by display text
     *
     * @param selectElement to perform action
     * @param dropDownText  to select
     */
    public void selectDropDownByVisibleText(WebElement selectElement, String dropDownText) {
        logger.info("select value from select drop-down with visible text" + dropDownText);
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(dropDownText);
    }

    /**
     * Selects drop-down by visible text
     *
     * @param selectElement to perform action
     * @param dropDownText  css value
     */
    public void selectDropDownByValue(WebElement selectElement, String dropDownText) {
        logger.info("select value from select drop-down with value" + dropDownText);
        Select dropdown = new Select(selectElement);
        dropdown.selectByValue(dropDownText);
    }

    public void staticWait() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void staticWait(int time) {
        logger.info("Sleeping script for time " + time + " second");
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

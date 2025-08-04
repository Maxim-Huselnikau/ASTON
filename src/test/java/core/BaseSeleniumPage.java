package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseSeleniumPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public String getWindowTitle() {
        return driver.getTitle();
    }

    public void scrollToElement(WebElement webelement) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(webelement).perform();
    }
}

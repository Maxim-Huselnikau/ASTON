package core;

import helpers.ClickableElements;
import helpers.InputFields;
import helpers.TextElements;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseSeleniumPage {
    public static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getListWebElements(By paymentButtonsList) {
        return driver.findElements(paymentButtonsList);
    }

    public String getWindowTitle() {
        return driver.getTitle();
    }

    public BaseSeleniumPage scrollToElement(ClickableElements clickableElement) {
        Allure.step("Скролим");
        Actions actions = new Actions(driver);
        actions.scrollToElement(clickableElement.getElement()).perform();
        return this;
    }

    public <T extends BaseSeleniumPage> T clickOnElement(ClickableElements element) {
        Allure.step("Кликаем элемент " + element.getElementName());
        element.getElement().click();
        return (T) element.getPage().get();
    }

    public BaseSeleniumPage clickOnInputElement(InputFields element) {
        Allure.step("Кликаем input элемент " + element.getElementName());
        element.getElement().click();
        return this;
    }

    public BaseSeleniumPage sendKeysToElement(InputFields element, String text) {
        Allure.step("Вводим данные в " + element.getElementName());
        element.getElement().sendKeys(text);
        return this;
    }

    public String getElementText(WebElement element) {
        Allure.step("Получаем текст из элемента " + element);
        return element.getText();
    }

    public String getElementAttribute(WebElement element, String text) {
        Allure.step("Получаем attribute " + text + " из элемента " + element);
        return element.getAttribute(text);
    }

    public String getElementAttribute(TextElements textElement, String text) {
        Allure.step("Получаем attribute=" + text + "  из элемента " + textElement.getElementName());
        return textElement.getElement().getAttribute(text);
    }
}

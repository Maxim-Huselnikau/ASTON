package helpers.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.BaseSeleniumPage.driver;

public enum TextElements {
    MAIN_PAGE_HEADER_OF_PAY_BLOCK(By.xpath("//div[@class='pay__wrapper']//h2"), "Онлайн пополнение без комиссии", "Заголовок блока 'Онлайн пополнение без комиссии'"),
    PAYMENT_DATA_PAGE_DESCRIPTION_OF_PAYMENT(By.xpath("//div[@class='pay-description__text']/span"), "Оплата: Услуги связи Номер:375", "Строка описания услуги"),
    PAYMENT_DATA_PAGE_PAYMENT_COST_IN_HEADER(By.xpath("//div[@class='pay-description__cost']/span"), TestData.MONEY, "Строка суммы оплаты вверху страницы");

    final By element;
    final String text;
    final String elementName;

    TextElements(By element, String text, String elementName) {
        this.element = element;
        this.text = text;
        this.elementName = elementName;
    }

    public WebElement getElement() {
        return driver.findElement(element);
    }

    public String getElementName() {
        return elementName;
    }

    public String getText() {
        return text;
    }
}

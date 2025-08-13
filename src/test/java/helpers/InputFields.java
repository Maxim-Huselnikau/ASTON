package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

import static core.BaseSeleniumPage.driver;

public enum InputFields {

    /// MAIN PAGE ///

    FIELD_CONNECTION_PHONE(() -> driver.findElement(By.xpath("//input[@id='connection-phone']")), "Номер телефона", "'Поле ввода номера телефона'"),
    FIELD_CONNECTION_SUM(() -> driver.findElement(By.xpath("//input[@id='connection-sum']")), "Сумма", "'Поле ввода суммы'"),
    FIELD_CONNECTION_EMAIL(() -> driver.findElement(By.xpath("//input[@id='connection-email']")), "E-mail для отправки чека", "'Поле ввода email'"),

    FIELD_HOME_INTERNET_PHONE(() -> driver.findElement(By.xpath("//input[@id='internet-phone']")), "Номер абонента", "'Поле ввода номера телефона'"),
    FIELD_HOME_INTERNET_SUM(() -> driver.findElement(By.xpath("//input[@id='internet-sum']")), "Сумма", "'Поле ввода суммы'"),
    FIELD_HOME_INTERNET_EMAIL(() -> driver.findElement(By.xpath("//input[@id='internet-email']")), "E-mail для отправки чека", "'Поле ввода email''"),

    FIELD_INSTALLMENT_ACCOUNT_NUMBER(() -> driver.findElement(By.xpath("//input[@id='score-instalment']")), "Номер счета на 44", "'Поле ввода номера счета'"),
    FIELD_INSTALLMENT_SUM(() -> driver.findElement(By.xpath("//input[@id='instalment-sum']")), "Сумма", "'Поле ввода суммы'"),
    FIELD_INSTALLMENT_EMAIL(() -> driver.findElement(By.xpath("//input[@id='instalment-email']")), "E-mail для отправки чека", "'Поле ввода email''"),

    FIELD_DEBT_ACCOUNT_NUMBER(() -> driver.findElement(By.xpath("//input[@id='score-arrears']")), "Номер счета на 2073", "'Поле ввода номера счета'"),
    FIELD_DEBT_SUM(() -> driver.findElement(By.xpath("//input[@id='arrears-sum']")), "Сумма", "'Поле ввода суммы'"),
    FIELD_DEBT_EMAIL(() -> driver.findElement(By.xpath("//input[@id='arrears-email']")), "E-mail для отправки чека", "'Поле ввода email''"),

    /// PAYMENT DATA PAGE ///

    //placeholders
    FIELD_CARD_NUMBER(() -> driver.findElement(By.xpath("//input[@id='cc-number']")), "Номер карты", "'Поле ввода номера карты''"),
    FIELD_CARD_EXPIRATION_DATE(() -> driver.findElement(By.xpath("//input[@formcontrolname='expirationDate']")), "Срок действия", "'Поле ввода срока действия карты''"),
    FIELD_CARD_CVC(() -> driver.findElement(By.xpath("//input[@formcontrolname='cvc']']")), "CVC", "'Поле ввода CVC карты''"),
    FIELD_CARD_HOLDER(() -> driver.findElement(By.xpath("//input[@formcontrolname='holder']")), "Имя и фамилия на карте", "'Поле ввода имя и фамилии держателя карты''");


    private final Supplier<WebElement> elementSupplier;
    private final String placeholder;
    private final String elementName;

    InputFields(Supplier<WebElement> elementSupplier, String placeholder, String elementName) {
        this.elementSupplier = elementSupplier;
        this.placeholder = placeholder;
        this.elementName = elementName;
    }


    public String getElementName() {
        return elementName;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public WebElement getElement() {
        return elementSupplier.get();
    }
}

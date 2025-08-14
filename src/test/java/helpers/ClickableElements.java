package helpers;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.MoreAboutReplenishmentPage;
import pages.PaymentDataPage;

import java.util.function.Supplier;

import static core.BaseSeleniumPage.driver;

public enum ClickableElements {
    BUTTON_SELECT_PAYMENT(() -> driver.findElement(By.xpath("//button[@class='select__header']")), MainPage::new, "'Кнопка выпадающий списка видов оплат'"),
    BUTTON_SUBMIT_REPLENISHMENT(() -> driver.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']")), PaymentDataPage::new, "'Кнопка подтверждения платежа'"),
    LINK_MORE_ABOUT_THE_SERVICE(() -> driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']")), MoreAboutReplenishmentPage::new, "'Ссылка на страницу о сервисе оплаты'"),
    PAYMENT_DATA_PAGE_PAY_BUTTON(() -> driver.findElement(By.xpath("//app-card-page//button[@type='submit']")), PaymentDataPage::new, "'Кнопка подтверждения платежа'"),

    COOKIES_AGREE_BUTTON(() -> driver.findElement(By.xpath("//button[@id='cookie-agree']")), MainPage::new, "'Кнопка согласия сбока кук'");

    final Supplier<WebElement> element;
    final Supplier<? extends BaseSeleniumPage> pageSupplier;
    final String elementName;

    <T extends BaseSeleniumPage> ClickableElements(Supplier<WebElement> element,
                                                   Supplier<T> pageSupplier,
                                                   String elementName) {
        this.element = element;
        this.pageSupplier = pageSupplier;
        this.elementName = elementName;
    }

    public WebElement getElement() {
        return element.get();
    }

    public Supplier<? extends BaseSeleniumPage> getPage() {
        return pageSupplier;
    }

    public String getElementName() {
        return elementName;
    }
}

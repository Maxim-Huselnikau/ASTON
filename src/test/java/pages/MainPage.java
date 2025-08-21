package pages;

import core.BaseSeleniumPage;
import helpers.data.ClickableElements;
import helpers.data.Data;
import helpers.data.InputFields;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BaseSeleniumPage {

    By paymentFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    By paymentButtonsList = By.xpath("//ul[@class='select__list']//p");
    By paymentFormInputFields = By.xpath("//div[@class='pay__forms']//input");
    By replenishmentBlockVisaLogo = By.xpath("//img[@alt='Visa']");
    By replenishmentBlockVerifiedByVisaLogo = By.xpath("//img[@alt='Verified By Visa']");
    By replenishmentBlockMasterCardLogo = By.xpath("//img[@alt='MasterCard']");
    By replenishmentBlockMasterCardSecureCodeLogo = By.xpath("//img[@alt='MasterCard Secure Code']");
    By replenishmentBlockBelcartLogo = By.xpath("//img[@alt='Белкарт']");

    public static MainPage open() {
        driver.get(Data.URL);
        return new MainPage();
    }

    @Step("Соглашаемся со сбором кук")
    public MainPage acceptCookiesIfPresent() {
        try {
            waitElementIsVisible(By.id(ClickableElements.COOKIES_AGREE_BUTTON.getElement().getAttribute("id")), Data.EXPLICITLY_WAIT_COOKIES);
            clickOnElement(ClickableElements.COOKIES_AGREE_BUTTON);
        } catch (Exception e) {
            //Cookies popup not found. Continue test...
        }
        return this;
    }

    @Step("Получаем атрибуты 'alt' логотипов платежных систем")
    public List<String> getPaymentSystemLogos() {
        scrollToElement(ClickableElements.BUTTON_SUBMIT_REPLENISHMENT);
        return List.of(getElementAttribute(getWebElement(replenishmentBlockVisaLogo), "alt"),
                getElementAttribute(getWebElement(replenishmentBlockVerifiedByVisaLogo), "alt"),
                getElementAttribute(getWebElement(replenishmentBlockMasterCardLogo), "alt"),
                getElementAttribute(getWebElement(replenishmentBlockMasterCardSecureCodeLogo), "alt"),
                getElementAttribute(getWebElement(replenishmentBlockBelcartLogo), "alt"));
    }

    @Step("Заполняем форму")
    public PaymentDataPage fillReplenishmentWithoutCommissionForm(String phone, String money, String email) {
        scrollToElement(ClickableElements.BUTTON_SUBMIT_REPLENISHMENT);
//        clickOnInputElement(communicationServicesPhoneField).sendKeysToElement(communicationServicesPhoneField, phone).
        clickOnInputElement(InputFields.FIELD_CONNECTION_PHONE).sendKeysToElement(InputFields.FIELD_CONNECTION_PHONE, phone).
                clickOnInputElement(InputFields.FIELD_CONNECTION_SUM).sendKeysToElement(InputFields.FIELD_CONNECTION_SUM, money).
                clickOnInputElement(InputFields.FIELD_CONNECTION_EMAIL).sendKeysToElement(InputFields.FIELD_CONNECTION_EMAIL, email).
                clickOnElement(ClickableElements.BUTTON_SUBMIT_REPLENISHMENT);
        driver.switchTo().frame(getWebElement(paymentFrame));
        return new PaymentDataPage();
    }

    @Step("Получаем placeholders")
    public String[][] getPaymentFormPlaceholders() {
        scrollToElement(ClickableElements.BUTTON_SUBMIT_REPLENISHMENT);
        String[][] placeholders = new String[4][3];
        List<WebElement> placeholdersList = getListWebElements(paymentFormInputFields);
        List<WebElement> selectPaymentButtonsList = getListWebElements(paymentButtonsList);
        int placeholderInList = 0;

        for (int i = 0; i < selectPaymentButtonsList.size(); i++) {
            clickOnElement(ClickableElements.BUTTON_SELECT_PAYMENT);
            selectPaymentButtonsList.get(i).click();
            for (int j = 0; j < 3; j++) {
                placeholders[i][j] = placeholdersList.get(placeholderInList).getAttribute("placeholder");
                placeholderInList++;
            }
        }
        return placeholders;
    }
}





package pages;

import core.BaseSeleniumPage;
import helpers.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement paymentFrame;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement selectPaymentButton;

    @FindBy(xpath = "//ul[@class='select__list']//p")
    private List<WebElement> paymentButtonsList;

    @FindBy(xpath = "//div[@class='pay__forms']//input")
    private List<WebElement> paymentFormInputFields;

    @FindBy(xpath = "//img[@alt=\"Visa\"]")
    private WebElement replenishmentBlockVisaLogo;
    @FindBy(xpath = "//img[@alt=\"Verified By Visa\"]")
    private WebElement replenishmentBlockVerifiedByVisaLogo;
    @FindBy(xpath = "//img[@alt=\"MasterCard\"]")
    private WebElement replenishmentBlockMasterCardLogo;
    @FindBy(xpath = "//img[@alt=\"MasterCard Secure Code\"]")
    private WebElement replenishmentBlockMasterCardSecureCodeLogo;
    @FindBy(xpath = "//img[@alt=\"Белкарт\"]")
    private WebElement replenishmentBlockBelcartLogo;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement communicationServicesPhoneField;
    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement communicationServicesSumField;
    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement communicationServicesEmailField;

    @FindBy(xpath = "//button[@id=\"cookie-agree\"]")
    private WebElement cookieAgreeButton;

    @FindBy(xpath = "//div[@class=\"pay__wrapper\"]//h2")
    private WebElement replenishmentBlockHeader;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement moreAboutTheServiceLink;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement submitButton;

    public MainPage() {
        driver.get(TestData.URL);
        PageFactory.initElements(driver, this);
    }

    @Step("Получаем название блока")
    public String getReplenishmentBlockHeader() {
        scrollToElement(submitButton);
        return replenishmentBlockHeader.getText();
    }

    @Step("Кликаем 'Подробнее о сервисе'")
    public MoreAboutReplenishmentPage clickMoreAboutTheServiceLink() {
        scrollToElement(submitButton);
        moreAboutTheServiceLink.click();
        return new MoreAboutReplenishmentPage();
    }

    @Step("Соглашаемся со сбором кук, если окно кук появилось")
    public MainPage acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cookieAgreeButton.getAttribute("id"))));
            cookieAgreeButton.click();
        } catch (TimeoutException e) {
            // no cookie
        }
        return this;
    }

    @Step("Получаем атрибуты 'alt' логотипов платежных систем")
    public List<String> getPaymentSystemLogos() {
        scrollToElement(submitButton);
        return List.of(replenishmentBlockVisaLogo.getAttribute("alt"),
                replenishmentBlockVerifiedByVisaLogo.getAttribute("alt"),
                replenishmentBlockMasterCardLogo.getAttribute("alt"),
                replenishmentBlockMasterCardSecureCodeLogo.getAttribute("alt"),
                replenishmentBlockBelcartLogo.getAttribute("alt"));
    }

    @Step("Заполняем форму")
    public PaymentDataPage fillReplenishmentWithoutCommissionForm(String phone, String money, String email) {
        scrollToElement(submitButton);
        communicationServicesPhoneField.click();
        communicationServicesPhoneField.sendKeys(phone);
        communicationServicesSumField.click();
        communicationServicesSumField.sendKeys(money);
        communicationServicesEmailField.click();
        communicationServicesEmailField.sendKeys(email);
        submitButton.click();
        driver.switchTo().frame(paymentFrame);
        return new PaymentDataPage();
    }

    @Step("Получаем placeholders")
    public String[][] getPaymentFormPlaceholders() {
        scrollToElement(submitButton);
        String[][] placeholders = new String[4][3];
        List<WebElement> placeholdersList = paymentFormInputFields;
        List<WebElement> selectPaymentButtonsList = paymentButtonsList;
        int placeholderInList = 0;

        for (int i = 0; i < selectPaymentButtonsList.size(); i++) {
            selectPaymentButton.click();
            selectPaymentButtonsList.get(i).click();
            for (int j = 0; j < 3; j++) {
                placeholders[i][j] = placeholdersList.get(placeholderInList).getAttribute("placeholder");
                placeholderInList++;
            }
        }
        return placeholders;
    }
}





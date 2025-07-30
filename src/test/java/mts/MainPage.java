package mts;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement paymentFrame;

    @FindBy(xpath = "//button[@id=\"cookie-agree\"]")
    private WebElement cookieAgreeButton;

    @FindBy(xpath = "//div[@class=\"pay__wrapper\"]//h2")
    private WebElement replenishmentBlockHeader;

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

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement moreAboutTheServiceLink;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumField;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailField;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement submitButton;

    public MainPage() {
        driver.get("https://www.mts.by/");
        PageFactory.initElements(driver, this);
    }

    public String getReplenishmentBlockHeader() {
        return replenishmentBlockHeader.getText();
    }

    public MoreAboutReplenishmentPage clickMoreAboutTheServiceLink() {
        moreAboutTheServiceLink.click();
        return new MoreAboutReplenishmentPage();
    }

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

    public Map<String, String> getPaymentSystemLogos() {
        return Map.of("Visa", Objects.requireNonNull(replenishmentBlockVisaLogo.getAttribute("alt")),
                "Verified By Visa", Objects.requireNonNull(replenishmentBlockVerifiedByVisaLogo.getAttribute("alt")),
                "MasterCard", Objects.requireNonNull(replenishmentBlockMasterCardLogo.getAttribute("alt")),
                "MasterCard Secure Code", Objects.requireNonNull(replenishmentBlockMasterCardSecureCodeLogo.getAttribute("alt")),
                "Белкарт", Objects.requireNonNull(replenishmentBlockBelcartLogo.getAttribute("alt")));
    }

    public PaymentDataPage fillReplenishmentWithoutCommissionForm(String phone, String money, String email) {
        phoneField.click();
        phoneField.sendKeys(phone);
        sumField.click();
        sumField.sendKeys(money);
        emailField.click();
        emailField.sendKeys(email);
        submitButton.click();
        driver.switchTo().frame(paymentFrame);
        return new PaymentDataPage();
    }
}





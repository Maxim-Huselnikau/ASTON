package mts;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDataPage extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payDescriptionText;

    public PaymentDataPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTextPayDescription() {
        return payDescriptionText.getAttribute("textContent");
    }
}

package mts;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PaymentDataPage extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payDescriptionText;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span")
    private WebElement payCostTextInHeader;

    @FindBy(xpath = ".//app-card-page//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".app-input label")
    private List<WebElement> labelsList;

    @FindBy(xpath = " //div[contains(@class,'icons-container')]//img")
    private List<WebElement> imagesList;

    public PaymentDataPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTextPayDescription() {
        return payDescriptionText.getAttribute("textContent");
    }

    public String getPaySumFomHeader() {
        String[] parts = payCostTextInHeader.getAttribute("textContent")
                .trim()
                .split(" ");
        return parts[0];
    }

    public String getPaySumFomButton() {
        String[] parts = payCostTextInHeader.getAttribute("textContent")
                .trim().replaceAll("  ", "")
                .split(" ");
        return parts[0];
    }

    public String[] getPlaceholders() {
        List<WebElement> placeholdersList = labelsList;
        String[] parts = new String[placeholdersList.size()];
        for (int i = 0; i < placeholdersList.size(); i++) {
            parts[i] = placeholdersList.get(i).getAttribute("textContent");
        }
        return parts;
    }

    public List<String> getPaymentSystemLogosSRC() {
        List<WebElement> imagesPaymentLogoList = imagesList;
        List<String> logosSRC = new ArrayList<>();
        for (WebElement imagesPaymentLogo : imagesPaymentLogoList) {
            logosSRC.add(imagesPaymentLogo.getAttribute("src"));
        }
        return logosSRC;
    }
}

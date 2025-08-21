package pages;

import core.BaseSeleniumPage;
import helpers.data.ClickableElements;
import helpers.data.TextElements;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PaymentDataPage extends BaseSeleniumPage {

    By listPlaceholders = By.cssSelector(".app-input label");
    By imagesList = By.xpath("//div[contains(@class,'icons-container')]//img");

    @Step("Получаем сумму из заголовка попапа")
    public String getPaySumFomHeader() {
        String[] parts = getElementAttribute(TextElements.PAYMENT_DATA_PAGE_PAYMENT_COST_IN_HEADER, "textContent")
                .trim()
                .split(" ");
        return parts[0];
    }

    @Step("Получаем сумму из кнопки попапа")
    public String getPaySumFomButton() {
        String[] parts =
                ClickableElements.PAYMENT_DATA_PAGE_PAY_BUTTON.getElement().getAttribute("textContent")
                        .trim().replaceAll("  ", " ")
                        .split(" ");
        return parts[1];
    }

    @Step("Получаем placeholders полей")
    public String[] getPlaceholders() {
        List<WebElement> placeholdersList = getListWebElements(listPlaceholders);
        String[] parts = new String[placeholdersList.size()];
        for (int i = 0; i < placeholdersList.size(); i++) {
            parts[i] = getElementAttribute(placeholdersList.get(i), "textContent");
        }
        return parts;
    }

    @Step("Получаем атрибут src иконок платежных систем")
    public List<String> getPaymentSystemLogosSRC() {
        List<WebElement> imagesPaymentLogoList = getListWebElements(imagesList);
        List<String> logosSRC = new ArrayList<>();
        for (WebElement imagesPaymentLogo : imagesPaymentLogoList) {
            logosSRC.add(getElementAttribute(imagesPaymentLogo, "src"));
        }
        return logosSRC;
    }
}

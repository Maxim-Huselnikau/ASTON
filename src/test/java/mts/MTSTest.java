package mts;

import core.BaseSeleniumTest;
import helpers.data.ClickableElements;
import helpers.data.InputFields;
import helpers.data.TextElements;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.PaymentDataPage;

import java.text.DecimalFormat;
import java.util.List;

import static helpers.data.Data.PHONE_NUMBER_PLACEHOLDER;
import static helpers.data.Data.TITLE_OF_WINDOW_MORE_ABOUT_PAY;
import static helpers.data.TestData.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("'Онлайн пополнение без комиссии' блок")
@Owner("Maksim Huselnikau")
public class MTSTest extends BaseSeleniumTest {

    @DisplayName("Проверяем название блока 'Онлайн пополнение без комиссии'")
    @Description("Проверяем название блока 'Онлайн пополнение без комиссии' по тегу 'h3'")
    @Test
    void replenishmentBlockHeaderHasRightTextTest() {
        MainPage mainPage = MainPage.open();
        String expectedHeader = TextElements.MAIN_PAGE_HEADER_OF_PAY_BLOCK.getText();
        String actualHeader = mainPage.getElementText(TextElements.MAIN_PAGE_HEADER_OF_PAY_BLOCK.getElement())
                .trim()
                .replaceAll("\\s+", " ");

        assertEquals(expectedHeader, actualHeader);
    }

    @DisplayName("Проверяем наличие картинок платежных систем")
    @Description("Проверяем наличие картинок платежных систем в блоке" +
            "'Онлайн пополнение без комиссии' по наличию соответствующего атрибута 'alt'")
    @Test
    void replenishmentBlockPaymentSystemLogosPresentTest() {
        MainPage mainPage = MainPage.open();
        List<String> actualPaymentLogosAttributeAlt = mainPage.getPaymentSystemLogos();
        List<String> expectedPaymentLogosAttributeAlt = PHONE_NUMBER_PLACEHOLDER;

        assertEquals(expectedPaymentLogosAttributeAlt, actualPaymentLogosAttributeAlt);
    }

    @DisplayName("Проверяем работу ссылки 'Подробнее о сервисе'")
    @Description("Проверяем работу ссылки 'Подробнее о сервисе' в блоке " +
            "'Онлайн пополнение без комиссии' по названию открывшегося окна")
    @Test
    void moreAboutTheServiceLinkWorksTest() {
        String actualMoreAboutReplenishmentPageWindowTitle = MainPage.open().acceptCookiesIfPresent()
                .clickOnElement(ClickableElements.LINK_MORE_ABOUT_THE_SERVICE).getWindowTitle();
        String expectedMoreAboutReplenishmentPageWindowTitle = TITLE_OF_WINDOW_MORE_ABOUT_PAY;

        assertEquals(expectedMoreAboutReplenishmentPageWindowTitle, actualMoreAboutReplenishmentPageWindowTitle);
    }

    @DisplayName("Проверяем работу кнопки 'Продолжить'")
    @Description("Проверяем работу кнопки «Продолжить» для «Услуги связи»" +
            "в блоке 'Онлайн пополнение без комиссии' по полю в открывшемся окне'")
    @Test
    void replenishPhoneTest() {
        MainPage mainPage = MainPage.open();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent().fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        assertEquals(TextElements.PAYMENT_DATA_PAGE_DESCRIPTION_OF_PAYMENT.getText() + PHONE,
                paymentDataPage.getElementAttribute(TextElements.PAYMENT_DATA_PAGE_DESCRIPTION_OF_PAYMENT, "textContent").trim().replaceAll("\\s+", " "));
    }

    @DisplayName("Проверяем placeholders для всех полей всех услуг")
    @Description("Проверяем placeholders для всех полей всех услуг" +
            "в блоке 'Онлайн пополнение без комиссии'")
    @Test
    void checkPlaceholdersTest() {
        String[][] actualPlaceholders = MainPage.open().acceptCookiesIfPresent().getPaymentFormPlaceholders();
        String[][] expectedPlaceholders =
                {{InputFields.FIELD_CONNECTION_PHONE.getPlaceholder(), InputFields.FIELD_CONNECTION_SUM.getPlaceholder(), InputFields.FIELD_CONNECTION_EMAIL.getPlaceholder()},
                        {InputFields.FIELD_HOME_INTERNET_PHONE.getPlaceholder(), InputFields.FIELD_HOME_INTERNET_SUM.getPlaceholder(), InputFields.FIELD_HOME_INTERNET_EMAIL.getPlaceholder()},
                        {InputFields.FIELD_INSTALLMENT_ACCOUNT_NUMBER.getPlaceholder(), InputFields.FIELD_INSTALLMENT_SUM.getPlaceholder(), InputFields.FIELD_INSTALLMENT_EMAIL.getPlaceholder()},
                        {InputFields.FIELD_DEBT_ACCOUNT_NUMBER.getPlaceholder(), InputFields.FIELD_DEBT_SUM.getPlaceholder(), InputFields.FIELD_DEBT_EMAIL.getPlaceholder()}};

        assertArrayEquals(expectedPlaceholders, actualPlaceholders);
    }

    @DisplayName("Проверяем наличие иконок платежных систем в попапе 'Платежные данные'")
    @Description("Проверяем в попапе вызванном по клику кнопки 'Продолжить' для варианта «Услуги связи» " +
            "в блоке 'Онлайн пополнение без комиссии' наличие иконок платёжных систем по значению атрибута SRC")
    @Test
    void paymentDataPageDisplaysRightTextTest() {
        MainPage mainPage = MainPage.open();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        List<String> listPaymentSystemLogosSRC = paymentDataPage.getPaymentSystemLogosSRC();

        assertAll(
                () -> {
                    step("Проверяем visa-system.svg");
                    assertTrue(listPaymentSystemLogosSRC.get(0).contains("visa-system.svg"));
                },
                () -> {
                    step("Проверяем mastercard-system.svg");
                    assertTrue(listPaymentSystemLogosSRC.get(1).contains("mastercard-system.svg"));
                },
                () -> {
                    step("Проверяем belkart-system.svg");
                    assertTrue(listPaymentSystemLogosSRC.get(2).contains("belkart-system.svg"));
                },
                () -> {
                    step("Проверяем maestro-system.svg");
                    assertTrue(listPaymentSystemLogosSRC.get(3).contains("maestro-system.svg"));
                },
                () -> {
                    step("Проверяем mir-system.svg");
                    assertTrue(listPaymentSystemLogosSRC.get(4).contains("mir-system.svg"));
                });

    }

    @DisplayName("Проверяем сумму в хэдере'")
    @Description("Проверяем в попапе вызванном по клику кнопки 'Продолжить' для варианта «Услуги связи» " +
            "в блоке 'Онлайн пополнение без комиссии' корректность отображения суммы в хэдере и кнопке")
    @Test
    void checkSumInHeader() {
        MainPage mainPage = MainPage.open();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        DecimalFormat df = new DecimalFormat("#.00");
        String expectedSum = df.format(Double.valueOf(MONEY));

        assertAll(
                () -> {
                    step("Проверяем сумму в хэдере");
                    assertEquals(expectedSum, paymentDataPage.getPaySumFomHeader());
                },
                () -> {
                    step("Проверяем сумму в кнопке");
                    assertEquals(expectedSum, paymentDataPage.getPaySumFomButton());
                });

    }

    @DisplayName("Проверяем номер телефона в хэдере'")
    @Description("Проверяем в попапе вызванном по клику кнопки 'Продолжить' для варианта «Услуги связи» " +
            "в блоке 'Онлайн пополнение без комиссии' корректность отображения номера телефона в хэдере")
    @Test
    void checkPhoneNumberInHeader() {
        MainPage mainPage = MainPage.open();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        assertTrue(paymentDataPage.getElementAttribute(TextElements.PAYMENT_DATA_PAGE_DESCRIPTION_OF_PAYMENT, "textContent").contains(PHONE));
    }

    @DisplayName("Проверяем placeholders полей ввода информации о карте'")
    @Description("Проверяем в попапе вызванном по клику кнопки 'Продолжить' для варианта «Услуги связи» " +
            "в блоке 'Онлайн пополнение без комиссии' корректность отображения placeholders")
    @Test
    void checkPlaceholdersOnPaymentDataPage() {
        MainPage mainPage = MainPage.open();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        String[] expectedPlaceholders =
                {InputFields.FIELD_CARD_NUMBER.getPlaceholder(),
                        InputFields.FIELD_CARD_EXPIRATION_DATE.getPlaceholder(),
                        InputFields.FIELD_CARD_CVC.getPlaceholder(),
                        InputFields.FIELD_CARD_HOLDER.getPlaceholder()};

        assertArrayEquals(expectedPlaceholders, paymentDataPage.getPlaceholders());

    }
}

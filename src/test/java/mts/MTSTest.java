package mts;

import core.BaseSeleniumTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MoreAboutReplenishmentPage;
import pages.PaymentDataPage;

import java.text.DecimalFormat;
import java.util.List;

import static helpers.TestData.*;

@DisplayName("'Онлайн пополнение без комиссии' блок")
@Owner("Maksim Huselnikau")
public class MTSTest extends BaseSeleniumTest {

    @DisplayName("Проверяем название блока 'Онлайн пополнение без комиссии'")
    @Description("Проверяем название блока 'Онлайн пополнение без комиссии' по тегу 'h3'")
    @Test
    void replenishmentBlockHeaderHasRightTextTest() {
        MainPage mainPage = new MainPage();
        String expectedHeader = "Онлайн пополнение без комиссии";
        String actualHeader = mainPage.acceptCookiesIfPresent()
                .getReplenishmentBlockHeader()
                .trim()
                .replaceAll("\\s+", " ");

        Assertions.assertEquals(expectedHeader, actualHeader);
    }

    @DisplayName("Проверяем наличие картинок платежных систем")
    @Description("Проверяем наличие картинок платежных систем в блоке" +
            "'Онлайн пополнение без комиссии' по наличию соответствующего атрибута 'alt'")
    @Test
    void replenishmentBlockPaymentSystemLogosPresentTest() {
        MainPage mainPage = new MainPage();
        List<String> actualPaymentLogosAttributeAlt = mainPage.getPaymentSystemLogos();
        List<String> expectedPaymentLogosAttributeAlt = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        Assertions.assertEquals(expectedPaymentLogosAttributeAlt, actualPaymentLogosAttributeAlt);
    }

    @DisplayName("Проверяем работу ссылки 'Подробнее о сервисе'")
    @Description("Проверяем работу ссылки 'Подробнее о сервисе' в блоке " +
            "'Онлайн пополнение без комиссии' по названию открывшегося окна")
    @Test
    void moreAboutTheServiceLinkWorksTest() {
        MainPage mainPage = new MainPage();
        MoreAboutReplenishmentPage moreAboutReplenishmentPage = mainPage.acceptCookiesIfPresent().clickMoreAboutTheServiceLink();
        String actualMoreAboutReplenishmentPageWindowTitle = moreAboutReplenishmentPage.getWindowTitle();
        String expectedMoreAboutReplenishmentPageWindowTitle = "Порядок оплаты и безопасность интернет платежей";

        Assertions.assertEquals(expectedMoreAboutReplenishmentPageWindowTitle, actualMoreAboutReplenishmentPageWindowTitle);
    }

    @DisplayName("Проверяем работу кнопки 'Продолжить'")
    @Description("Проверяем работу кнопки «Продолжить» для «Услуги связи»" +
            "в блоке 'Онлайн пополнение без комиссии' по полю в открывшемся окне'")
    @Test
    void replenishPhoneTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent().fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        Assertions.assertEquals("Оплата: Услуги связи Номер:375" + PHONE,
                paymentDataPage.getTextPayDescription().trim().replaceAll("\\s+", " "));
    }

    @DisplayName("Проверяем placeholders для всех полей всех услуг")
    @Description("Проверяем placeholders для всех полей всех услуг" +
            "в блоке 'Онлайн пополнение без комиссии'")
    @Test
    void checkPlaceholdersTest() {
        String[][] actualPlaceholders = new MainPage().acceptCookiesIfPresent().getPaymentFormPlaceholders();
        String[][] expectedPlaceholders = {{PHONE_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER},
                {SUBSCRIBER_PHONE_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER},
                {ACCOUNT_NUMBER_ON_44_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER},
                {ACCOUNT_NUMBER_ON_2073_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER}};

        Assertions.assertArrayEquals(expectedPlaceholders, actualPlaceholders);
    }

    @DisplayName("Проверяем placeholder-ы и введенные данные в попапе 'Платежные данные'")
    @Description("Проверяем в попап вызванном по клику кнопки 'Продолжить' для варианта «Услуги связи» " +
            "в блоке 'Онлайн пополнение без комиссии' корректность отображения суммы (в том числе на кнопке), номера телефона," +
            "а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем.")
    @Test
    void paymentDataPageDisplaysRightTextTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        DecimalFormat df = new DecimalFormat("#.00");
        String expectedSum = df.format(Double.valueOf(MONEY));

        Assertions.assertEquals(expectedSum, paymentDataPage.getPaySumFomHeader());
        Assertions.assertEquals(expectedSum, paymentDataPage.getPaySumFomButton());
        Assertions.assertTrue(paymentDataPage.getTextPayDescription().contains(PHONE));

        String[] expectedPlaceholders = {CARD_NUMBER_PLACEHOLDER, VALID_TILL_PLACEHOLDER, CVC_PLACEHOLDER, NAME_AND_SURNAME_PLACEHOLDER};
        Assertions.assertArrayEquals(expectedPlaceholders, paymentDataPage.getPlaceholders());

        List<String> listPaymentSystemLogosSRC = paymentDataPage.getPaymentSystemLogosSRC();
        Assertions.assertTrue(listPaymentSystemLogosSRC.get(0).contains("visa-system.svg"));
        Assertions.assertTrue(listPaymentSystemLogosSRC.get(1).contains("mastercard-system.svg"));
        Assertions.assertTrue(listPaymentSystemLogosSRC.get(2).contains("belkart-system.svg"));
        Assertions.assertTrue(listPaymentSystemLogosSRC.get(3).contains("maestro-system.svg"));
        Assertions.assertTrue(listPaymentSystemLogosSRC.get(4).contains("mir-system.svg"));
    }
}

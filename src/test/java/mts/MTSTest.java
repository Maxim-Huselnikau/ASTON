package mts;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.List;

import static helpers.TestData.*;

public class MTSTest extends BaseSeleniumTest {
    @Test
    void replenishmentBlockHeaderHasRightTextTest() {
        MainPage mainPage = new MainPage();
        String expectedHeader = "Онлайн пополнение без комиссии";
        String actualHeader = mainPage.getReplenishmentBlockHeader().trim().replaceAll("\\s+", " ");

        Assertions.assertEquals(expectedHeader, actualHeader);
    }

    @Test
    void replenishmentBlockPaymentSystemLogosPresentTest() {
        MainPage mainPage = new MainPage();
        List<String> actualPaymentLogosAttributeAlt = mainPage.getPaymentSystemLogos();
        List<String> expectedPaymentLogosAttributeAlt = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        Assertions.assertEquals(expectedPaymentLogosAttributeAlt, actualPaymentLogosAttributeAlt);
    }

    @Test
    void moreAboutTheServiceLinkWorksTest() {
        MainPage mainPage = new MainPage();
        MoreAboutReplenishmentPage moreAboutReplenishmentPage = mainPage.acceptCookiesIfPresent().clickMoreAboutTheServiceLink();
        String actualMoreAboutReplenishmentPageWindowTitle = moreAboutReplenishmentPage.getWindowTitle();
        String expectedMoreAboutReplenishmentPageWindowTitle = "Порядок оплаты и безопасность интернет платежей";

        Assertions.assertEquals(expectedMoreAboutReplenishmentPageWindowTitle, actualMoreAboutReplenishmentPageWindowTitle);
    }

    @Test
    void replenishPhoneTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent().fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        Assertions.assertEquals("Оплата: Услуги связи Номер:375" + PHONE, paymentDataPage.getTextPayDescription().trim().replaceAll("\\s+", " "));
    }

    @Test
    void checkPlaceholdersTest() {
        String[][] actualPlaceholders = new MainPage().acceptCookiesIfPresent().getPaymentFormPlaceholders();
        String[][] expectedPlaceholders = {{PHONE_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER},
                {SUBSCRIBER_PHONE_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER},
                {ACCOUNT_NUMBER_ON_44_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER},
                {ACCOUNT_NUMBER_ON_2073_PLACEHOLDER, SUM_PLACEHOLDER, EMAIL_PLACEHOLDER}};

        Assertions.assertArrayEquals(expectedPlaceholders, actualPlaceholders);
    }

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

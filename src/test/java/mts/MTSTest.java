package mts;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.List;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

public class MTSTest extends BaseSeleniumTest {
    @Test
    void replenishmentBlockHeaderHasRightTextTest() {
        MainPage mainPage = new MainPage();
        String expectedHeader = "Онлайн пополнение без комиссии";
        String actualHeader = mainPage.getReplenishmentBlockHeader().trim().replaceAll("\\s+", " ");

        assertEquals(expectedHeader, actualHeader);
    }

    @Test
    void replenishmentBlockPaymentSystemLogosPresentTest() {
        MainPage mainPage = new MainPage();
        List<String> actualPaymentLogosAttributeAlt = mainPage.getPaymentSystemLogos();
        List<String> expectedPaymentLogosAttributeAlt = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        assertEquals(expectedPaymentLogosAttributeAlt, actualPaymentLogosAttributeAlt);
    }

    @Test
    void moreAboutTheServiceLinkWorksTest() {
        MainPage mainPage = new MainPage();
        MoreAboutReplenishmentPage moreAboutReplenishmentPage = mainPage.acceptCookiesIfPresent().clickMoreAboutTheServiceLink();
        String actualMoreAboutReplenishmentPageWindowTitle = moreAboutReplenishmentPage.getWindowTitle();
        String expectedMoreAboutReplenishmentPageWindowTitle = "Порядок оплаты и безопасность интернет платежей";

        assertEquals(expectedMoreAboutReplenishmentPageWindowTitle, actualMoreAboutReplenishmentPageWindowTitle);
    }

    @Test
    void replenishPhoneTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent().fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        assertEquals("Оплата: Услуги связи Номер:375" + PHONE, paymentDataPage.getTextPayDescription().trim().replaceAll("\\s+", " "));
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
    void paymentLogosOnPaymentDataPageTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        List<String> listPaymentSystemLogosSRC = paymentDataPage.getPaymentSystemLogosSRC();
        assertTrue(listPaymentSystemLogosSRC.get(0).contains("visa-system.svg"));
        assertTrue(listPaymentSystemLogosSRC.get(1).contains("mastercard-system.svg"));
        assertTrue(listPaymentSystemLogosSRC.get(2).contains("belkart-system.svg"));
        assertTrue(listPaymentSystemLogosSRC.get(3).contains("maestro-system.svg"));
        assertTrue(listPaymentSystemLogosSRC.get(4).contains("mir-system.svg"));

        Assertions.assertAll(
                () -> {
                    assertTrue(listPaymentSystemLogosSRC.get(0).contains("visa-system.svg"));
                },
                () -> {
                    assertTrue(listPaymentSystemLogosSRC.get(1).contains("mastercard-system.svg"));
                },
                () -> {
                    assertTrue(listPaymentSystemLogosSRC.get(2).contains("belkart-system.svg"));
                },
                () -> {
                    assertTrue(listPaymentSystemLogosSRC.get(3).contains("maestro-system.svg"));
                },
                () -> {
                    assertTrue(listPaymentSystemLogosSRC.get(4).contains("mir-system.svg"));
                });
    }

    @Test
    void paymentSumTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        DecimalFormat df = new DecimalFormat("#.00");
        String expectedSum = df.format(Double.valueOf(MONEY));

        assertAll(() -> assertEquals(expectedSum, paymentDataPage.getPaySumFomHeader()),
                () -> assertEquals(expectedSum, paymentDataPage.getPaySumFomButton()));

    }

    @Test
    void paymentPhoneNumberTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        DecimalFormat df = new DecimalFormat("#.00");
        String expectedSum = df.format(Double.valueOf(MONEY));

        assertTrue(paymentDataPage.getTextPayDescription().contains(PHONE));
    }

    @Test
    void placeholdersOnPaymentDataPageTest() {
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage = mainPage.acceptCookiesIfPresent()
                .fillReplenishmentWithoutCommissionForm(PHONE, MONEY, EMAIL);

        String[] expectedPlaceholders = {CARD_NUMBER_PLACEHOLDER, VALID_TILL_PLACEHOLDER, CVC_PLACEHOLDER, NAME_AND_SURNAME_PLACEHOLDER};
        Assertions.assertArrayEquals(expectedPlaceholders, paymentDataPage.getPlaceholders());
    }

}



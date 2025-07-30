package mts;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
        Map<String, String> paymentLogos = mainPage.getPaymentSystemLogos();

        Assertions.assertEquals("Visa", paymentLogos.get("Visa"));
        Assertions.assertEquals("Verified By Visa", paymentLogos.get("Verified By Visa"));
        Assertions.assertEquals("MasterCard", mainPage.getPaymentSystemLogos().get("MasterCard"));
        Assertions.assertEquals("MasterCard Secure Code", mainPage.getPaymentSystemLogos().get("MasterCard Secure Code"));
        Assertions.assertEquals("Белкарт", mainPage.getPaymentSystemLogos().get("Белкарт"));
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
    void replenishPhoneTest(){
        MainPage mainPage = new MainPage();
        PaymentDataPage paymentDataPage= mainPage.acceptCookiesIfPresent().fillReplenishmentWithoutCommissionForm("297777777", "12", "my_email@gmail.com");

        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777",paymentDataPage.getTextPayDescription().trim().replaceAll("\\s+", " "));
    }


}

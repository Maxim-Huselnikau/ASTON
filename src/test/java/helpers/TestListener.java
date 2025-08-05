package helpers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static core.BaseSeleniumPage.driver;

public class TestListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle()
                .addAttachment("screenshot", "image/png", "png", ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        driver.close();
        driver.quit();
    }
}

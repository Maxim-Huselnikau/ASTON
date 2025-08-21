package core;

import helpers.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static helpers.data.Data.CLEAR_COOKIES_AND_STORAGE;
import static helpers.data.Data.IMPLICITLY_WAIT;

@ExtendWith(TestListener.class)
public abstract class BaseSeleniumTest {
    protected static WebDriver driver;

    @BeforeAll
    static void setUpBeforeClass() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterAll
    static void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterEach
    void tearDown() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            js.executeScript("window.sessionStorage.clear();");
        }
    }
}

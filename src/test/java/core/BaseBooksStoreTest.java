package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static data.TestData.IMPLICITLY_WAIT;

public class BaseBooksStoreTest {
    protected static WebDriver driver;
    protected static Logger logger;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        logger = LogManager.getLogger(BaseBooksStoreTest.class);
        BaseBookStorePage.setLogger(logger);
        logger.info("\n\n/////////////////////////////////////////////////////////////////////////\n" +
                "////////////////////////////// NEW TEST RUN /////////////////////////////\n" +
                "/////////////////////////////////////////////////////////////////////////\n");
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        logger.info("////////////////////////////// NEXT TEST START /////////////////////////////");
        logger.info("Setting up driver, implicitlyWaits and maximizing window");
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        BaseBookStorePage.setDriver(driver);
        logger.info("STARTING test: {}", testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        logger.info("Test: {} FINISHED", testInfo.getDisplayName());
        if (driver != null) {
            driver.quit();
        }
    }
}

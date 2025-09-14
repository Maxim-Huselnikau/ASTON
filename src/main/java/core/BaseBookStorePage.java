package core;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseBookStorePage {

    public static WebDriver driver;
    public static Logger logger;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void setLogger(Logger log) {
        logger = log;
    }

}

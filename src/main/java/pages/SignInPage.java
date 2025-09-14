package pages;

import core.BaseBookStorePage;
import org.openqa.selenium.By;

public class SignInPage extends BaseBookStorePage {

    By userNameField = By.id("userName");
    By passwordField = By.id("password");
    By signInButton = By.id("login");

    public UserProfilePage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new UserProfilePage();
    }

    public SignInPage enterUserName(String userName) {
        logger.info("entering user name: " + userName);
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public SignInPage enterPassword(String password) {
        logger.info("entering password: " + password);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public UserProfilePage signIn(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        return clickSignInButton();
    }
}

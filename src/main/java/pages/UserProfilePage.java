package pages;

import core.BaseBookStorePage;
import org.openqa.selenium.By;

public class UserProfilePage extends BaseBookStorePage {

    By signOutButton = By.id("submit");

    public SignInPage signOut() {
        driver.findElement(signOutButton).click();
        return new SignInPage();
    }
}

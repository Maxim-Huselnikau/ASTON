package pages;

import core.BaseBookStorePage;
import data.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BaseBookStorePage {

    By loginButton = By.id("login");
    By books = By.xpath("//span[@class='mr-2']/a");

    public static BooksPage open() {
        logger.info("Navigating to Book Store page");
        driver.get(PageData.BASE_URL + PageData.BOOK_STORE_BOOKS_ENDPOINT);
        return new BooksPage();
    }

    public SignInPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SignInPage();
    }

    public List<String> getListOfBooksTitlesFromPage() {
        List<WebElement> listOfBooks = driver.findElements(books);
        ArrayList<String> listOfBooksTitles = new ArrayList<>();
        for (WebElement element : listOfBooks) {
            listOfBooksTitles.add(element.getText());
        }
        return listOfBooksTitles;
    }
}

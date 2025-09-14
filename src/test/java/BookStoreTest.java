import core.BaseBooksStoreTest;
import helpers.SwaggerAPI;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BooksPage;
import pages.UserProfilePage;

import java.util.List;

public class BookStoreTest extends BaseBooksStoreTest {

    @DisplayName("Sign in accessible")
    @Description("Проверяем возможность залогина." +
            "Для этого: создаем нового юзера через API," +
            "логинимся новым юзером," +
            "успешно разлогинимся найдя нужную кнопку на странице")
    @Test
    public void signInTest() {
        logger.info("Creating a new user");
        String newUserName = String.valueOf(Math.random()) + "M@ksim";
        String password = "1Aa@Maks";
        SwaggerAPI.createNewUser(newUserName, password);

        logger.info("Signing in");
        UserProfilePage userProfilePage = BooksPage.open().clickLoginButton().signIn(newUserName, password);

        logger.info("Signing out");
        userProfilePage.signOut();
        logger.info("Signed out successfully");
    }

    @DisplayName("List of books from UI same as pulled from API")
    @Description("Проверяем что на UI отображаются все книги." +
            "Проверка происходит сравнением названий книг." +
            "Для этого загружаем лист названий из API и из UI")
    @Test
    public void listOfBooksTest() {
        logger.info("Pulling list of books titles from website page");
        List<String> listOfBooksTitlesFromPage = BooksPage.open().getListOfBooksTitlesFromPage();
        logger.info("Pulled list of books titles from website page");

        logger.info("Pulling list of books from API");
        List<String> listOfBooksTitlesFromAPI = SwaggerAPI.getListOfBooksTitlesFromAPI();
        logger.info("Pulled list of books from API");

        Assertions.assertArrayEquals(listOfBooksTitlesFromPage.toArray(), listOfBooksTitlesFromAPI.toArray());
    }
}

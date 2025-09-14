package helpers;

import data.PageData;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SwaggerAPI {

    public static void createNewUser(String username, String password) {
        given().baseUri(PageData.BASE_URL)
                .body("{\n" +
                        "  \"userName\": \"" + username + "\",\n" +
                        "  \"password\": \"" + password + "\"\n" +
                        "}")
                .contentType("application/json")
                .when().post(PageData.CREATE_USER_ENDPOINT);
//                .getBody();
    }

    public static List<String> getListOfBooksTitlesFromAPI() {
        return given().baseUri(PageData.BASE_URL)
                .when().get(PageData.GET_BOOKS_ENDPOINT)
                .getBody().jsonPath().getList("books.title");
    }
}

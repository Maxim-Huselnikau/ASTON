import io.restassured.RestAssured;
import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import utils.LoadFile;
import utils.Specifications;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    final String str = "This is expected to be sent back as part of response body.";
    final Map<String, String> map = Map.of("foo1", "bar1", "foo2", "bar2");

    @BeforeAll
    public static void setup() {
        Specifications.installStandardSpec("https://postman-echo.com/");
    }

    @AfterAll
    public static void teardown() {
        RestAssured.reset();
    }

    //get
    @Test
    public void testGetArgs() {
        given()
                .when().get("get/?foo1=bar1&foo2=bar2")
                .then().log().body()
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testGetArgsAsMap() {
        given()
                .when().get("get/?foo1=bar1&foo2=bar2")
                .then().log().body()
                .and().body("args", equalTo(map));
    }

    @DisplayName("Send GET request. Check that full body is correct.")
    @Test()
    public void testGetJSONFromFile() throws IOException, JSONException {
        String urlData = "/?foo1=bar1&foo2=bar2";
        String expectedJson = LoadFile.loadFile("getJSON.json");

        String actualJSON = given()
                .when().get("get" + urlData)
                .then().log().body()
                .extract().body().asString();

        JSONAssert.assertEquals(expectedJson, actualJSON, new CustomComparator(JSONCompareMode.LENIENT,
                new Customization("headers.x-request-start", (o1, o2) -> true),
                new Customization("headers.x-amzn-trace-id", (o1, o2) -> true)
        ));
    }

    //post raw text
    @Test
    public void testPostRawText() {
        Specifications.installSpec("https://postman-echo.com/");
        String jsonBody = "{\"test\": \"value\"}";
        given()
                .body(jsonBody)
                .contentType("text/plain;charset=UTF-8")
                .when().post("post")
                .then().log().body()
                .and().body("data", equalTo(jsonBody))
                .and().body("headers.content-length", equalTo("17"))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/post"))
                .and().body("args", equalTo(Map.of()))
                .and().body("files", equalTo(Map.of()))
                .and().body("form", equalTo(Map.of()));
    }

    //POST FormData
    @Test
    public void testPostFormData() {
        Specifications.installSpec("https://postman-echo.com/");
        given()
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().post("post")
                .then().log().body()
                .and().body("form", equalTo(map))
                .and().body("json", equalTo(map))
                .and().body("url", equalTo("https://postman-echo.com/post"))
                .and().body("args", equalTo(Map.of()))
                .and().body("files", equalTo(Map.of()));
    }

    //put
    @Test
    public void testPut() {
        Specifications.installSpec("https://postman-echo.com/");
        given()
                .contentType("text/plain;charset=UTF-8")
                .body(str)
                .when().put("put")
                .then().log().body()
                .and().body("data", equalTo(str))
                .and().body("form", equalTo(Map.of()))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/put"))
                .and().body("args", equalTo(Map.of()))
                .and().body("files", equalTo(Map.of()));
    }

    //patch
    @Test
    public void testPatch() {
        given()
                .contentType("text/plain;charset=UTF-8")
                .body(str)
                .when().patch("patch")
                .then().log().body()
                .and().body("data", equalTo(str))
                .and().body("form", equalTo(Map.of()))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/patch"))
                .and().body("args", equalTo(Map.of()))
                .and().body("files", equalTo(Map.of()));
    }

    //delete
    @Test
    public void testDelete() {
        given()
                .contentType("text/plain;charset=UTF-8")
                .body(str)
                .when().delete("delete")
                .then().log().body()
                .and().body("data", equalTo(str))
                .and().body("form", equalTo(Map.of()))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/delete"))
                .and().body("args", equalTo(Map.of()))
                .and().body("files", equalTo(Map.of()));
    }
}

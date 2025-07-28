package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;

public class Specifications {
    public static RequestSpecification request(String URI) {
        return new RequestSpecBuilder()
                .setBaseUri(URI)
                .setContentType("application/json; charset=UTF-8")
                .build();
    }

    public static ResponseSpecification response() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void installStandardSpec(String URI) {
        RestAssured.requestSpecification = request(URI);
        RestAssured.responseSpecification = response();
    }

    public static ResponseSpecification responseWithCheckingParams() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("headers.host", equalTo("postman-echo.com"))
                .expectBody("headers.connection", equalTo("close"))
                .expectBody("headers.x-forwarded-proto", equalTo("https"))
                .expectBody("headers.x-forwarded-port", equalTo("443"))
                .expectBody("headers.accept", equalTo("*/*"))
                .expectBody("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.27)"))
                .expectBody("headers.accept-encoding", equalTo("gzip,deflate"))
                .build();
    }

    public static void installSpec(String URI) {
        RestAssured.requestSpecification = request(URI);
        RestAssured.responseSpecification = responseWithCheckingParams();
    }

}

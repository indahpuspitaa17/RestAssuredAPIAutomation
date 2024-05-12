package basic.trello;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class getBoard {
    public getBoard() {}

    // Base URI
    public static String baseUri = "https://api.trello.com";

    @Test
    public void getCreatedBoard() {
        RestAssured.baseURI = baseUri;

        given().
                param("key", "2885e7b1066d1a30689167c2d8603644").
                param("token", "ATTAff7b3913467deacd5726302672d8ea4dbb247a34a8934d77242a7c727277e75241725DF4").
        when().
                get("/1/boards/daGPAl4P").
        // Verify response and body
        then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("id", equalTo("66409f6da0eedc2e6becfaa4")).and().
                body("name", equalTo("Rest Assured"));
    }
}
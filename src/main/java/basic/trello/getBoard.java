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
        when().
                get("/1/boards/io").
        // Verify response and body
        then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("id", equalTo("ii")).and().
                body("name", equalTo("Rest Assured"));
    }
}

package basic.trello;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class createBoard {
    public createBoard() {
    }

    @Test
    public void createNewBoard() {
        // Base URI
        RestAssured.baseURI = "https://api.trello.com";
        String randomBoardName = "newnew";

        given().
                headers("content-type", "application/json").
                headers("User-Agent", "PostmanRuntime/7.37.3").
                param("name", randomBoardName).
        when().
                post("/1/boards").
                // Verify response and body
        then().
                assertThat().statusCode(400);
    }
}

package testcase.trello;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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

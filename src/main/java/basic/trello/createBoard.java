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
                param("key", "2885e7b1066d1a30689167c2d8603644").
                param("token", "ATTAff7b3913467deacd5726302672d8ea4dbb247a34a8934d77242a7c727277e75241725DF4").
        when().
                post("/1/boards").
                // Verify response and body
        then().
                assertThat().statusCode(400);
    }
}

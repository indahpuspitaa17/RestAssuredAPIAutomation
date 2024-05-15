package testcase.trello;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getBoard {
    public getBoard() {}

    // Base URI
    public static String baseUri = "https://api.trello.com";
    String apiKey = "2885e7b1066d1a30689167c2d8603644";
    String apiToken = "ATTAff7b3913467deacd5726302672d8ea4dbb247a34a8934d77242a7c727277e75241725DF4";

    @Test
    public void getCreatedBoard() {
        RestAssured.baseURI = baseUri;

        Response response =
                given().
                param("key", apiKey).
                param("token", apiToken).
        when().
                get("/1/boards/daGPAl4P").
        then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).
        extract().response();

        String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);
//        System.out.println("The switcher view type is " + responseBody.get("prefs.switcherViews.viewType[1]"));

        int switcherViewSize = responseBody.get("prefs.switcherViews.viewType.size()");
        for (int i = 0; i < switcherViewSize; i++) {
            String viewType = responseBody.get("prefs.switcherViews.viewType["+i+"]");
            System.out.println("the " + i + " switcher view type is " + viewType);
        }
    }
}

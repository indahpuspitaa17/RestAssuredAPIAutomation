package testcase.github;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.RestLogger;

import static io.restassured.RestAssured.given;

public class GithubRepoTest {
    String baseUri = "https://api.github.com";
    String bearerToken = "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";
    String repoName;

    @Test
    public void createNewRepository() {
        // Base URI
        RestAssured.baseURI = baseUri;
        String bodyRequest = "{\n" +
                "    \"name\": \"api-testing-2\",\n" +
                "    \"description\":\"API Automation testing using REST Assured\",\n" +
                "    \"private\":true\n" +
                "}";

        System.out.println("API Github - Create a Repository for the Authenticated User");

        Response response = given().
                header("Content-Type", "application/json").
                header("Authorization", "Bearer " + bearerToken).
                body(bodyRequest).
        when().
                post("/user/repos").
        // Verify response and body
        then().
                assertThat().statusCode(201).
                contentType(ContentType.JSON).log().body().
        // Extract the response body to response object
        extract().response();

        String jsonResponse = response.asString();

        JsonPath responseBody = new JsonPath(jsonResponse);
        System.out.println("Github full name: " + responseBody.get("full_name"));
        System.out.println("Github body response: " + responseBody.get());

        System.out.println("API Github - Completed a Repository for the Authenticated User");

        repoName = responseBody.get("full_name");
    }

    @Test
    public void deleteRepository() {
        RestAssured.baseURI = baseUri;

        System.out.println("API Github - Start to delete the created repository");
        given().
                header("Content-Type", "application/json").
                header("Authorization", "Bearer " + bearerToken).
        when().
                delete("/repos/" + repoName).
        then().
                assertThat().statusCode(204);

        System.out.println("API Github - Finished to delete repository");
    }

    @Test
    public void listOfRepository() {
        RestAssured.baseURI = baseUri;

        RestLogger.startTestCase("listOfRepository");

        Response response =
                given().header("Content-Type", "application/json").
                        header("Authorization", "Bearer " + bearerToken).
                        param("per_page", "2").
                        param("type", "private").
                when().
                        get("/user/repos").
                then().
                        log().body().
                        assertThat().statusCode(200).
                        contentType(ContentType.JSON).
                extract().response();

        String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);
        System.out.println("This is the permissions: " + responseBody.get("permissions.admin[0]"));

        RestLogger.endTestCase();
    }
}
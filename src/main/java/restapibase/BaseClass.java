package restapibase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
    // Basic function of framework
    public static Response getRequest(String requestURI) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.get(requestURI);
    }

    public static Response postRequest(String requestURI, String requestBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.post(requestURI);
    }

    public static Response postRequest(String requestURI, String requestBody, String bearerToken) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + bearerToken);
        return requestSpecification.post(requestURI);
    }

    public static Response putRequest(String requestURI, String requestBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.put(requestURI);
    }

    public static Response deleteRequest(String requestURI) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.delete(requestURI);
    }

    public static Response deleteWithPayloadRequest(String requestURI, String responseBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(responseBody);
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.delete(requestURI);
    }
}

package testcase.github;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import restapibase.BaseClass;
import utility.Auth;
import utility.CreateUrl;
import utility.PayloadGenerator;

import java.io.IOException;

public class GithubRepoTestSuite {
    Response response;

    @Test
    public void createRepositoryTest() throws IOException {
        String endpoint = CreateUrl.getBaseURI("/user/repos");
        String payload = PayloadGenerator.generateStringPayload("createRepo.json");
        String bearerToken = Auth.bearerToken();

        response = BaseClass.postRequest(endpoint, payload, bearerToken);
        String responseString = response.asString();

        System.out.println("=============== RESPONSE ===============");
        System.out.println(responseString);
    }
}

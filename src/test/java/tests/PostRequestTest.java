package tests;

import tests.usersdata.PostUser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestTest {
    String baseUrl = "https://reqres.in/api/users";

    @Test
    public void RunPostRequestTest() {

        String UserName = "example";
        String UserJob = "developer";

        PostUser exampleUser = new PostUser(UserName, UserJob);
        Response response = given().contentType("application/json").body(exampleUser).when().post(baseUrl);

        PostUser userForResponse = response.as(PostUser.class);

        Assert.assertEquals(userForResponse.getName(), UserName);
        Assert.assertEquals(userForResponse.getJob(), UserJob);
    }

}


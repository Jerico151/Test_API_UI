package GET_POST_Tests;

import GET_POST_Tests.Usersdata.POST_user;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_POST1 {
    String baseUrl = "https://reqres.in/api/users";

    @Test
    public void RunPostRequestTest() {

        String UserName = "example";
        String UserJob = "developer";

        POST_user exampleUser = new POST_user(UserName, UserJob);
        Response response = given().contentType("application/json").body(exampleUser).when().post(baseUrl);

        POST_user userForResponse = response.as(POST_user.class);

        Assert.assertEquals(userForResponse.getName(), UserName);
        Assert.assertEquals(userForResponse.getJob(), UserJob);
    }

}


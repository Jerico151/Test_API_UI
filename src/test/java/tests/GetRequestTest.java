package tests;

import tests.usersdata.Users;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;


public class GetRequestTest {

    String baseUrl = "https://reqres.in/api/users?page=2";

    @Test
    void RunGetRequestTest() {

        Response response = RestAssured.get(baseUrl);
        String json = response.getBody().asString();

        List<Users> userList = Arrays.asList(from(json).getObject("data", Users[].class));

        for (Users userData : userList) {
            Assert.assertNotNull(userData.getId());
            Assert.assertNotNull(userData.getEmail());
            Assert.assertNotNull(userData.getFirst_name());
            Assert.assertNotNull(userData.getLast_name());
            Assert.assertNotNull(userData.getAvatar());
        }
    }
}
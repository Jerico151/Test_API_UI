package GET_POST_Tests;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class Test_GET1 {
    @Test
    public void test1() {
        given().
            when().
            get("https://reqres.in/api/users?page=2").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void test2() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
        then().
                assertThat().
                contentType(ContentType.JSON);
    }

    @Test
    public void test3() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
        then().
                log().all();
    }

    @Test
    public void test4() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
        then().
                assertThat().
                body("data[2].'first_name'", Matchers.equalTo("Tobias"));
    }

}


package com.williams.userexercisesrest.api.user;

import org.junit.Ignore;
import org.junit.Test;
import user.User;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserGetAPITest extends AbstractUserAPITest {

    @Test
    public void shouldRunTest() {
        when().get("http://restapp:8080/api/users/2343232")
                .then().statusCode(404);
    }

    @Ignore
    @Test
    public void shouldGetUser() {

        user = userTestDataCreator.createUser();

        when()
                .get(buildUserURL(user.getId()))
        .then()
                .statusCode(200)
                .body("name", equalTo(user.getName()),
                        "postcode", equalTo(user.getPostcode()));
    }

    @Ignore
    @Test
    public void shouldReturn404ForUnknownUser() {

        when()
                .get(buildUserURL(0))
        .then()
                .statusCode(404);
    }

    @Ignore
    @Test
    public void shouldFailValidationForInvalidURL() {
        given()
        .when()
                .get(USER_GET_PATH + "A")
        .then()
                .statusCode(400);
    }

    @Ignore
    @Test
    public void shouldGetAllUsers() {
        User firstUser = userTestDataCreator.createUser("Test", "AA121FG");
        User secondUser = userTestDataCreator.createUser("Test", "BB121FG");

        when()
                .get(USER_GET_PATH)
        .then()
                .body("findAll {it.name == 'Test'}.postcode",
                        hasItems(firstUser.getPostcode(),
                                secondUser.getPostcode()));
    }

}
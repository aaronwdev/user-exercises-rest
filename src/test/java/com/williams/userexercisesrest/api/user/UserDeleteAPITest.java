package com.williams.userexercisesrest.api.user;

import org.junit.Ignore;
import org.junit.Test;
import user.User;

import static io.restassured.RestAssured.given;

public class UserDeleteAPITest extends AbstractUserAPITest {

    @Ignore
    @Test
    public void shouldDeleteUser() {
        User user = userTestDataCreator.createUser();

        given()
                .contentType("application/json")
        .when()
                .delete(buildUserURL(user.getId()))
        .then()
                .statusCode(204);
    }

    @Ignore
    @Test
    public void shouldReturn404IfUserDoesNotExist() {
        given()
                .contentType("application/json")
        .when()
                .delete(buildUserURL(0))
        .then()
                .statusCode(404);
    }

}

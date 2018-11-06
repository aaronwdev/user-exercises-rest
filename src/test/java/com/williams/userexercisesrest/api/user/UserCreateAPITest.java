package com.williams.userexercisesrest.api.user;

import org.junit.Ignore;
import org.junit.Test;
import user.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserCreateAPITest extends AbstractUserAPITest {

    @Ignore
    @Test
    public void shouldCreateNewUser() {

        user = userBuilder.buildRandomUser();

        given()
                .contentType("application/json")
                .body(user)
        .when()
                .post(USER_PATH)
        .then()
                .statusCode(201)
                .body("name", equalTo(user.getName()),
                        "postcode", equalTo(user.getPostcode()));
    }

    @Ignore
    @Test
    public void shouldValidateNameLengthTooLong() {

        user = userBuilder.buildUserWithTooLongName();

        given()
                .contentType("application/json")
                .body(user)
        .when()
                .post(USER_PATH)
        .then()
                .statusCode(422)
                .body("error", equalTo("Unable to process input"));
    }

    @Ignore
    @Test
    public void shouldValidateNamePostcodeTooLong() {

        user = userBuilder.buildUserWithTooLongPostcode();

        given()
                .contentType("application/json")
                .body(user)
        .when()
                .post(USER_PATH)
        .then()
                .statusCode(422)
                .body("error", equalTo("Unable to process input"));
    }

    @Ignore
    @Test
    public void shouldValidateNameNotNull() {

        user = new User("", "AA231DF");

        given()
                .contentType("application/json")
                .body(user)
        .when()
                .post(USER_PATH)
        .then()
                .statusCode(422)
                .body("error", equalTo("Unable to process input"));
    }

    @Ignore
    @Test
    public void shouldValidatePostcodeNotNull() {

        user = new User("Aaron Williams", "");

        given()
                .contentType("application/json")
                .body(user)
        .when()
                .post(USER_PATH)
        .then()
                .statusCode(422)
                .body("error", equalTo("Unable to process input"));
    }

    @Ignore
    @Test
    public void shouldFailWithInvalidSchema() {

        given()
                .contentType("application/json")
                .body("\"invalid\":\"Invalid\"")
        .when()
                .post(USER_PATH)
        .then()
                .statusCode(400);
    }

}

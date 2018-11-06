package com.williams.userexercisesrest.api.user;

import rest.UserTestDataCreator;
import user.User;
import user.UserBuilder;

public abstract class AbstractUserAPITest {

    protected static final String USER_PATH = "/api/users";
    protected static final String USER_GET_PATH = "/api/users/";

    protected UserBuilder userBuilder = new UserBuilder();
    protected UserTestDataCreator userTestDataCreator = new UserTestDataCreator();
    protected User user;

    protected String buildUserURL(int userId) {
        return USER_PATH + "/" + userId;
    }

}

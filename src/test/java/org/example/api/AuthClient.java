package org.example.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.api.data.User;

import static io.restassured.RestAssured.given;
import static org.example.utils.Constants.LOGIN_API;

public class AuthClient {
    @Step("получение ответа при авторизации пользователя")
    public ValidatableResponse loginUserResponse(User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(LOGIN_API.getConstant())
                .then();
    }
}

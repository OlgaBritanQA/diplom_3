package org.example.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.example.api.data.RegisterRequest;

import static io.restassured.RestAssured.given;
import static org.example.utils.Constants.REGISTER_API;
import static org.example.utils.Constants.USER_API;

public class RegisterClient {
    @Step("получение ответа при регистрации пользователя")
    public ValidatableResponse registerUserResponse(RegisterRequest request) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(request)
                .when()
                .post(REGISTER_API.getConstant())
                .then();
    }

    @Step("получение ответа при удаление пользователя")
    public ValidatableResponse deleteUserResponse(String token) {
        return given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when()
                .delete(USER_API.getConstant())
                .then();
    }


}

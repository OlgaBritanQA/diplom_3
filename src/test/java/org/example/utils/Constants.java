package org.example.utils;

import lombok.Getter;

@Getter
public enum Constants {
    BASE_URL("https://stellarburgers.nomoreparties.site"),
    REGISTER_API("/api/auth/register"),
    LOGIN_API("/api/auth/login"),
    USER_API("/api/auth/user");

    private final String constant;

    Constants(final String constant) {
        this.constant = constant;
    }
}

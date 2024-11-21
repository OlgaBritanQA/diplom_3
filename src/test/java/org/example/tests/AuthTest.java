package org.example.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AuthTest extends BaseTest {
    @Override
    protected String getEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    }

    @Override
    protected String getPassword() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    @Override
    protected String getName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    @Override
    public void setUp() {
        super.setUp();
        registerClient.registerUserResponse(registerRequest);
    }

    //вход через кнопку «Личный кабинет»
    @Test
    public void testAuthPersonalAccountFlow() {
        AuthPage authPage = new AuthPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickHeaderPersonalAccountButton();

        authPageFlow(authPage, email, password);

        assertTrue("Не авторизовался через хедер", mainPage.isMainPage());
    }

    //вход по кнопке «Войти в аккаунт» на главной
    @Test
    public void testLogInFlow() {
        AuthPage authPage = new AuthPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickLogInButton();

        authPageFlow(authPage, email, password);

        assertTrue("Не авторизовался через хедер", mainPage.isMainPage());
    }

    //вход через кнопку в форме регистрации
    @Test
    public void testInRegistryLogInFlow() {
        AuthPage authPage = new AuthPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //кликаем по кнопке Личный Кабинет в хэдере
        mainPage.clickHeaderPersonalAccountButton();

        //кликаем по кнопке Зарегистрироваться
        authPage.clickRegisterButton();

        //клик по кнопке Войти
        registrationPage.clickLoginButton();

        authPageFlow(authPage, email, password);

        assertTrue("Не авторизовался через хедер", mainPage.isMainPage());
    }

    //вход через кнопку в форме восстановления пароля.
    @Test
    public void testInRecoverPassLogInFlow() {
        AuthPage authPage = new AuthPage(driver);
        MainPage mainPage = new MainPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        //кликаем по кнопке Личный Кабинет в хэдере
        mainPage.clickHeaderPersonalAccountButton();

        //кликаем по кнопке восстановить пароль
        authPage.clickForgotPasswordButton();

        //кликаем по кнопке Войти
        forgotPasswordPage.clickAuthButton();

        authPageFlow(authPage, email, password);

        assertTrue("Не авторизовался через хедер", mainPage.isMainPage());
    }

    @Test
    public void testLogOutFlow() {
        AuthPage authPage = new AuthPage(driver);
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickLogInButton();

        authPageFlow(authPage, email, password);

        //кликаем по кнопке Личный Кабинет в хэдере
        mainPage.clickHeaderPersonalAccountButton();

        profilePage.clickLogoutButton();


        assertTrue("Не авторизовался через хедер", authPage.isAuthForm());
    }

    private void authPageFlow(AuthPage authPage, String email, String password) {
        authPage.emailFulfil(email);
        authPage.passwordFulfil(password);
        authPage.clickAuthButton();
    }
}

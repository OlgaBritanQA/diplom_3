package org.example.tests;

import io.qameta.allure.Description;
import org.example.pages.AuthPage;
import org.example.pages.MainPage;
import org.example.pages.RegistrationPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegisterTest extends BaseTest {
    private final String name;
    private final String email;
    private final String password;

    public RegisterTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    protected String getEmail() {
        return email;
    }

    @Override
    protected String getPassword() {
        return password;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public void setUp() {
        super.setUp();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "ivan321123@gmail.com", "test321123"},
                {"Марина", "marina321123@gmail.com", "test33333"}
        });
    }

    @Description("Проверка успешной регистрации")
    @Test
    public void testRegisterFlow() {
        AuthPage authPage = new AuthPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //кликаем по кнопке Личный Кабинет в хэдере
        mainPage.clickHeaderPersonalAccountButton();

        //кликаем по кнопке Зарегистрироваться
        authPage.clickRegisterButton();

        //заполняем форму регистрации
        registrationPage.nameFulfil(name);
        registrationPage.emailFulfil(email);
        registrationPage.passwordFulfil(password);

        //нажимаем кнопку Зарегистрироваться
        registrationPage.clickRegistrationButton();

        assertTrue("Не зарегистрировался", authPage.isAuthForm());
    }

    @Description("Проверка, что нельзя зарегистрироваться с некорректной длинной пароля")
    @Test
    public void testFailRegisterFlow() {
        AuthPage authPage = new AuthPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //кликаем по кнопке Личный Кабинет в хэдере
        mainPage.clickHeaderPersonalAccountButton();

        //кликаем по кнопке Зарегистрироваться
        authPage.clickRegisterButton();

        //заполняем форму регистрации
        registrationPage.nameFulfil(name);
        registrationPage.emailFulfil(email);

        //проверяем длину пароля, если больше 5 символов то обрезаем до 5
        String truncatedPassword = password.length() > 5 ? password.substring(0, 5) : password;
        registrationPage.passwordFulfil(truncatedPassword);

        //нажимаем кнопку Зарегистрироваться
        registrationPage.clickRegistrationButton();

        assertTrue("Зарегистрировался, но не должен был", registrationPage.isErrorDisplayed());
    }
}

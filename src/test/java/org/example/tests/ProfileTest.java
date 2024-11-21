package org.example.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.AuthPage;
import org.example.pages.MainPage;
import org.example.pages.ProfilePage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {
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
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickHeaderPersonalAccountButton();

        authPage.emailFulfil(email);
        authPage.passwordFulfil(password);
        authPage.clickAuthButton();

        mainPage.clickHeaderPersonalAccountButton();

        assertTrue("Не перешёл в личный кабинет", profilePage.isProfilePage());
    }
}

package org.example.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.AuthPage;
import org.example.pages.MainPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HeaderButtonsTest extends BaseTest {
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

    //переход по клику на логотип Stellar Burgers
    @Test
    public void testStellarBurgersClick() {
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = new AuthPage(driver);

        mainPage.clickHeaderPersonalAccountButton();

        authPage.clickStellarBurgerButton();

        assertTrue("Не перешёл на главную страницу при нажатие на лого", mainPage.isMainPage());
    }

    //переход по клику на «Конструктор»
    @Test
    public void testConstructorClick() {
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = new AuthPage(driver);

        mainPage.clickHeaderPersonalAccountButton();

        authPage.clickConstructorButton();

        assertTrue("Не перешёл на главную страницу при нажатие на конструктор", mainPage.isMainPage());
    }
}

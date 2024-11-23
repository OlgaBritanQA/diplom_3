package org.example.tests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.MainPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {
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

    /**
     * Переход к разделу «Начинки»
     * Так как простая проверка при переключении разделов отобразится ли элемент этого раздела не подходит,
     * потому что в html документе они сразу отображаются. Проверяю что открывается первая карточка из раздела
     * и так для всех разделов ниже.
     **/

    @Description("Проверка перехода во вкладку Начинки")
    @Test
    public void testFillingSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSectionFillingButton();

        mainPage.clickStuffingMeat();

        assertTrue("Не перешло в Начинки", mainPage.isStuffingMeatCard());
    }

    @Description("Проверка перехода во вкладку Соусы")
    @Test
    public void testSaucesSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSectionSaucesButton();

        mainPage.clickStuffingSauces();

        assertTrue("Не перешло в Соусы", mainPage.isSaucesCard());
    }

    /**
     * Здесь для проверки, что переход в секцию булки работает - сначала переходим в секцию начинки,
     * а затем возвращаемся в секцию булки
     **/

    @Description("Проверка перехода во вкладку Булки")
    @Test
    public void testBunsSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSectionFillingButton();

        mainPage.clickSectionBunsButton();

        mainPage.clickStuffingBuns();

        assertTrue("Не перешло в Булки", mainPage.isBunsCard());
    }
}

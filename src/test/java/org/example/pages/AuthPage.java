package org.example.pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class AuthPage {
    private final WebDriver driver;

    /**
     * локаторы
     **/
    private final By registerButton = By.className("Auth_link__1fOlj");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By emailInput = By.name("name");
    private final By passwordInput = By.name("Пароль");
    private final By authButton = By.className("button_button__33qZ0");
    private final By forgotPasswordButton = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");
    private final By logo = By.cssSelector(".AppHeader_header__logo__2D0X2");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    @Step("Нажатие на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(registerButton));
        driver.findElement(registerButton).click();
    }

    @Step("Проверка что это форма авторизации")
    public boolean isAuthForm() {
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Заполенение поля имейл")
    public void emailFulfil(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполенение поля пароль")
    public void passwordFulfil(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажатие кнопки авторизации")
    public void clickAuthButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(authButton));
        driver.findElement(authButton).click();
    }

    @Step("Нажатие кнопки забыл пароль")
    public void clickForgotPasswordButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(forgotPasswordButton));
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Нажатие на кнопку StellarBurger")
    public void clickStellarBurgerButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(logo));
        driver.findElement(logo).click();
    }

    @Step("Нажатие на кнопку Конструктор")
    public void clickConstructorButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(constructorButton));
        driver.findElement(constructorButton).click();
    }
}

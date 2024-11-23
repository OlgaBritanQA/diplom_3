package org.example.pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class RegistrationPage {
    private final WebDriver driver;

    /**
     * локаторы
     **/
    //локатор для поля имя
    private final By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    //локатор для поля эмейла
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    //локатор для поля пароля
    private final By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");

    //локатор для ошибки ввода
    private final By errorInput = By.cssSelector("p.input__error.text_type_main-default");

    //локатор кнопки регистрации
    private final By registerButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    //локатор кнопки Войти
    private final By loginButton = By.xpath("//a[text()='Войти']");

    @Step("Заполняем поля Имя")
    public void nameFulfil(String firstName) {
        driver.findElement(nameInput).sendKeys(firstName);
    }

    @Step("Заполняем поля Фамилия")
    public void emailFulfil(String secondName) {
        driver.findElement(emailInput).sendKeys(secondName);
    }

    @Step("Заполняем поля Адрес куда привезти")
    public void passwordFulfil(String deliveryAddress) {
        driver.findElement(passwordInput).sendKeys(deliveryAddress);
    }

    @Step("Клик по кнопке регистрация")
    public void clickRegistrationButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(registerButton));
        driver.findElement(registerButton).click();
    }

    @Step("Клик по кнопке Логин")
    public void clickLoginButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(loginButton));
        driver.findElement(loginButton).click();
    }
    @Step("Проверяем сообщение об ошибке")
    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorInput).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

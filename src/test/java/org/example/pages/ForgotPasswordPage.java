package org.example.pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class ForgotPasswordPage {
    private final WebDriver driver;

    /**
     * локаторы
     **/
    private final By loginLink = By.xpath("//a[contains(text(), 'Войти')]");

    @Step("Нажатие на кнопку авторизации")
    public void clickAuthButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(loginLink));
        driver.findElement(loginLink).click();
    }
}

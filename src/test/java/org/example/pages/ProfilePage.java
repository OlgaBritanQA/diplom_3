package org.example.pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class ProfilePage {
    private final WebDriver driver;

    /**
     * локаторы
     **/
    private final By logoutButton = By.xpath("//button[contains(@class, 'Account_button__14Yp3') and text()='Выход']");

    @Step("Провряем что это личный кабинет")
    public boolean isProfilePage() {
        try {
            return driver.findElement(logoutButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Нажатие на кнопку Выйти")//методы для нажатия кнопки выход
    public void clickLogoutButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(logoutButton));
        driver.findElement(logoutButton).click();
    }
}

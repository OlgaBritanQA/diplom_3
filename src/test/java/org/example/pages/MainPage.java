package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * локаторы
     **/
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By logInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By textInMainPage = By.className("text_type_main-large");
    private final By stuffingMeatButton = By.xpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    private final By stuffingSaucesButton = By.xpath("//img[@alt='Соус Spicy-X']");
    private final By stuffingBunsButton = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");
    private final By stuffingMeatText = By.xpath("//p[text()='Мясо бессмертных моллюсков Protostomia']");
    private final By stuffingSaucesText = By.xpath("//p[text()='Соус Spicy-X']");
    private final By stuffingBunsText = By.xpath("//p[text()='Флюоресцентная булка R2-D3']");
    private final By sectionFillingButton = By.xpath("//span[text()='Начинки']");
    private final By sectionSaucesButton = By.xpath("//span[text()='Соусы']");
    private final By sectionBunsButton = By.xpath("//span[text()='Булки']");

    @Step("Нажатие на кнопку Личный кабинет")
    public void clickHeaderPersonalAccountButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажатия кнопки войти в аккаунт")
    public void clickLogInButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(logInButton));
        driver.findElement(logInButton).click();
    }

    @Step("Клик по секции Начинки")
    public void clickSectionFillingButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(sectionFillingButton));
        driver.findElement(sectionFillingButton).click();
    }

    @Step("Клик по секции Булки")
    public void clickSectionBunsButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(sectionBunsButton));
        driver.findElement(sectionBunsButton).click();
    }

    @Step("Клик по секции Соусы")
    public void clickSectionSaucesButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(sectionSaucesButton));
        driver.findElement(sectionSaucesButton).click();
    }

    @Step("Клик по Соусу Spicy-X")
    public void clickStuffingSauces() {
        driver.findElement(stuffingSaucesButton).click();
    }

    @Step("Клик по Флюоресцентная булка R2-D3")
    public void clickStuffingBuns() {
        driver.findElement(stuffingBunsButton).click();
    }

    @Step("Клик по начинке Мясо")
    public void clickStuffingMeat() {
        driver.findElement(stuffingMeatButton).click();
    }

    @Step("Провряем что карточка Булочки открывается")
    public boolean isBunsCard() {
        try {
            return driver.findElement(stuffingBunsText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Провряем что карточка Соусы открывается")
    public boolean isSaucesCard() {
        try {
            return driver.findElement(stuffingSaucesText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Провряем что карточка Начинки открывается")
    public boolean isStuffingMeatCard() {
        try {
            return driver.findElement(stuffingMeatText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Провряем что это стартовая страница")
    public boolean isMainPage() {
        try {
            return driver.findElement(textInMainPage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

package org.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.example.api.AuthClient;
import org.example.api.RegisterClient;
import org.example.api.data.RegisterRequest;
import org.example.api.data.User;
import org.example.utils.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.example.utils.Constants.BASE_URL;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static RegisterClient registerClient;
    protected static AuthClient authClient;
    protected static User user;
    protected static RegisterRequest registerRequest;
    protected static String email;
    protected static String password;
    protected static String name;
    private final Browser browser = new Browser();

    protected abstract String getEmail();

    protected abstract String getPassword();

    protected abstract String getName();

    /**
     * Берёт из пропертей название браузера, если его там нет то используется по умолчанию chrome
     * команда mvn clean test -Dbrowser=yandex "Dbrowser" писать слитно
     * для того что бы заработало нужно скачать файл https://github.com/yandex/YandexDriver/releases/download/v24.10.1-stable/yandexdriver-24.10.1.598-win64.zip
     * разархивировать его и указать путь в методе getDriver до драйвера и до yandex браузера.
     **/

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser");
        driver = browser.getDriver(browserName);
        driver.get(BASE_URL.getConstant());
        driver.manage().timeouts().implicitlyWait(Duration.of(2, SECONDS));

        RestAssured.baseURI = BASE_URL.getConstant();
        registerClient = new RegisterClient();
        authClient = new AuthClient();
        email = getEmail();
        password = getPassword();
        name = getName();
        registerRequest = new RegisterRequest(email, password, name);
        user = new User(email, password);
    }

    /**
     * После каждого теста, пытается залогиниться с данными логин и пароль,
     * и если получается, то удаляет этого пользователя
     **/
    @After
    public void driverQuit() {
        driver.quit();

        ValidatableResponse dataUser = authClient.loginUserResponse(user);
        String token = dataUser.extract().path("accessToken");

        if (token != null) {
            ValidatableResponse deleteResponse = registerClient.deleteUserResponse(token);
            deleteResponse.statusCode(202);
        }
    }
}

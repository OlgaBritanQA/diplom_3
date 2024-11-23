package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.nio.file.Paths;

public class Browser {
    public WebDriver getDriver(String browserName) {
        if (browserName == null) {
            browserName = "chrome";
        }

        switch (browserName) {
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver",
                        Paths.get("drivers", "yandexdriver.exe").toAbsolutePath().toString()
                );
                ChromeOptions options = new ChromeOptions();
                options.setBinary(Paths.get("browser",
                        "YandexBrowser\\browser.exe").toAbsolutePath().toString()
                );

                return new ChromeDriver(options);
            default:
                return new EdgeDriver();
        }
    }
}

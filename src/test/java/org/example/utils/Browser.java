package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
    public WebDriver getDriver(String browserName) {
        if (browserName == null) {
            browserName = "chrome";
        }

        switch (browserName) {
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:\\Path\\to\\yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Path\\to\\YandexBrowser\\browser.exe");

                return new ChromeDriver(options);
            default:
                return new EdgeDriver();
        }
    }
}

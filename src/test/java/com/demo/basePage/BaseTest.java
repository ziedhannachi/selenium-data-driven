package com.demo.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected final String jsonFilePath = "src/test/resources/credentials.json";

    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
    }

    public void tearDown() {
        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}

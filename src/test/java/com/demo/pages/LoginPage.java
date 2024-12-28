package com.demo.pages;

import com.demo.utils.JsonUtils;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    // Locators
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates to the URL from the JSON file.
     *
     * @param jsonFilePath Path to the JSON file containing the URL.
     */
    public void navigateToLoginPage(String jsonFilePath) {
        JsonObject data = JsonUtils.readJsonFile(jsonFilePath);
        String url = JsonUtils.getValue(data, "url");
        driver.get(url);
    }

    /**
     * Reads credentials from a JSON file and performs the login action.
     *
     * @param jsonFilePath Path to the JSON file containing the credentials.
     */
    public void login(String jsonFilePath) {
        // Read JSON credentials
        JsonObject credentials = JsonUtils.readJsonFile(jsonFilePath);
        String username = credentials.get("username").getAsString();
        String password = credentials.get("password").getAsString();

        // Perform login steps
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Helper methods for login actions
    private void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    private void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    private void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

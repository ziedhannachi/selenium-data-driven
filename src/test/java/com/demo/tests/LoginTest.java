package com.demo.tests;

import com.demo.basePage.BaseTest;
import com.demo.pages.LoginPage;
import com.demo.utils.Config;

import java.util.Objects;

public class LoginTest extends BaseTest {

    public static void main(String[] args) throws InterruptedException {

        LoginTest test = new LoginTest();
        test.setUp();

        // Initialize the LoginPage object
        LoginPage loginPage = new LoginPage(test.driver);

        // Navigate to the login page using the URL from JSON
        loginPage.navigateToLoginPage(Config.JSON_FILE_PATH);
        Thread.sleep(3000);

        loginPage.login(Config.JSON_FILE_PATH);

        // Validate the login by checking the current URL
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        if (Objects.equals(test.driver.getCurrentUrl(), url)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the browser
        test.tearDown();
    }
}

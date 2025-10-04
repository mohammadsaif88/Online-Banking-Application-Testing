package com.example.onlinebanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("loginBtn");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(String baseUrl){
        driver.get(baseUrl + "/login.html");
    }

    public void login(String user, String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}

package com.example.onlinebanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferPage {
    private WebDriver driver;
    private By toAcc = By.id("toAcc");
    private By amount = By.id("amount");
    private By transferBtn = By.id("transferBtn");
    private By message = By.id("message");

    public TransferPage(WebDriver driver){ this.driver = driver; }

    public void transfer(String to, String amt){
        driver.findElement(toAcc).clear();
        driver.findElement(toAcc).sendKeys(to);
        driver.findElement(amount).clear();
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(transferBtn).click();
    }

    public String getMessage(){ return driver.findElement(message).getText(); }
}

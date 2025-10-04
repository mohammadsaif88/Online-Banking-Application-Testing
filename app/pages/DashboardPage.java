package com.example.onlinebanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By balance = By.id("bal");
    private By transferLink = By.linkText("Transfer Funds");
    private By txLink = By.linkText("View Transactions");

    public DashboardPage(WebDriver driver){ this.driver = driver; }

    public String getBalanceText(){ return driver.findElement(balance).getText(); }

    public void goToTransfer(){ driver.findElement(transferLink).click(); }

    public void goToTransactions(){ driver.findElement(txLink).click(); }
}

package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.WithdrawalPage;
import com.crm.qa.pages.CustomerLoginPage;

// This class contains test cases related to Withdrawal process
public class WithdrawlTest extends TestBase {
    CustomerLoginPage loginPage;
    WithdrawalPage accountPage;
    
    // Test data from configuration file
    String AccountexistUser = prop.getProperty("AccontExistUser");
    String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");
    int ValidAmount = Integer.valueOf(prop.getProperty("ValidAmount"));
    int InValidAmount = Integer.valueOf(prop.getProperty("InValidAmount"));
    String Successfull = prop.getProperty("Successfull");
    String inSufficient = prop.getProperty("inSufficient");
    int InSufficient_Amount = Integer.valueOf(prop.getProperty("InSufficient_Amount"));
    
    // Constructor to call TestBase constructor
    public WithdrawlTest() {
        super();
    }
    
    // Setup method to initialize objects before each test method
    @BeforeMethod
    public void setUp() {
        // Initialize the browser and navigate to the URL
        initialization();
        try {
            loginPage = new CustomerLoginPage();
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
        // Login as a customer and go to Withdrawal Page
        accountPage = loginPage.CustomerLogin(AccountexistUser);
    }
    
    // Test method to verify withdrawal with valid amount
    @Test(priority=1)
    public void Verify_Withdraw_With_ValidAmount() throws InterruptedException {
        // Perform withdrawal with valid amount
        accountPage.ValidWithdraw(Successfull, ValidAmount);
        
        // Add assertions or verifications for the successful withdrawal
    }
    
    // Test method to verify withdrawal with invalid amount
    @Test(priority=2)
    public void Verify_Withdraw_With_InvalidAmount() throws InterruptedException {
        // Perform withdrawal with invalid amount
        accountPage.InValidWithdraw(InValidAmount);
        
        // Add assertions or verifications for the invalid withdrawal
    }
    
    // Test method to verify withdrawal with insufficient funds
    @Test(priority=3)
    public void Verify_Withdraw_With_Insufficient() throws InterruptedException {
        // Perform withdrawal with insufficient funds
        accountPage.ValidWithdraw(inSufficient, InSufficient_Amount);
        
        // Add assertions or verifications for the withdrawal with insufficient funds
    }
    
    // Tear down method to close the browser after each test method
    @AfterMethod
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
}
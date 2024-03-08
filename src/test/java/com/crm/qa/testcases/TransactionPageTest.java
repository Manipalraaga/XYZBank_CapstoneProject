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
import com.crm.qa.pages.TransactionPage;
import com.crm.qa.pages.CustomerLoginPage;

// This class contains test cases related to Transaction Page
public class TransactionPageTest extends TestBase {
    CustomerLoginPage loginPage;
    TransactionPage customerTransactionPage;
    
    // Test data from configuration file
    String date = prop.getProperty("ValidationDate");
    String Startdate = prop.getProperty("StartDate");
    String Enddate = prop.getProperty("EndDate");
    
    String AccountexistUser = prop.getProperty("AccontExistUser");
    
    // Constructor to call TestBase constructor
    public TransactionPageTest() {
        super();
    }
    
    // Setup method to initialize objects before each test method
    @BeforeMethod
    public void setUp() {
        initialization();
        try {
            loginPage = new CustomerLoginPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Login as a customer and go to Transaction Page
        customerTransactionPage = loginPage.CustomerLogin1(AccountexistUser);
    }
    
    // Test method to verify deposit with a valid amount
    @Test(priority=1)
    public void Verify_Deposit_With_ValidAmount() {
        // Filter transactions within a specified date range
        customerTransactionPage.Filter(Startdate, Enddate);
        
        // Add assertions or verifications for the filtered transactions
    }
    
    // Tear down method to close the browser after each test method
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
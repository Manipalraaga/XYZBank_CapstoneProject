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
import com.crm.qa.pages.CustomerLoginPage;
import com.crm.qa.pages.OpenAccountPage;

// This class contains test cases related to Open Account Page
public class OpenAccountPageTest extends TestBase {
    CustomerLoginPage loginPage;
    OpenAccountPage openAccountPage;
    
    // Test data from configuration file
    String OpenAccount_username = prop.getProperty("OpenAccount_username");
    
    // Constructor to call TestBase constructor
    public OpenAccountPageTest() {
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
        openAccountPage = loginPage.ManagerLogin1();
    }
    
    // Test method to open a new account
    @Test(priority=1)
    public void OpenAccount() throws InterruptedException {
        // Click on the "Open Account" button
        openAccountPage.OpenAccount_button.click();
        
        // Add customer to open account
        openAccountPage.AddCustomer(OpenAccount_username);
    }
    
    // Tear down method to close the browser after each test method
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
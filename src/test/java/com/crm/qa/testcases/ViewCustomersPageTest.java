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
import com.crm.qa.pages.ViewCustomersPage;
import com.crm.qa.pages.CustomerLoginPage;

// This class contains test cases related to View Customers Page
public class ViewCustomersPageTest extends TestBase {
    CustomerLoginPage loginPage;
    ViewCustomersPage customersPage;
    
    // Test data from configuration file
    String Customers_username = prop.getProperty("Customers_username");
    
    // Constructor to call TestBase constructor
    public ViewCustomersPageTest() {
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
        // Login as a manager and go to View Customers Page
        customersPage = loginPage.ManagerLogin2();
    }
    
    // Test method to delete a customer entry
    @Test(priority=1)
    public void DeleteCustomerEntry() throws InterruptedException {
        // Delete customer entry with the specified user name
        customersPage.DeleteEntry(Customers_username);
        
        // Add assertions or verifications for the deletion process
    }
    
    // Tear down method to close the browser after each test method
    @AfterMethod
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
}
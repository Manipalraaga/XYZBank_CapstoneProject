package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.WithdrawalPage;
import com.crm.qa.pages.CustomerLoginPage;

// This class contains test cases related to Customer Login
public class CustomerLoginTest extends TestBase {
    CustomerLoginPage loginPage;
    WithdrawalPage accountPage;
    
    // Test data from configuration file
    String AccountexistUser = prop.getProperty("AccontExistUser");
    String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");
    
    // Constructor to call TestBase constructor
    public CustomerLoginTest(){
        super();
    }
    
    // Setup method to initialize objects before each test method
    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new CustomerLoginPage();
        accountPage = new WithdrawalPage();
    }
    
    // Test method to login with an existing customer
    @Test(priority=1)
    public void customerlogin() {
        // Perform customer login
        loginPage.CustomerLogin(AccountexistUser);
        
        // Verify if the customer name matches the logged-in user
        String name = accountPage.verifyCustomerName();
        AssertJUnit.assertEquals(AccountexistUser, name);
    }
    
    // This test is commented out as it's not being used currently
//    @Test(priority=2)
//    public void customerlogin_Not_Exist() {
//        // Perform customer login with a non-existing account
//        loginPage.CustomerLogin(AccountNot_existUser);
//        
//        // Add assertions or checks for non-existing account behavior
//    }
    
    // Tear down method to close the browser after each test method
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
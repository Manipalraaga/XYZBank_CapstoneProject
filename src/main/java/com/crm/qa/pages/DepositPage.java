package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.TestBase.TestBase;

// This class represents the Deposit Page in the CRM application
public class DepositPage extends TestBase {

    // WebElement for the Deposit button
    @FindBy(xpath="//button[@ng-click='deposit()']")
    private WebElement depositButton;

    // WebElement for the Amount field
    @FindBy(xpath="//input[@placeholder='amount']")
    private WebElement amountField;

    // WebElement for the Submit button
    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitButton;

    // WebElement for displaying error messages
    @FindBy(xpath="//span[@class='error ng-binding']")
    private WebElement message;

    // Initializing the Page Objects:
    // This constructor initializes the elements of the DepositPage
    public DepositPage() {
        PageFactory.initElements(driver, this);
    }

    // Method to enter the deposit amount into the amount field
    // This method clears the amount field and enters the provided amount
    public void enterDepositAmount(int amount) {
        amountField.clear();
        amountField.sendKeys(String.valueOf(amount));
    }

    // Method to click the submit button for the deposit
    // This method clicks the submit button for the deposit
    public void submitDeposit() {
        submitButton.click();
    }

    // Method to perform a deposit with the given amount
    // This method clicks the deposit button, enters the amount, and submits
    public void depositAmount(int amount) {
        depositButton.click();
        amountField.clear();
        amountField.sendKeys(String.valueOf(amount));
        submitButton.click();
    }

    // Method to get the message displayed after deposit
    // This method returns the text of the message element
    public String getMessage() {
        return message.getText();
    }
}
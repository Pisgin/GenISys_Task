package com.GenISys_task.pages;

import com.GenISys_task.utilities.BrowserUtils;
import com.GenISys_task.utilities.ConfigurationReader;
import com.GenISys_task.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(){

        PageFactory.initElements(Driver.getDriver() , this);
    }

    //--------------------------------- Webelements --------------------------------------

    @FindBy ( xpath = "//button[@class = 'button register']")
    private WebElement newUserButton;

    @FindBy ( xpath = "//button[@class = 'button button--intro']")
    private  WebElement confirmButton;

    @FindBy ( xpath = "//input[@class = 'input']")
    private WebElement emailBox;

    @FindBy ( xpath = "//button[@class = 'input-button input-button--show']")
    private WebElement emailPage_enterButton;

    @FindBy ( xpath =  "//input[@type = 'text']")
    private WebElement countryCode;

    @FindBy ( xpath = "//input[@type = 'number']")
    private WebElement phoneNumber;

    @FindBy ( xpath = "//button[@class = 'input-button']")
    private WebElement phonePage_enterButton;

    @FindBy ( xpath = "//input[@class = 'input']")
    private WebElement fullnameBox;

    @FindBy ( xpath = "//button[@class = 'input-button input-button--show']")
    private WebElement fullnamePage_enterButton;

    @FindBy ( xpath = "//input[@class = 'input']")
    private WebElement passwordBox;

    @FindBy ( xpath = "//button[@class = 'input-button input-button--show']")
    private WebElement passwordPage_enterButton;

    @FindBy ( xpath = "//h3[. = '✨ Your registration is complete! ✨']")
    private WebElement register_complete;

    @FindBy ( xpath = "//button[. = 'Login']")
    private WebElement loginButton;

    //---------------------------------Variables------------------------------------------

    public static Faker faker = new Faker();
    public static String email = faker.internet().emailAddress();
    String randomCountryCode = faker.numerify("+##");
    String randomNumber = faker.numerify("##########");
    String fullname = faker.name().fullName();
    String password = faker.internet().password(6,8);

    //--------------------------------- Methods ------------------------------------------

    public void go_to_website(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.sleep(1);
    }

    public void register(){

        newUserButton.click();
        BrowserUtils.sleep(1);
        confirmButton.click();
        BrowserUtils.sleep(1);
    }

    public void emailPage(){

        emailBox.sendKeys(email);
        BrowserUtils.sleep(1);
        emailPage_enterButton.click();
        BrowserUtils.sleep(1);
    }

    public void phoneNumberPage(){

        countryCode.sendKeys(randomCountryCode);
        phoneNumber.sendKeys(randomNumber);
        BrowserUtils.sleep(1);
        phonePage_enterButton.click();
        BrowserUtils.sleep(1);
    }

    public void fullNamePage(){

        fullnameBox.sendKeys(fullname);
        BrowserUtils.sleep(1);
        fullnamePage_enterButton.click();
        BrowserUtils.sleep(1);
    }

    public void passwordPage(){

        passwordBox.sendKeys(password);
        BrowserUtils.sleep(1);
        passwordPage_enterButton.click();
        BrowserUtils.sleep(1);
    }

    public void completeRegisterPage(){

        loginButton.click();
        BrowserUtils.sleep(1);
    }

    public void register_assert(){

        String actual_result = "✨ Your registration is complete! ✨";

        String expected_result = register_complete.getText();

        Assert.assertEquals( actual_result , expected_result );

    }

}

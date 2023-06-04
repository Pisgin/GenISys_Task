package com.GenISys_task.pages;

import com.GenISys_task.utilities.BrowserUtils;
import com.GenISys_task.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver() , this);
    }

    //-------------------------------------------WEBELEMENTS---------------------------------------

    @FindBy ( xpath = "//input[@class = 'input']")
    private WebElement emailBox;

    @FindBy ( xpath = "//button[@class = 'input-button input-button--show']")
    private WebElement login_enterButton;

    @FindBy ( xpath = "//h1[@class = 'big-text']")
    private WebElement logo;

    @FindBy ( xpath =  "//button[. = 'Returning user']")
    private WebElement returninigUserButton;

    @FindBy ( xpath = "//h1[@class = 'big-text']")
    private WebElement text;

    //---------------------------------------------VARIABLES---------------------------------------

    RegisterPage registerPage = new RegisterPage();
    String email = registerPage.email;

    //---------------------------------------------METHODS-----------------------------------------

    public void login(){

        returninigUserButton.click();
        BrowserUtils.sleep(1);
        emailBox.sendKeys(email);
        BrowserUtils.sleep(1);
        login_enterButton.click();
    }

    public void assert_login(){

        Assert.assertTrue(logo.isDisplayed());
        System.out.println("LOGIN SUCCESSFUL");

    }

}

package com.GenISys_task.step_Definitions;

import com.GenISys_task.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_stepDefinitions {

    LoginPage loginPage = new LoginPage();


    @When("The user can be able to login")
    public void the_user_can_be_able_to_login() {

        loginPage.login();

    }

    @Then("The user can be able to check that he\\/she are logged in")
    public void the_user_can_be_able_to_check_that_he_she_are_logged_in() {

        loginPage.assert_login();
    }

}

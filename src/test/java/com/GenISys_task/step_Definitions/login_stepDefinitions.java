package com.GenISys_task.step_Definitions;

import com.GenISys_task.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login_stepDefinitions {

    loginPage loginPage = new loginPage();



    @When("kullanici login olabilmeli")
    public void kullanici_login_olabilmeli() {

        loginPage.login();

    }


    @Then("kullanici login oldugunu check edebilmelidir")
    public void kullanici_login_oldugunu_check_edebilmelidir() {

        loginPage.assert_login();

    }




}

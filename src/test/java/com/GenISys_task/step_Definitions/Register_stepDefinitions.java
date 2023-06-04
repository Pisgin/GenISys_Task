package com.GenISys_task.step_Definitions;

import com.GenISys_task.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_stepDefinitions {

    RegisterPage registerPage = new RegisterPage();

    //---------------------------------------SCENARIO 1------------------------------------------------


    @Given("The user can be able to navigate to the tour page")
    public void the_user_can_be_able_to_navigate_to_the_tour_page() {

        registerPage.go_to_website();

    }

    @When("The user can be able to log in as a new user")
    public void the_user_can_be_able_to_log_in_as_a_new_user() {

        registerPage.register();

    }

    @And("The user can be able to enter their email address")
    public void the_user_can_be_able_to_enter_their_email_address() {

        registerPage.emailPage();

    }

    @And("The user can be able to enter phone number")
    public void the_user_can_be_able_to_enter_phone_number() {

        registerPage.phoneNumberPage();

    }

    @And("The user can be able to enter name and surname")
    public void the_user_can_be_able_to_enter_name_and_surname() {

        registerPage.fullNamePage();
    }

    @And("The user can be able to set a password")
    public void the_user_can_be_able_to_set_a_password() {

        registerPage.passwordPage();
    }

    @Then("The user registration can be completed.")
    public void the_user_registration_can_be_completed() {

        registerPage.register_assert();

        registerPage.completeRegisterPage();

    }

}

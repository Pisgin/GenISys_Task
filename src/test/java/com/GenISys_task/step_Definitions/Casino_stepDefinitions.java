package com.GenISys_task.step_Definitions;


import com.GenISys_task.pages.CasinoGamePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Casino_stepDefinitions {

    CasinoGamePage casinoGamePage = new CasinoGamePage();


    //--------------------------------------------SCENARIO - 3------------------------------------------------


    @Given("The user can be able to login from tour page")
    public void the_user_can_be_able_to_login_from_tour_page() {

        casinoGamePage.tourPage();

    }

    @When("The user can be able to enter the Casino page")
    public void the_user_can_be_able_to_enter_the_casino_page() {

        casinoGamePage.casinoGame();

    }

    @Then("The user can be able to see that he\\/she cannot play without a balance")
    public void the_user_can_be_able_to_see_that_he_she_cannot_play_without_a_balance() {

        casinoGamePage.casinoGame_bakiye_yok();

    }


    //--------------------------------------------SCENARIO - 4------------------------------------------------


    @Given("The user can be able to login from the tour page and go to the Casino page")
    public void the_user_can_be_able_to_login_from_the_tour_page_and_go_to_the_casino_page() {

        casinoGamePage.tourPage();

        casinoGamePage.casinoGame();

    }

    @When("The user can be able to top up and check his\\/her account")
    public void the_user_can_be_able_to_top_up_and_check_his_her_account() {

        casinoGamePage.casinoGame_bakiye_update();

        casinoGamePage.bakiye_check();

    }

    @And("The user can be able to control the options in the Casino game")
    public void the_user_can_be_able_to_control_the_options_in_the_casino_game() {

        casinoGamePage.cats();
    }

    @Then("the user can be able to see that his\\/her balance increases when his\\/her win and decreases when his\\/her lose")
    public void the_user_can_be_able_to_see_that_his_her_balance_increases_when_his_her_win_and_decreases_when_his_her_lose() {

        casinoGamePage.bakiye_control();
    }




}

package com.GenISys_task.step_Definitions;

import com.GenISys_task.pages.CasinoGamePage;
import com.GenISys_task.pages.LoginPage;
import com.GenISys_task.pages.RegisterPage;
import com.GenISys_task.pages.LotteryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Lottery_stepDefinitions {

    LotteryPage lotteryPage = new LotteryPage();
    CasinoGamePage casinoGamePage = new CasinoGamePage();


    //--------------------------------------SCENARIO 5---------------------------------


    @Given("The user can be able to login from the tour page and go to the Lottery page")
    public void the_user_can_be_able_to_login_from_the_tour_page_and_go_to_the_lottery_page() {

        casinoGamePage.tourPage();

        casinoGamePage.bakiye_update();

        lotteryPage._lotteryPage();

    }

    @When("The user can be able to add new lottery")
    public void the_user_can_be_able_to_add_new_lottery() {

        lotteryPage.add_ticket();

        lotteryPage.delete_ticket();

    }

    @And("The user can be able to buy Lottery as a single ticket")
    public void the_user_can_be_able_to_buy_lottery_as_a_single_ticket() {

        lotteryPage.secim();
    }

    @Then("The user can be able to see the change in the balance after the purchase")
    public void the_user_can_be_able_to_see_the_change_in_the_balance_after_the_purchase() {

        lotteryPage.check();
    }


    //--------------------------------------SCENARIO 6---------------------------------


    @And("The user can be able to add new lotteries")
    public void the_user_can_be_able_to_add_new_lotteries() {

        lotteryPage.add_ticket();

        lotteryPage.add_ticket();

        lotteryPage.add_ticket();

        lotteryPage.delete_ticket();

    }

    @And("The user can be able to choose new lotteries")
    public void the_user_can_be_able_to_choose_new_lotteries() {

        lotteryPage.secim();
    }

    @And("THe user can be able to buy lotteries")
    public void t_he_user_can_be_able_to_buy_lotteries() {

        lotteryPage.lottery_satin_alma();
    }

}

package com.GenISys_task.step_Definitions;

import com.GenISys_task.pages.casinoGamePage;
import com.GenISys_task.pages.loginPage;
import com.GenISys_task.pages.registerPage;
import com.GenISys_task.pages.lotteryPage;
import com.GenISys_task.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.swing.text.AbstractDocument;

public class Lottery_stepDefinitions {

    lotteryPage lotteryPage = new lotteryPage();
    registerPage registerPage = new registerPage();
    loginPage loginPage = new loginPage();
    casinoGamePage casinoGamePage = new casinoGamePage();


    //--------------------------------------scenario---------------------------------


    @Given("kullanici tour sayfasindan login olup Lottery sayfasina gidebilmeli")
    public void kullanici_tour_sayfasindan_login_olup_lottery_sayfasina_gidebilmeli() {

        casinoGamePage.tourPage();

        casinoGamePage.bakiye_update();

        lotteryPage._lotteryPage();

    }

    @When("kullanici tek bilet olarak Lottery satin alabilmeli")
    public void kullanici_tek_bilet_olarak_lottery_satin_alabilmeli() {

        lotteryPage.satin_alma();

    }

    @Then("kulllanici satin almadan sonra bakiyedeki degisimi gorebilmelidir")
    public void kulllanici_satin_almadan_sonra_bakiyedeki_degisimi_gorebilmelidir() {

        lotteryPage.check();

    }

    //--------------------------------------scenario---------------------------------



    @When("kullanici yeni lotteryler ekleyebilmeli")
    public void kullanici_yeni_lotteryler_ekleyebilmeli() {

        lotteryPage.add_ticket();

        lotteryPage.add_ticket();

        lotteryPage.add_ticket();

        lotteryPage.delete_ticket();

    }


    @And("kullanici yeni lotterylere secim yapabilmeli")
    public void kullanici_yeni_lotterylere_secim_yapabilmeli() {

        lotteryPage.secim();

    }

    @And("kullanici lotteryleri satin alabilmeli")
    public void kullanici_lotteryleri_satin_alabilmeli() {

        lotteryPage.lottery_satin_alma();

    }




}

package com.GenISys_task.step_Definitions;


import com.GenISys_task.pages.registerPage;
import com.GenISys_task.pages.loginPage;
import com.GenISys_task.pages.casinoGamePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

public class casino_stepDefinitions {

    casinoGamePage casinoGamePage = new casinoGamePage();


    //--------------------------------------------SCENARIO - 3------------------------------------------------


    @Given("kullanici tour sayfasindan login olabilmeli")
    public void kullanici_tour_sayfasindan_login_olabilmeli() {

        casinoGamePage.tourPage();

    }


    @And("kullanici Casino sayfasina girdebilmeli")
    public void kullanici_casino_sayfasina_girdebilmeli() {

        casinoGamePage.casinoGame();
    }

    @Then("kullanici bakiyesi olmadan oyun oynayamadigini gorebilmelidir")
    public void kullanici_bakiyesi_olmadan_oyun_oynayamadigini_gorebilmelidir() {

        casinoGamePage.casinoGame_bakiye_yok();

    }


    //--------------------------------------------SCENARIO - 4------------------------------------------------

    @Given("kullanici tour sayfasindan login olup Casino sayfasina gidebilmeli")
    public void kullanici_tour_sayfasindan_login_olup_casino_sayfasina_gidebilmeli() {

        casinoGamePage.tourPage();

        casinoGamePage.casinoGame();

    }

    @When("kullanici hesabina para yükleyebilmeli ve check edebilmeli")
    public void kullanici_hesabina_para_yükleyebilmeli_ve_check_edebilmeli() {

        casinoGamePage.casinoGame_bakiye_update();

        casinoGamePage.bakiye_check();

    }

    @And("kullanici Casino oyununda secenekleri kontrol edebilmeli")
    public void kullanici_casino_oyununda_secenekleri_kontrol_edebilmeli() {

        casinoGamePage.cats();

    }

    @Then("kullanici oyundan  kazanc elde ettiginde bakiyesinin arttigini ve kaybettiginde bakiyenin azaldigini gorebilmelidir")
    public void kullanici_oyundan_kazanc_elde_ettiginde_bakiyesinin_arttigini_ve_kaybettiginde_bakiyenin_azaldigini_gorebilmelidir() {

        casinoGamePage.bakiye_control();

    }


}

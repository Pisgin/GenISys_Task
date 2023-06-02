package com.GenISys_task.step_Definitions;

import com.GenISys_task.pages.loginPage;
import com.GenISys_task.pages.registerPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class register_stepDefinitions {

    registerPage registerPage = new registerPage();

    //---------------------------------------SCENARIO 1------------------------------------------------

    @Given("kullanici tour sayfasına gelebilmeli")
    public void kullanici_tour_sayfasına_gelebilmeli() {

        registerPage.go_to_website();

    }

    @When("kullanici yeni kullanici girisi yapabilmeli")
    public void kullanici_yeni_kullanici_girisi_yapabilmeli() {

        registerPage.register();
    }

    @And("kullanici email adresini girebilmeli")
    public void kullanici_email_adresini_girebilmeli() {

        registerPage.emailPage();
    }

    @And("kullanici telefon numarasi girebilmeli")
    public void kullanici_telefon_numarasi_girebilmeli() {

        registerPage.phoneNumberPage();
    }

    @And("kullanici ad soyad girisi yapabilmeli")
    public void kullanici_ad_soyad_girisi_yapabilmeli() {

        registerPage.fullNamePage();
    }

    @And("kullanici sifre belirleyebilmeli")
    public void kullanici_sifre_belirleyebilmeli() {

        registerPage.passwordPage();
    }

    @Then("kullanicinin kayit islemi tamamlanmalidir..")
    public void kullanicinin_kayit_islemi_tamamlanmalidir() {

        registerPage.register_assert();

        registerPage.completeRegisterPage();
    }

    //--------------------------------------------------------------------------------



}

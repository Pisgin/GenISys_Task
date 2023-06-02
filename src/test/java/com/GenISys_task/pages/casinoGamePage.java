package com.GenISys_task.pages;

import com.GenISys_task.pages.registerPage;
import com.GenISys_task.utilities.BrowserUtils;
import com.GenISys_task.utilities.Driver;
import groovyjarjarantlr4.v4.runtime.dfa.SparseEdgeMap;
import io.cucumber.java.cs.Ale;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class casinoGamePage {

    public casinoGamePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //------------------------------------WEBELEMENTS---------------------------------

    @FindBy(xpath = "//div[@id = 'navigation']")
    private WebElement navigation;

    @FindBy(xpath = "//a[. = 'Casino']")
    private WebElement casinoButton;

    @FindBy ( xpath = "//img[@class = 'logo']")
    private WebElement logo;

    @FindBy ( xpath = "(//header[@class = 'game__header']/div)[3]")
    private WebElement depositButton;

    @FindBy ( xpath = "//header[@class = 'game__header']/div[5]/select")
    private WebElement betBox;

    @FindBy ( xpath = "(//div[@class = 'form-row'])[1]/select")
    private WebElement selectBox;

    @FindBy ( xpath = "//button[. = 'Card']")
    private WebElement cardButton;

    @FindBy ( xpath = "//button[. = '€500']")
    private WebElement _500Button;

    @FindBy ( xpath = "(//button[@class = 'button button--secondary'])[1]")
    private WebElement depositApprovedButton;

    @FindBy ( xpath = "//div[@class = 'modal__body']/div[4]/h3")
    private WebElement successfullMessage;

    @FindBy ( xpath = "//button[.='OK']")
    private WebElement OKButton;

    @FindBy ( xpath = "//button[@class = 'button money']")
    private WebElement money;

    @FindBy ( xpath = "//div[@class = 'modal__x']")
    private WebElement exitButton;

    @FindBy ( xpath = "//h1[@class = 'glow']")
    private WebElement congrat;


    //-------------------------------------VARIABLES----------------------------------

    registerPage registerPage = new registerPage();

    loginPage loginPage = new loginPage();

    public String email = loginPage.email;

    String temprory_budget_1;
    String temprory_budget_2;
    String budget_1= "";
    String budget_2= "";

    double cash_1;
    double cash_2;

    //--------------------------------------METHODS-----------------------------------

    public void String_to_Double_1(){

        temprory_budget_1 = money.getText();

        for ( int i = 1 ; i < temprory_budget_1.length() ; i++ ){
            budget_1 = budget_1 + temprory_budget_1.charAt(i);
        }

        cash_1 = Double.parseDouble(budget_1);
    }

    public void String_to_Double_2(){

        temprory_budget_2 = money.getText();

        for ( int i = 1 ; i < temprory_budget_2.length() ; i++ ){
            budget_2 = budget_2 + temprory_budget_2.charAt(i);
        }

        cash_2 = Double.parseDouble(budget_2);
    }

    public void bakiye_arttirma(){

        depositButton.click();
        BrowserUtils.sleep(1);

        Select select = new Select(selectBox);
        select.selectByIndex(1);

        Select select1 = new Select(betBox);
        select1.selectByIndex(2);

        cardButton.click();

        _500Button.click();

        depositApprovedButton.click();

        OKButton.click();
    }

    public void tourPage() {

        registerPage.go_to_website();

        loginPage.login();

    }

    public void casinoGame() {

        navigation.click();
        BrowserUtils.sleep(1);

        casinoButton.click();
        BrowserUtils.sleep(1);
    }

    public void casinoGame_bakiye_yok() {

        Driver.getDriver().switchTo().frame("game");

        List<WebElement> imagesList = Driver.getDriver().findElements(By.xpath("//img[@class = 'option__image']"));

        for (WebElement image : imagesList) {

            image.click();
            BrowserUtils.sleep(1);

            Alert alert = Driver.getDriver().switchTo().alert();

            alert.accept();

            BrowserUtils.sleep(1);
        }

        Driver.getDriver().switchTo().parentFrame();
    }

    public void bakiye_update(){

        BrowserUtils.sleep(1);

        String_to_Double_1();

        if (cash_1 == 0.00){

            money.click();

            cardButton.click();

            _500Button.click();

            depositApprovedButton.click();

            OKButton.click();

        }

    }

    public void casinoGame_bakiye_update(){

        String_to_Double_1();  // 1. para    0.0

        //System.out.println("cash_1 = " + cash_1);

        Driver.getDriver().switchTo().frame("game");

        bakiye_arttirma();  // ekleme olacak 500

        Driver.getDriver().switchTo().parentFrame();

        BrowserUtils.sleep(5);
        String_to_Double_2();  //2. para    500
       // System.out.println("cash_2 = " + cash_2);

        /*
        logo.click();

        casinoGame();

         */

    }

    public void bakiye_check(){

      //  Assert.assertTrue("TOPLAM BAKIYE ARTMISTIR" ,cash_1 < cash_2);

        if (cash_1 < cash_2)
            System.out.println("TOPLAM BAKIYE ARTMISTIR");
        else
            System.out.println("HERHANGI BİR DEGISIKLIK OLMADI");

    }

    public void cats(){

        int size = 1;
        Driver.getDriver().switchTo().frame("game");  // IFRAME HANDLE
        List<WebElement> imagesList = Driver.getDriver().findElements(By.xpath("//img[@class = 'option__image']")); // resimler listelendi.
        Driver.getDriver().switchTo().parentFrame();

        for (WebElement image : imagesList ) {
            cash_1= 0;
            cash_2 = 0;
            temprory_budget_1 = "";
            temprory_budget_2 = "";
            budget_1 = "";
            budget_2 = "";

            String_to_Double_1();

            Driver.getDriver().switchTo().frame("game");

            image.click();
            BrowserUtils.sleep(1);

            Driver.getDriver().switchTo().parentFrame();  // IFRAME HANDLE

            String_to_Double_2();

            if ( cash_2 > cash_1 )
                System.out.println(size + ". kedı kazandırdı");
            else
                System.out.println(size + ". kedi kaybettirdi");

            size++;

            bakiye_control();
        }

    }

    public void bakiye_control(){

        System.out.print("cash_1 = " + cash_1 + "   /   " + " cash_2 = " + cash_2);
        System.out.println();
        System.out.println();

        if (cash_2 > cash_1)
            System.out.println("YOU WON!");
        else
            System.out.println("YOU LOST");

    }
}

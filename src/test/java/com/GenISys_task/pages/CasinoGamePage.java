package com.GenISys_task.pages;

import com.GenISys_task.utilities.BrowserUtils;
import com.GenISys_task.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CasinoGamePage {

    public CasinoGamePage() {

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

    RegisterPage registerPage = new RegisterPage();

    LoginPage loginPage = new LoginPage();

    public String email = loginPage.email;

    String temprory_budget_1;
    String temprory_budget_2;
    String budget_1= "";
    String budget_2= "";

    double value1 = 0;
    double value2 = 0;

    double cash_1;
    double cash_2;

    //--------------------------------------METHODS-----------------------------------

    public double String_t0_Double1(){

        temprory_budget_1 = money.getText();

        for ( int i = 1 ; i < temprory_budget_1.length() ; i++ ){
            budget_1 = budget_1 + temprory_budget_1.charAt(i);
        }

        cash_1 = Double.parseDouble(budget_1);

        return cash_1;

    }

    public double String_to_Double2(){

        temprory_budget_2 = money.getText();

        for ( int i = 1 ; i < temprory_budget_2.length() ; i++ ){
            budget_2 = budget_2 + temprory_budget_2.charAt(i);
        }

        cash_2 = Double.parseDouble(budget_2);

        return cash_2;


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
        value1 = String_t0_Double1();

        if (cash_1 == 0.00){
            money.click();
            cardButton.click();
            _500Button.click();
            depositApprovedButton.click();
            OKButton.click();
        }

    }

    public void casinoGame_bakiye_update(){

        value1 = String_t0_Double1();

        Driver.getDriver().switchTo().frame("game");

        bakiye_arttirma();

        Driver.getDriver().switchTo().parentFrame();

        BrowserUtils.sleep(5);

        value2 = String_to_Double2();

    }

    public void bakiye_check(){

        if (value1< value2)
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

            temprory_budget_1 = "";
            temprory_budget_2 = "";
            budget_1 = "";
            budget_2 = "";

            value1 = String_t0_Double1();

            Driver.getDriver().switchTo().frame("game");

            image.click();
            BrowserUtils.sleep(1);

            Driver.getDriver().switchTo().parentFrame();  // IFRAME HANDLE

            value2 = String_to_Double2();

            if (value2 > value1)
                System.out.println(size + ". cat won");
            else
                System.out.println(size + ". cat losed");

            size++;
            bakiye_control();
        }

    }

    public void bakiye_control() {

        if (value2 > value1) {

            System.out.println("YOU WON!");
            Assert.assertTrue(value2 > value1);

        } else {
            System.out.println("YOU LOST");
            Assert.assertTrue(value2 <= value1);

        }
    }
}

package com.GenISys_task.pages;

import com.GenISys_task.utilities.BrowserUtils;
import com.GenISys_task.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class lotteryPage {

    public lotteryPage(){

        PageFactory.initElements(Driver.getDriver() , this);
    }

    //------------------------------------WEBELEMENTS---------------------------------------

    @FindBy ( xpath = "//div[@id='navigation']")
    private WebElement navigation;

    @FindBy ( xpath = "//a[.='Lottery']")
    private WebElement lotteryButton;

    @FindBy ( xpath = "//button[. = 'Buy tickets']")
    private WebElement buyTicketsButton;

    @FindBy ( xpath = "//button[@class = 'button money']")
    private WebElement money;

    @FindBy ( xpath = "(//button[@class = 'button'])[1]")
    private WebElement addAnotherTicketButton;

    @FindBy ( xpath = "(//button[@class = 'remove-line'])[1]")
    private WebElement deleteButton;

    @FindBy ( xpath = "//img[@class = 'logo']")
    private WebElement logo;

    @FindBy ( xpath = "//select[@class = 'form-input']")
    private WebElement draws;


    //-------------------------------------VARIABLES----------------------------------------

    casinoGamePage casinoGamePage = new casinoGamePage();

    Random randomNum = new Random();
    int toplam_ticket;
    String temprory_budget_1 , temprory_budget_2;
    String budget_1 ="" , budget_2 = "";
    double cash_1 , cash_2;


    //--------------------------------------METHODS-----------------------------------------

    public void _lotteryPage(){

        navigation.click();
        BrowserUtils.sleep(1);

        lotteryButton.click();
        BrowserUtils.sleep(1);
    }

    public void secim(){

        List<WebElement> tickets = Driver.getDriver().findElements(By.xpath("//div[@class = 'lottery-ticket__inner']"));
        toplam_ticket = tickets.size();

        List<WebElement> lotterys = Driver.getDriver().findElements(By.xpath("//div[@class = 'lottery-ticket__number']"));
        for (int i = 0; i < toplam_ticket; i++) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int j = 0 ; j < 7 ; j++ ){

                if (!(numbers.contains(randomNum.nextInt(49) + 50 * i + 1))){
                    numbers.add(randomNum.nextInt(49) + 50 * i + 1);
                    lotterys.get(numbers.get(j)).click();
                }
            }

            System.out.println("numbers = " + numbers);
        }
        BrowserUtils.sleep(1);


    }

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

    public void satin_alma(){

        String_to_Double_1();

        buyTicketsButton.click();
        BrowserUtils.sleep(1);

        String_to_Double_2();

    }

    public void check(){

        if (cash_2 < cash_1) {

            System.out.println("ilk bakiye : " + cash_1 + "--" + "guncel bakiye : " + cash_2 );
            System.out.println("BİLET SATIN ALINMISTIR");
            ;
        }
        else
            System.out.println("SATIN ALINMAMISTIR");
    }

    public void add_ticket(){

        addAnotherTicketButton.click();
        BrowserUtils.sleep(1);

    }

    public void delete_ticket(){

        deleteButton.click();

        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();

        BrowserUtils.sleep(1);


    }

    public void lottery_satin_alma(){

        String_to_Double_1();

        Select select = new Select(draws);
        select.selectByIndex(3);
        buyTicketsButton.click();
        BrowserUtils.sleep(5);

        String_to_Double_2();

    }


}




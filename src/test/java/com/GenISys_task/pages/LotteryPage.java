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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryPage {

    public LotteryPage(){

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

    CasinoGamePage casinoGamePage = new CasinoGamePage();

    Random randomNum = new Random();
    int toplam_ticket;
    String temprory_budget_1 , temprory_budget_2;
    String budget_1 ="" , budget_2 = "";
    double value1, value2 , cash_1 , cash_2;


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
            int k = 0;
            for (int j = 0 ; j < 7 ; j++ ){
                int value = randomNum.nextInt(50);

                if (!(numbers.contains(value + (50 * i)))){
                    numbers.add( value + (50 * i));
                    int a = numbers.get(k++);
                    lotterys.get(a).click();
                }else {
                    j--;
                }
            }

        }
        BrowserUtils.sleep(2);
    }

    public void check(){

        if (value2 < value1 ) {

            System.out.println("ilk bakiye : " + value1 + "--" + "guncel bakiye : " + value2 );
            System.out.println("BİLET SATIN ALINMISTIR");
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

        value1 = casinoGamePage.String_t0_Double1();

        Select select = new Select(draws);
        select.selectByIndex(3);
        buyTicketsButton.click();
        BrowserUtils.sleep(5);

        value2 = casinoGamePage.String_to_Double2();

    }

}




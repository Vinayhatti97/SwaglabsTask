package com.Ml.Testsaucelabs;

import com.Ml.BaseSaucelabs.Baseclass;
import com.Ml.Saucelabspages.SwaglabsHomepage;
import com.Ml.Saucelabspages.Swaglabscartpage;
import com.Ml.Saucelabspages.Swaglabscheckoutoverviewpage;
import com.Ml.Saucelabspages.SwagslabloginPage;
import com.Readfromfile.Readfromjson;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testit extends Baseclass {


    SwagslabloginPage swagslabloginPage;
    SwaglabsHomepage swaglabsHomepage;
    Swaglabscartpage swaglabscartpage;
    Swaglabscheckoutoverviewpage swaglabscheckoutoverviewpage;
    Readfromjson readfromjson;
    @BeforeClass
    public void initializePages(){
        readfromjson = new Readfromjson();
        swaglabsHomepage = new SwaglabsHomepage(driver);
        swagslabloginPage=new SwagslabloginPage(driver);
        swaglabscartpage = new Swaglabscartpage(driver);
        swaglabscheckoutoverviewpage = new Swaglabscheckoutoverviewpage(driver);
    }


    @Test
    public void launchApp(){
        driver.get("https://www.saucedemo.com/");
    }

    @Parameters({"username","password"})
    @Test
    public void verifyproductTitle(String username, String password){
        swagslabloginPage.loginSwaglabs(username, password);
        WebElement productstitle = driver.findElement(By.xpath("//span[.='Products']"));
        Assert.assertTrue(productstitle.isDisplayed());
        String name = productstitle.getText();
        System.out.println("Title of home page: "+productstitle);
        Assert.assertEquals(name, "PRODUCTS");
    }
    @Parameters({"username","password"})
    @Test
    public  void verifyLowestPrice(String username, String password){
     swagslabloginPage.loginSwaglabs(username, password);
     String priceinhomepage =String.valueOf(swaglabsHomepage.getlowestprice());
        System.out.println("Item price in home page: "+ priceinhomepage);
     swaglabsHomepage.addtoCartAndNavigatetoCart(String.valueOf(swaglabsHomepage.getlowestprice()));
     String priceincart = driver.findElement(By.xpath("//div[@ class='inventory_item_price']")).getText();
     String withoutdollarpriceincart =priceincart.replace("$","");
        System.out.println("Item price in Cart: "+withoutdollarpriceincart);
     Assert.assertEquals(priceinhomepage,withoutdollarpriceincart);
    }

    @Parameters({"username","password",})
    @Test
    public void Verifycheckoutreviewandthankyoumessage(String username, String password) throws IOException, ParseException {
        swagslabloginPage.loginSwaglabs(username, password);
        String price =String.valueOf(swaglabsHomepage.getlowestprice());
        String itemnameinhomepage = driver.findElement(By.xpath("//div[@ class='pricebar']/div[contains(.,'"+price+"')]/following-sibling::button/parent::div/preceding-sibling::div/a/div")).getText();
        System.out.println("Item name in home page: " + itemnameinhomepage);
        swaglabsHomepage.addtoCartAndNavigatetoCart(String.valueOf(swaglabsHomepage.getlowestprice()));
        swaglabscartpage.checkoutfromcartandContinue(readfromjson.readFile("firstname"),readfromjson.readFile("lastname"),readfromjson.readFile("zipcode"));
        String itemnameincheckout = driver.findElement(By.xpath("//div[@ class='inventory_item_name']")).getText();
        System.out.println("Item name in checkout page: "+itemnameincheckout);
        Assert.assertEquals(itemnameinhomepage,itemnameincheckout);
        swaglabscheckoutoverviewpage.clickonfinish();
        WebElement thankyoumessage = driver.findElement(By.xpath("//h2[@ class='complete-header']"));
        Assert.assertTrue(thankyoumessage.isDisplayed());
    }
}


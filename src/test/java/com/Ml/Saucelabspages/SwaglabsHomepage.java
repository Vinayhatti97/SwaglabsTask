package com.Ml.Saucelabspages;

import com.Actions.SeleniumActions;
import com.Ml.Testsaucelabs.Testit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwaglabsHomepage {
    WebDriver driver;

    SeleniumActions seleniumActions;
    public SwaglabsHomepage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(xpath = "//div[@ id='shopping_cart_container']/a")
    WebElement viewcartbutton;




    public float getlowestprice(){
        List<WebElement> listofprices =driver.findElements(By.xpath("//div[@ class='inventory_item']/div/div[2]/div"));
        List<Float> allprices = new ArrayList<>();

        for(WebElement element : listofprices){
            allprices.add(Float.parseFloat(element.getText().replace("$","")));
        }
        Float lowestprice = Collections.min(allprices);
        return lowestprice;
    }

    public void addtoCartAndNavigatetoCart(String price){
    WebElement addtocartbutton = driver.findElement(By.xpath("//div[@ class='pricebar']/div[contains(.,'"+price+"')]/following-sibling::button"));
    seleniumActions.clickOnElement(addtocartbutton);
    seleniumActions.clickOnElement(viewcartbutton);
    }


}

package com.Ml.Saucelabspages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swaglabscartpage {

    WebDriver driver;
    SeleniumActions seleniumActions;

    public Swaglabscartpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
    }


    @FindBy(id = "checkout")
    WebElement checkoutbutton;

    @FindBy(id = "first-name")
    WebElement firstNametextfield;

    @FindBy(id = "last-name")
    WebElement lastnametextfield;

    @FindBy(id = "postal-code")
    WebElement postacodtextfield;

    @FindBy(id = "continue")
    WebElement continuebutton;


    public void checkoutfromcartandContinue(String firstname, String lastname, String zipcode) {
        seleniumActions.clickOnElement(checkoutbutton);
        seleniumActions.EnterValueOnTextfield(firstNametextfield, firstname);
        seleniumActions.EnterValueOnTextfield(lastnametextfield, lastname);
        seleniumActions.EnterValueOnTextfield(postacodtextfield, zipcode);
        seleniumActions.clickOnElement(continuebutton);
    }
}
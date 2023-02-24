package com.Ml.Saucelabspages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagslabloginPage {

    WebDriver driver;
    SeleniumActions seleniumActions;
    public SwagslabloginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver= driver;
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(id = "user-name")
    WebElement usernametextfiled;

    @FindBy(id = "password")
    WebElement passwordtextfield;

    @FindBy(id = "login-button")
    WebElement loginbutton;


    public void loginSwaglabs(String username, String password){
        seleniumActions.EnterValueOnTextfield(usernametextfiled,username);
        seleniumActions.EnterValueOnTextfield(passwordtextfield, password);
        seleniumActions.clickOnElement(loginbutton);
    }
}

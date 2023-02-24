package com.Ml.Saucelabspages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swaglabscheckoutoverviewpage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    public Swaglabscheckoutoverviewpage(WebDriver driver){
        seleniumActions = new SeleniumActions(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "finish")
    WebElement finishbutton;

    public void clickonfinish(){
        seleniumActions.clickOnElement(finishbutton);
    }
}

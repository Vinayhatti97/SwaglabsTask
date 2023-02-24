package com.Actions;

import com.waits.SeleniumWaits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;

    public SeleniumActions(WebDriver driver) {
        this.driver= driver;
        seleniumWaits = new SeleniumWaits(driver);
    }

    public boolean clickOnElement(WebElement element) {
        boolean flag = false;

        try {
            element.click();
            flag = true;
        }
        catch(NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        }
        catch (StaleElementReferenceException ser) {
            // TODO: handle exception
            System.out.println(ser.toString());
            flag = false;
        }
        catch (ElementNotInteractableException eni) {
            // TODO: handle exception
            System.out.println(eni.toString());
            flag = false;
        }
        return flag;
    }

    public boolean EnterValueOnTextfield(WebElement element , String value) {

        boolean flag = true;

        try {
            element.sendKeys(value);
        }
        catch (NoSuchElementException nse) {
            // TODO: handle exception
            System.out.println(nse.toString());
            flag = false;
        }
        catch (StaleElementReferenceException Ser) {
            // TODO: handle exception
            System.out.println(Ser.toString());
            flag = false;
        }
        catch (ElementNotInteractableException eni) {
            // TODO: handle exception
            System.out.println(eni.toString());
            flag = false;
        }
        return flag;

    }

    public boolean WaitandClickElement(WebElement element) {
        try {
            seleniumWaits.waitForElementTobeClickable(element).click();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean selectValueFromDropDown(WebElement element, String data, String typeSelect) {
        try {
            Select select = new Select(element);
            switch (typeSelect) {
                case "index":
                    select.selectByIndex(Integer.parseInt(data));
                    break;
                case "value":
                    select.selectByValue(data);
                    break;
                case "text":
                    select.selectByVisibleText(data);
                    break;
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }
        public void javaScriptExcecutorClick(WebElement element, WebDriver driver){
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("argument[0].click();", element);
        }

    }


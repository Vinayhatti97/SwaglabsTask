package com.waits;

import com.CONSTANTS.TIMEWAITS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {

    WebDriver driver;
    WebDriverWait webdriverwait;
    public SeleniumWaits(WebDriver driver) {
        this.driver = driver;
        webdriverwait = new WebDriverWait(driver, Duration.ofSeconds(TIMEWAITS.EXPlICITE));
    }

    public WebElement waitForElementTobeClickable(WebElement element) {
        return webdriverwait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

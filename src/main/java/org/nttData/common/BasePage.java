package org.nttData.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected WebDriverWait getWebDriverWait(long timeOut){
        return new WebDriverWait(this.driver, Duration.ofSeconds(timeOut), Duration.ofMillis(500));
    }

    protected WebElement element(By by){
        return this.driver.findElement(by);
    }

}

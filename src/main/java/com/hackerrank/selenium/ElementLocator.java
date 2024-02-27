package com.hackerrank.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementLocator {

    public static List<WebElement> locateNonTextTypeElements(WebDriver driver, String pageUrl) {
        driver.navigate().to(pageUrl);
        List<WebElement> listOfTypeElm = new ArrayList<>();
        for (WebElement typeElm: driver.findElements(By.tagName("input"))) {
            if (!typeElm.getAttribute("Type").equals("text")){
                listOfTypeElm.add(typeElm);
            }
        }
        return listOfTypeElm;
    }

    public static List<WebElement> locateContactElements(WebDriver driver, String pageUrl) {
        List<WebElement> contactElms = new ArrayList<>();
        driver.navigate().to(pageUrl);
        for (WebElement elm : driver.findElements(By.tagName("input"))) {
            if (elm.getAttribute("name").contains("contact")){
                contactElms.add(elm);
            }
        }
        return contactElms;
    }

    public static WebElement findSubmitElement(WebDriver driver, String pageUrl) {
        driver.navigate().to(pageUrl);
        return driver.findElement(By.xpath("//button[.='Send']"));
    }

    public static List<WebElement> locateIdMissingElements(WebDriver driver, String pageUrl) {
        driver.navigate().to(pageUrl);
        List<WebElement> idMissingElms = new ArrayList<>();
        for (WebElement elm : driver.findElements(By.tagName("input"))){
            try{
                if (!elm.getAttribute("id").equals(null)){

                }
            }catch (NullPointerException e){
                idMissingElms.add(elm);
            }

        }

        return idMissingElms;
    }
}
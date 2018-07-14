package com.zucchini.framework.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    
    protected WebDriver driver;
    
    protected AbstractPage(WebDriver driver){
        this.driver = driver;
    }
    
    public static <P extends AbstractPage> P createPage(WebDriver driver, Class clazz){
        P page = (P) PageFactory.initElements(driver, clazz);
        return page;
    }
    
    public static <P extends AbstractPage> P goToPage(WebDriver driver, Class clazz, String url){
        driver.get(url);
        return createPage(driver, clazz);
    }
}
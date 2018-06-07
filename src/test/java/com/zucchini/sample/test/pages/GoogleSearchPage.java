package com.zucchini.sample.test.pages;

import com.zucchini.framework.ui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author humanswissarmyknife
 */
public class GoogleSearchPage extends AbstractPage {
    
    public static final String URL = "https://www.google.ca";
    
    @FindBy(css="input#lst-ib")
    protected WebElement searchBox;
    
    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }
    
    public static GoogleSearchPage go(WebDriver driver){
        return goToPage(driver, GoogleSearchPage.class, URL);
    }
    
    public GoogleSearchPage search(String searchString){
        searchBox.sendKeys(searchString + Keys.ENTER);
        return createPage(driver, GoogleSearchPage.class);
    }
}

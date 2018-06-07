package com.zucchini.sample.test.pages;

import com.zucchini.framework.ui.AbstractPage;
import org.openqa.selenium.WebDriver;

/**
 * @author humanswissarmyknife
 */
public class GoogleSearchPage extends AbstractPage {
    
    public static final String URL = "https://www.google.ca";
    
    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }
    
    public static GoogleSearchPage go(WebDriver driver){
        return goToPage(driver, GoogleSearchPage.class, URL);
    }
}

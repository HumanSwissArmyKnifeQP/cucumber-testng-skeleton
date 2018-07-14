package com.zucchini.sample.test.stepdefs;

import com.zucchini.framework.test.AbstractZucchiniGlue;
import com.zucchini.sample.test.pages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;

/**
 * TODO: Complete sample step definitions
 */
public class BrowserStepdefs extends AbstractZucchiniGlue {
    
    private GoogleSearchPage googlePage;
    
    private WebDriver driver;
    
    public BrowserStepdefs() {
        
        super();
        
        Given("^I am on the Google Search page", ()->{
            driver = getDriver();
            googlePage = GoogleSearchPage.go(driver);
        });
        
        And("^I search for (.*)$", (String s)->{
            googlePage.search(s);
        });
        
        Then("^we pass", ()->{
            
        });
    }
}

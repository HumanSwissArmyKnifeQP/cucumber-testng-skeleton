package com.zucchini.sample.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/features/browser_test_1.feature",
        tags = "@browser")
public class RunCukesTest2 extends AbstractTestNGCucumberTests {
    
}
package com.zucchini.sample.test;

import com.zucchini.framework.test.AbstractZucchiniTest;
import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/features/browser_test.feature",
        tags = "@browser")
public class RunCukesTest extends AbstractZucchiniTest {
    
}
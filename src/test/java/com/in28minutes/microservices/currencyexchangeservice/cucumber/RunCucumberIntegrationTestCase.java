package com.in28minutes.microservices.currencyexchangeservice.cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    monochrome = true,
    features = "src/test/resources",
    glue = "com.in28minutes.microservices.currencyexchangeservice.cucumber",
    plugin = { "pretty", "json:target/cucumber-report.json", "html:target/cucumber-html-reports" }
)
public class RunCucumberIntegrationTestCase {
}

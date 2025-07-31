package com.in28minutes.microservices.currencyexchangeservice.cucumber;

import io.cucumber.spring.CucumberContextConfiguration; 
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import com.in28minutes.microservices.currencyexchangeservice.CurrencyExchangeServiceApplicationH2;
import io.cucumber.java.Before;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CurrencyExchangeServiceApplicationH2.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {

  @Before
  public void setUp() {
  }
}

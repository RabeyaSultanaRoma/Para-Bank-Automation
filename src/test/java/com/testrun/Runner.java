package com.testrun;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"json:target/cucumber.json"}, //generate report = cucumber maven project
		features = {"./src/main/resources/ParabankLogin.feature"}, //feature file location or path
		glue = {"com.generic"}, //step def package name
		tags = {"@Smoke","@Positive"}, //which scenario = pos/neg or which test type to run
		dryRun = false, //check feature file correct or not
		strict = true, //step def automation code correct or not
		monochrome = true //remove all? mark and make easy to read console
		)
public class Runner extends AbstractTestNGCucumberTests{
	//cucumber hook
	@Before
	public void setup() {
		
	}
	@BeforeTest
	public void setup2() {
		
	}
	@Test
	public void setup3() {
		
	}
	@AfterTest
	public void setup4() {
		
	}
}

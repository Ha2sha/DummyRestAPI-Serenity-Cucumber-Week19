package com.restapiexample;

import com.restapiexample.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/featurefile",
            tags = "@employees")
public class EmployeeRunner extends TestBase {
}

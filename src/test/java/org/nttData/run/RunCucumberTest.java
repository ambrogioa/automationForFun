package org.nttData.run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org/nttData/listeners", "org/nttData/stepDefinition"},
        //tags = "@login", //Vedere come passarlo come parametro estero
        plugin = { "pretty", "json:target/cucumber/report.json", "html:target/cucumber/report.html"},
        monochrome = true
)

public class RunCucumberTest {
}

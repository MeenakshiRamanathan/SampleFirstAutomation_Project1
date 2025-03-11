package stepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/resources", // Path to the feature files
    glue = "stepDefinition", // Path to the step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"} // Reporting plugins
)
public class runner extends AbstractTestNGCucumberTests {
}



package stepDefinition_java8.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinition_java8",
        plugin = {
                "pretty",
                "html:target/cucumber",
        }
)
public class RunCukeTests {
}

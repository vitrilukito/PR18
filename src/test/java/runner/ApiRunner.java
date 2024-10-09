package runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepDef"},
        features = {"src/resources/feature"},
        tags = "@api",
        monochrome = true
)

public class ApiRunner {
}

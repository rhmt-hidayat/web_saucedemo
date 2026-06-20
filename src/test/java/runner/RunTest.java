package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDef",
//      tags = "@Test1 or @Test2",
//      tags = "@TDD",
        tags = "@Register",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        }
)

public class RunTest {
    
}

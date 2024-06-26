package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features/api",
        glue = {"stepDefinitions/api"},

        //glue = {"ApiStepdefinitions", "hooks/api"},



        tags = "@API",

        dryRun = true
)

public class ApiRunner {


}


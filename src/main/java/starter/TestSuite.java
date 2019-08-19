package starter;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * Test suite runner class
 * @author Harisha.P
 * @link https://github.com/serenity-bdd/serenity-cucumber4
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"classpath:features"}, 
        tags = {"not @ignore"},
        glue = {"_stepDefinitions"},
        dryRun = true
)
public class TestSuite {
}

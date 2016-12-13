package qa.works.contact;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/html.report", "json:target/json.report"}, tags = {"@contact"}, features = "src/test/resources/features")
public class CucumberRunner {
}

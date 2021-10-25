package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(glue = "src/test/java/StepDefinitions", features = "src/test/resources/Features" ,
monochrome=true, plugin = {
		"pretty", "html:target/Htmlreports/report.html",
		"json:target/JSONReports/report.json",
		"junit:target/JUnitReports/report.xml"
}, dryRun = false)
public class TestRunner {

}
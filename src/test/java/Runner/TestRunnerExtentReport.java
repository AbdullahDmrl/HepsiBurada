package Runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinations"},

        plugin = { //basit rapor oluşturan plugin
                "html:target/cucumber-report",
                "json:target/cucumber.json",
        }
)
public class TestRunnerExtentReport extends AbstractTestNGCucumberTests {


}

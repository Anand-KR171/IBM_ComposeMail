package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources\\Compose_Mail\\Compose_Mail.feature"},
glue= {"stepDefiniation"},
monochrome=true, 
dryRun=false,
strict=true,
plugin = {"html:testoutput/myReport.html","junit:testoutput/myReport_junit.xml","json:testoutput/myReport_json.json"})
public class Test_Runner {

}

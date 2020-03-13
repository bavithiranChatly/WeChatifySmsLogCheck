package automation.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src\\test\\resources\\features\\smsSFLog.featue" }, glue = { "automation.steps" }
,tags = {"@auto"}
)

public class SMSsflogRunner {

}

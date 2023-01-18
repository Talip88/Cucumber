package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest", // hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        //plugin= {"html:target/site/cucumber-pretty.html"}
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"} // JENKINS ICIN PLUG IN
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}

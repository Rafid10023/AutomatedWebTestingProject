package com.sparta.webtests.runner;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.sparta.webtests.steps",
//        tags = "@Happy",
        plugin = {
                "pretty",
                "html:target/testReport.html",
                "json:target/testReport.json"

        },
        publish = true
)
public class CucumberRunnerTest {
}

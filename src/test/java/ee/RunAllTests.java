package ee;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import ee.driver.WebDriverConfig;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "ee.steps",
        tags = "@Smoke"
)
public class RunAllTests {

    @AfterClass
    public static void teardown() {
        WebDriverConfig.getDriver().quit();
    }
}

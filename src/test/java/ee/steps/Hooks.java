package ee.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import ee.driver.WebDriverConfig;

public class Hooks {

    @Before
    public void setUp() {
        WebDriverConfig.getDriver().navigate().to("http://hotel-test.equalexperts.io/");
    }

    @After
    public void tearDown() {
        WebDriverConfig.getDriver().quit();
    }
}

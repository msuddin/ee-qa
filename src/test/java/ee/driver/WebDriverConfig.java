package ee.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {

    private WebDriver webDriver;
    private static WebDriverConfig webDriverConfig;
    private WebDriverConfig() {}

    private static WebDriverConfig getDriverConfig() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
            webDriverConfig.setProperties();
            webDriverConfig.initialiseDriver();
        }
        return webDriverConfig;
    }

    private void setProperties() {
        String osName = System.getProperty("os.name");
        String chromeDriverType;

        if (osName.toLowerCase().contains("windows")) {
            chromeDriverType = "src/test/resources/chromedriver.exe";
        } else {
            chromeDriverType = "src/test/resources/chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverType);
    }

    private void initialiseDriver() {
        webDriver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return getDriverConfig().webDriver;
    }

}

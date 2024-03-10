package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {
    WebDriver driver;
    Logger log = LogManager.getLogger(TestBase.class.getName());




    //
    @Parameters({"useCloudEnv", "envName", "os", "osVersion", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(String useCloudEnv, String envName, String os, String osVersion, String browserName, String browserVersion, String url) throws MalformedURLException {
        switch (useCloudEnv.toLowerCase()) {
            case "true":
                getCloudDriver(envName, os, osVersion, browserName, browserVersion, "browserstackUsername", "browserstackPassword");
                break;
            case "false":
                getLocalDriver(browserName);
                break;
            default:
                throw new IllegalArgumentException("Invalid useCloudEnv value: " + useCloudEnv);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }


    //Tear Down

    @AfterMethod
    public void tearDown() {
        //close browser
        driver.quit();
        log.info("browser close success");
    }


    //Local Driver Initialization
    public void getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
              log.info("chrome browser opened successfully");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
              log.info("firefox browser opened successfully");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
              log.info("edge browser opened successfully");
        }
    }


    // Cloud Driver Initialization
    public void getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_Version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_Version", browserVersion);

        if (envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@hub-cloud.browserstack.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@ondemand.saucelabs.com:80/wd.hub"), cap);
        }

    }
}

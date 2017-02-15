package general.utils;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Driver {

    private static Driver instance = null;
    private final String driverType = PropertyLoader.loadProperty("driverType");
    private final String driverMode = PropertyLoader.loadProperty("driverMode");
    private final String hubAddress = PropertyLoader.loadProperty("hubAddress");
    private final String driverIncognito = PropertyLoader.loadProperty("driverIncognito");
    private final long driverImplicitWait = Long.parseLong(PropertyLoader.loadProperty("driverImplicitWait"));
    private final String isAngularApp = PropertyLoader.loadProperty("isAngularApp");
    private final String chromeDriverPath = PropertyLoader.loadProperty("chromeDriverPath");
    private WebDriver currentDriver;
    private NgWebDriver ngWebDriver;

    private Driver() {
    }

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
            instance.setDriverParameters();
        }
        return instance;
    }

    private void setDriverParameters() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.SEVERE);

        DesiredCapabilities capabilities;

        switch (driverType) {
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                if ("true".equals(driverIncognito)) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("-incognito");
                    options.addArguments("--start-maximized");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                }
                break;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                if ("true".equals(driverIncognito)) {
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("browser.private.browsing.autostart", true);
                    capabilities.setCapability(FirefoxDriver.PROFILE, profile);
                }
                break;
            default:
                capabilities = DesiredCapabilities.chrome();
                break;
        }
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        if (driverMode.equals("remote")) {
            currentDriver = WebDriverPool.DEFAULT.getDriver(hubAddress, capabilities);
        } else {
            currentDriver = WebDriverPool.DEFAULT.getDriver(capabilities);
        }

        if ("true".equals(isAngularApp)) {
            ngWebDriver = new NgWebDriver((JavascriptExecutor) WebDriverPool.DEFAULT.getDriver(capabilities));
            EventFiringWebDriver eDriver = new EventFiringWebDriver(currentDriver);
            WebDriverEventListenerForAngular webDriverEventListenerForAngular = new WebDriverEventListenerForAngular();
            eDriver.register(webDriverEventListenerForAngular);
            currentDriver = eDriver;
        }
        currentDriver.manage().timeouts().implicitlyWait(driverImplicitWait, TimeUnit.SECONDS);

    }

    public WebDriver getDriver() {
        return currentDriver;
    }

    public void waitForAngular() {
        ngWebDriver.waitForAngularRequestsToFinish();
    }
}

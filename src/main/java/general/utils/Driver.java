package general.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver instance = null;
    DesiredCapabilities capabilities;
    private String driverType = PropertyLoader.loadProperty("driverType");
    private String driverIncognito = PropertyLoader.loadProperty("driverIncognito");
    private long driverImplicitWait = Long.parseLong(PropertyLoader.loadProperty("driverImplicitWait"));
    private String chromeDriverPath = PropertyLoader.loadProperty("chromeDriverPath");

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
        WebDriverPool.DEFAULT.getDriver(capabilities).manage().timeouts().implicitlyWait(driverImplicitWait, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return WebDriverPool.DEFAULT.getDriver(capabilities);
    }
}

package google.search.test.general;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.selenium.factory.WebDriverFactory;

public abstract class BaseTest {

    Capabilities firefox = DesiredCapabilities.firefox();
    public WebDriver driver = WebDriverFactory.getDriver(firefox);

    @BeforeClass(alwaysRun = true)
    public void setUp() {
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
    }
}

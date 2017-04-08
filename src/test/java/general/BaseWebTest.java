package general;

import general.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public abstract class BaseWebTest {

    public static WebDriver driver = Driver.getInstance().getDriver();

    @AfterMethod
    public void afterMethod() {
        Driver.getInstance().getDriver().manage().deleteAllCookies();
    }

}

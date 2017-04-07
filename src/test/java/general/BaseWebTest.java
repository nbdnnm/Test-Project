package general;

import general.utils.Driver;
import org.testng.annotations.AfterMethod;

public abstract class BaseWebTest {


    @AfterMethod
    public void afterMethod() {
        Driver.getInstance().getDriver().manage().deleteAllCookies();
    }

}

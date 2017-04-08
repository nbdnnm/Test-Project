package miscellaneous.fuzzy;

import general.BaseWebTest;
import general.utils.Driver;
import general.utils.JSUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FuzzyTest extends BaseWebTest {

    private String gremlinsJS = "javascript:(function(){function callback(){gremlins.createHorde().unleash()} \n" +
            "var s=document.createElement(\"script\");\n" +
            "s.src=\"https://rawgithub.com/marmelab/gremlins.js/master/gremlins.min.js\";\n" +
            "if(s.addEventListener){s.addEventListener(\"load\",callback,false)}\n" +
            "else if(s.readyState){s.onreadystatechange=callback}document.body.appendChild(s);})()";

    @BeforeMethod
    public void setUp() {
        Driver.getInstance().getDriver().get("about:blank");
    }

    @Test(dataProvider = "urlsForGremlins", dataProviderClass = FuzzyDataProvider.class)
    public void fuzzyTest(String url) {
        driver.get("http://" + url);
        JSUtils.executeScript(gremlinsJS);

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        Driver.getInstance().printBrowserLogs();
    }

}

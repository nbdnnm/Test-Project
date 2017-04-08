package general.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSUtils {

    private static WebDriver driver = Driver.getInstance().getDriver();

    private JSUtils() {
    }

    public static void executeScript(String script) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(script);
    }
}

package angular.ui.pages;

import com.paulhammant.ngwebdriver.NgWebDriver;
import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.yandex.qatools.allure.annotations.Step;

public class TutorialPage extends BasePage {

    Capabilities firefox = DesiredCapabilities.firefox();
    private String angularTutorial = PropertyLoader.loadProperty("angular.tutorial");
    private NgWebDriver ngWebDriver;

    public TutorialPage() {
        super();
        url = angularTutorial;
        ngWebDriver = new NgWebDriver((JavascriptExecutor) WebDriverPool.DEFAULT.getDriver(firefox));
    }

    @Step
    public void step() {

    }

}

package google.search.general;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class BasePage {

    protected String url;
    protected WebDriver driver;

    Capabilities firefox = DesiredCapabilities.firefox();

    public BasePage() {
        this.driver = WebDriverFactory.getDriver(firefox);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);

    }

    //common method for all pages
    public BasePage openPage() {
        driver.get(url);
        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

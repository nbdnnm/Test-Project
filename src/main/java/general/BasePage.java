package general;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class BasePage {

    protected String url;

    Capabilities firefox = DesiredCapabilities.firefox();

    public BasePage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(WebDriverPool.DEFAULT.getDriver(firefox))), this);

    }

    //common method for all pages
    public BasePage openPage() {
        WebDriverPool.DEFAULT.getDriver(firefox).get(url);
        return this;
    }

}

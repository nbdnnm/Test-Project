package general;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class BasePage {

    protected String url;

    Capabilities chrome = DesiredCapabilities.chrome(); //.chrome();

    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(WebDriverPool.DEFAULT.getDriver(chrome))), this);

    }

    //common method for all pages
    @Step
    public BasePage openPage() {
        WebDriverPool.DEFAULT.getDriver(chrome).get(url);
        return this;
    }

}

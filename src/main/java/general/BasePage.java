package general;

import general.utils.Driver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.logging.Logger;

public abstract class BasePage {

    public static Logger logger = Logger.getLogger("PageLogger");

    protected String url;

    public BasePage() {
        PageFactory.initElements(new HtmlElementDecorator
                (new HtmlElementLocatorFactory(Driver.getInstance().getDriver())), this);
    }

    @Step
    public BasePage openPage() {
        Driver.getInstance().getDriver().get(url);
        return this;
    }

}

package google.ui.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class ResultBlock extends HtmlElement {

    @FindBy(xpath = ".//a")
    private Link resultLink;

    @FindBy(xpath = ".//cite")
    private TextBlock siteAddress;

    @FindBy(xpath = ".//span[@class='st']")
    private TextBlock resultSummary;


    public String getLink() {
        return resultLink.getReference();
    }

    public String getSiteAddress() {
        return siteAddress.getText();
    }

    public String getResultSummary() {
        return resultSummary.getText();
    }
}

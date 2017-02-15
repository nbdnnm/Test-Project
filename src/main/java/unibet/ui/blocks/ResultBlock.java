package unibet.ui.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class ResultBlock extends HtmlElement {

    @FindBy(xpath = ".//a")
    private Link resultHeader;

    @FindBy(xpath = ".//div[@class='gs-bidi-start-align gs-snippet']")
    private TextBlock resultSummary;

    @FindBy(xpath = ".//div[@class='gs-bidi-start-align gs-visibleUrl gs-visibleUrl-long']")
    private TextBlock bottomLink;


    public String getHeaderLinkText() {
        return resultHeader.getText();
    }

    public String getResultSummary() {
        return resultSummary.getText();
    }

    public String getBottomLink() {
        return bottomLink.getText();
    }
}

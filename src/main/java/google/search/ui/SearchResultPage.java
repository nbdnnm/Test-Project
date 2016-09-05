package google.search.ui;

import google.search.general.BasePage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.List;

//search page with results
public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//a")
    private List<Link> resultLink;

    @FindBy(xpath = "//cite")
    private List<TextBlock> siteAddress;

    @FindBy(xpath = "//span[@class='st']")
    private List<TextBlock> resultSummary;

    public SearchResultPage() {
        super();
    }

    public SearchResultPage clickResultLink(Integer linkNum) {
        resultLink.get(linkNum).click();
        return this;
    }

    public String getSiteAddress(Integer siteAddressNum) {
        return siteAddress.get(siteAddressNum).getText();
    }

    public String getResultSummary(Integer resultSummaryNum) {
        return resultSummary.get(resultSummaryNum).getText();
    }
}

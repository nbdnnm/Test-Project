package google.ui.pages;

import general.BaseWebPage;
import google.ui.blocks.SearchResultBlock;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultWebPage extends BaseWebPage {

    @FindBy(xpath = "//div[@class='rc']")
    private List<SearchResultBlock> searchResultBlock;

    public SearchResultWebPage() {
        super();
    }

    public SearchResultBlock getResultBlock(Integer num) {
        return searchResultBlock.get(num);
    }
}

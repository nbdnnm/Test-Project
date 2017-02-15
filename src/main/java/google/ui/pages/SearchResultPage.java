package google.ui.pages;

import general.BasePage;
import google.ui.blocks.SearchResultBlock;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='rc']")
    private List<SearchResultBlock> searchResultBlock;

    public SearchResultPage() {
        super();
    }

    public SearchResultBlock getResultBlock(Integer num) {
        return searchResultBlock.get(num);
    }
}

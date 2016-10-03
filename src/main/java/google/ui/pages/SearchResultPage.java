package google.ui.pages;

import general.BasePage;
import google.ui.blocks.ResultBlock;
import org.openqa.selenium.support.FindBy;

import java.util.List;

//search page with results
public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='rc']")
    private List<ResultBlock> resultBlock;

    public SearchResultPage() {
        super();
    }

    public ResultBlock getResultBlock(Integer num) {
        return resultBlock.get(num);
    }
}

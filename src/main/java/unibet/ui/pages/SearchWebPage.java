package unibet.ui.pages;

import general.BaseWebPage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import unibet.ui.blocks.ResultBlock;

import java.util.List;

public class SearchWebPage extends BaseWebPage {

    @FindBy(xpath = "//td[@class='gsc-table-cell-snippet-close']")
    public List<ResultBlock> resultBlocks;

    public SearchWebPage() {
        super();
        url = PropertyLoader.loadProperty("unibet.searchpage");
    }

}

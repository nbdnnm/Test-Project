package unibet.ui.pages;

import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import unibet.ui.blocks.ResultBlock;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//td[@class='gsc-table-cell-snippet-close']")
    public List<ResultBlock> resultBlocks;

    public SearchPage() {
        super();
        url = PropertyLoader.loadProperty("unibet.searchpage");
    }

}

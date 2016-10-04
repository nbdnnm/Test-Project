package debijenkorf.ui.pages;

import debijenkorf.ui.blocks.SearchResultBlock;
import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private String searchResultsPage = PropertyLoader.loadProperty("debijenkorf.search.results");

    @FindBy(xpath = "//li[@class='dbk-productlist--item']")
    private List<SearchResultBlock> results;

    public SearchResultsPage() {
        super();
        url = searchResultsPage;
    }

    @Step
    public ProductPage openResult(Integer resultNum) {
        return results.get(resultNum).openResult();
    }

}

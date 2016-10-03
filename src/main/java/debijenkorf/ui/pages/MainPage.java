package debijenkorf.ui.pages;

import debijenkorf.ui.blocks.SearchField;
import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends BasePage {

    private String debijenkorfMainPage = PropertyLoader.loadProperty("debijenkorf.main");

    @FindBy(xpath = "//section[@class='dbk-search hidden-xs hidden-sm']")
    private SearchField searchField;

    public MainPage() {
        super();
        url = debijenkorfMainPage;
    }

    @Step
    public SearchResultsPage searchProduct(String product) {
        searchField.searchItem(product);
        return new SearchResultsPage();
    }

}

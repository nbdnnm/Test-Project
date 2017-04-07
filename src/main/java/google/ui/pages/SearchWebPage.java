package google.ui.pages;

import general.BaseWebPage;
import general.utils.PropertyLoader;
import google.ui.blocks.SearchField;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;

public class SearchWebPage extends BaseWebPage {

    @FindBy(xpath = "//input[@id='lst-ib']")
    private SearchField searchField;

    @FindBy(id = "gb_70")
    private Button signInButton;

    public SearchWebPage() {
        super();
        url = PropertyLoader.loadProperty("google.search.page");
    }


    @Step
    public SearchWebPage inputSearch(String searchText) {
        searchField.input(searchText);
        return this;
    }

    @Step
    public SearchWebPage submitSearch() {
        searchField.submitSearch();
        return this;
    }

    @Step
    public SearchWebPage clearSearch() {
        searchField.clearSearch();
        return this;
    }

    @Step
    public SignInWebPage clickSignIn() {
        signInButton.click();
        return new SignInWebPage();
    }
}

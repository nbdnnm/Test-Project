package google.ui.pages;

import general.BasePage;
import general.utils.PropertyLoader;
import google.ui.blocks.SearchField;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@id='lst-ib']")
    private SearchField searchField;

    @FindBy(id = "gb_70")
    private Button signInButton;

    public SearchPage() {
        super();
        url = PropertyLoader.loadProperty("google.search.page");
    }


    @Step
    public SearchPage inputSearch(String searchText) {
        searchField.input(searchText);
        return this;
    }

    @Step
    public SearchPage submitSearch() {
        searchField.submitSearch();
        return this;
    }

    @Step
    public SearchPage clearSearch() {
        searchField.clearSearch();
        return this;
    }

    @Step
    public SignInPage clickSignIn() {
        signInButton.click();
        return new SignInPage();
    }
}

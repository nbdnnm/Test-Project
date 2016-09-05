package google.search.ui;

import google.search.general.BasePage;
import google.search.general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

//initial search page
public class SearchPage extends BasePage {

    private String searchPageAddress = PropertyLoader.loadProperty("search.page");

    @FindBy(xpath = "//input[@id='lst-ib']")
    private TextInput searchField;
    @FindBy(id = "gb_70")
    private Link signIn;

    public SearchPage() {
        super();
        url = searchPageAddress;
    }

    public SearchPage inputSearch(String searchText) {
        searchField.sendKeys(searchText);
        return this;
    }

    public SearchPage submitSearch() {
        searchField.submit();
        return this;
    }

    public SearchPage clearSearch() {
        searchField.clear();
        return this;
    }

    public SignInPage clickSignIn() {
        signIn.click();
        return new SignInPage();
    }
}

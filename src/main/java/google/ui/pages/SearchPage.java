package google.ui.pages;

import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@id='lst-ib']")
    private TextInput searchField;

    @FindBy(id = "gb_70")
    private Button signInButton;

    public SearchPage() {
        super();
        String searchPageAddress = PropertyLoader.loadProperty("google.search.page");
        url = searchPageAddress;
    }


    @Step
    public SearchPage inputSearch(String searchText) {
        searchField.sendKeys(searchText);
        return this;
    }

    @Step
    public SearchPage submitSearch() {
        searchField.submit();
        return this;
    }

    @Step
    public SearchPage clearSearch() {
        searchField.clear();
        return this;
    }

    @Step
    public SignInPage clickSignIn() {
        signInButton.click();
        return new SignInPage();
    }
}

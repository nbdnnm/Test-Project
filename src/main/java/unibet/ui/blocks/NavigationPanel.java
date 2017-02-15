package unibet.ui.blocks;

import general.utils.MouseActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import unibet.ui.pages.SearchPage;

public class NavigationPanel extends HtmlElement {

    @FindBy(xpath = ".//a[@data-target='#search']")
    private WebElement searchIcon;

    @FindBy(xpath = ".//div[@id='search']//input[@name='query']")
    private TextInput searchField;

    @FindBy(xpath = ".//div[@id='search']//input[@class='searchButton']")
    private Button searchButton;

    public NavigationPanel mouseOverSearchIcon() {
        MouseActions.getInstance().mouseOverElement(searchIcon);
        return this;
    }

    public SearchPage inputSearch(String searchString) {
        searchField.sendKeys(searchString);
        searchButton.click();
        return new SearchPage();
    }
}

package debijenkorf.ui.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SearchField extends HtmlElement {

    @FindBy(xpath = ".//input")
    private TextInput searchField;

    public SearchField searchItem(String searchWord) {
        searchField.sendKeys(searchWord);
        searchField.submit();
        return this;
    }

}
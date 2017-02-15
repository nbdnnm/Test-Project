package google.ui.blocks;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class SearchField extends HtmlElement {

    @Step
    public SearchField input(String searchText) {
        this.sendKeys(searchText);
        return this;
    }

    @Step
    public SearchField submitSearch() {
        this.submit();
        return this;
    }

    @Step
    public SearchField clearSearch() {
        this.clear();
        return this;
    }
}

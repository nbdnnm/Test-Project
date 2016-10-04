package debijenkorf.ui.blocks;

import debijenkorf.ui.pages.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

//block with product, appears after search

public class SearchResultBlock extends HtmlElement {

    @FindBy(xpath = ".//h2")
    private WebElement brandName;

    @FindBy(xpath = ".//p")
    private WebElement productName;

    public ProductPage openResult() {
        this.getWrappedElement().click();
        return new ProductPage();
    }

}

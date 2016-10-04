package debijenkorf.ui.pages;

import general.BasePage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Select;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//select[@class='dbk-form--input']")
    private Select productSelector;

    @FindBy(xpath = "//button[@class='Tappable-inactive dbk-btn dbk-btn_primary dbk-btn_justified']")
    private Button inCart;

    public ProductPage() {
        super();
    }

    @Step
    public ProductPage selectProductItemByValue(String itemValue) {
        productSelector.selectByVisibleText(itemValue);
        return this;
    }

    @Step
    public ProductPage addItemInCart() {
        inCart.click();
        return this;
    }


}
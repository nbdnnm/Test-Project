package debijenkorf.ui.pages;

import general.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CartPage extends BasePage {

    private static String ITEM_ARTICLE_PATH = "//p[@class='dbk-paragraph hidden-xs']";

    @FindBy(xpath = "//li[@class='dbk-productlist-item']")
    private List<WebElement> cartProductItems;

    public CartPage() {
        super();
    }

    @Step
    public boolean isArticleInCart(String itemArticle) {
        return cartProductItems.stream()
                .anyMatch(e -> e.findElement(By.xpath(ITEM_ARTICLE_PATH))
                        .getText().contains(itemArticle));
    }

    @Step
    public boolean isAnythingInCart() {
        return !cartProductItems.isEmpty();
    }
}

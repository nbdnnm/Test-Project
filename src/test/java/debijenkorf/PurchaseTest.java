package debijenkorf;

import debijenkorf.TestData.PurchaseTestData;
import debijenkorf.ui.pages.BasketPage;
import debijenkorf.ui.pages.MainPage;
import debijenkorf.ui.pages.ProductPage;
import general.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setUp() {
        mainPage.openPage();
    }

    @Test(dataProvider = "simplePurchase", dataProviderClass = PurchaseTestData.class)
    public void simplePurchase(String searchKeyword, Integer resultBlock, String itemToPurchase, String itemArticle) {
        //search by keyword and open particular result
        ProductPage productPage = mainPage
                .searchProduct(searchKeyword)
                .openResult(resultBlock);

        //choose item and add into basket
        BasketPage basketPage = productPage
                .selectProductItemByValue(itemToPurchase)
                .addItemInCart()
                .clickGoToCart();

        //check that item with particular article is in basket
        Assert.assertTrue(basketPage.isArticleInBasket(itemArticle));

    }


}

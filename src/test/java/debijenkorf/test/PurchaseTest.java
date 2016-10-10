package debijenkorf.test;

import debijenkorf.test.TestData.PurchaseTestData;
import debijenkorf.ui.pages.CartPage;
import debijenkorf.ui.pages.MainPage;
import general.AllureTestListener;
import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestListener.class)
public class PurchaseTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @BeforeMethod
    public void setUp() {
        mainPage.openPage();
    }

    @Test(dataProvider = "simplePurchase", dataProviderClass = PurchaseTestData.class)
    public void simplePurchase(String searchKeyword, Integer resultBlock, String itemToPurchase, String itemArticle) {
        cartPage = mainPage
                .searchProduct(searchKeyword)
                .openResult(resultBlock)
                .openProductList()
                .selectProductItemByValue(itemToPurchase)
                .addItemInCart()
                .clickGoToCart();
        Assert.assertTrue(cartPage.isArticleInCart(itemArticle));
    }

    @Test(dataProvider = "simplePurchase", dataProviderClass = PurchaseTestData.class)
    public void purchaseFirstItem(String searchKeyword, Integer resultBlock, String itemToPurchase, String itemArticle) {
        cartPage = mainPage
                .searchProduct(searchKeyword)
                .openResult(resultBlock)
                .openProductList()
                .selectFirstItem()
                .addItemInCart()
                .clickGoToCart();
        Assert.assertTrue(cartPage.isAnythingInCart());
    }
}

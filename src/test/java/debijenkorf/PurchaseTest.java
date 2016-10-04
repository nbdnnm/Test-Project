package debijenkorf;

import debijenkorf.TestData.PurchaseTestData;
import debijenkorf.ui.pages.MainPage;
import debijenkorf.ui.pages.ProductPage;
import general.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setUp() {
        mainPage.openPage();
    }

    @Test(dataProvider = "simplePurchase", dataProviderClass = PurchaseTestData.class)
    public void simplePurchase(String searchKeyword, Integer resultBlock, String itemToPurchase) {
        ProductPage productPage = mainPage
                .searchProduct(searchKeyword)
                .openResult(resultBlock);
        productPage
                .selectProductItemByValue(itemToPurchase)
                .addItemInCart();

    }


}

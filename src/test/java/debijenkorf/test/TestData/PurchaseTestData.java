package debijenkorf.test.TestData;

import org.testng.annotations.DataProvider;

public final class PurchaseTestData {

    private static final String SEARCH_KEYWORD = "jeans";
    private static final Integer RESULT_BLOCK = 1; // result block to open
    private static final String ITEM_TO_PURCHASE = "104"; // to add in cart
    private static final String ITEM_ARTICLE = "797704000688104";

    @DataProvider(name = "simplePurchase")
    public static Object[][] simplePurchase() {
        return new Object[][]{{SEARCH_KEYWORD, RESULT_BLOCK, ITEM_TO_PURCHASE, ITEM_ARTICLE}};
    }
}

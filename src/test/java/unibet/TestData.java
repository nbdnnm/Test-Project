package unibet;

import org.testng.annotations.DataProvider;

public final class TestData {

    private final static String SEARCH_ITEM = "Golf";
    private final static String SEARCH_BLOCK_TO_TEST = "0";

    @DataProvider(name = "searchTest")
    public static Object[][] searchTest() {
        return new Object[][]{{SEARCH_ITEM, SEARCH_BLOCK_TO_TEST}};
    }


}

package google.search.test.testData;

import org.testng.annotations.DataProvider;

public final class SearchTestData {

    private static final String SEARCH_STRING = "Selenium"; //keywords to search
    private static final Integer RESULT_BLOCK = 3; // result block to check

    @DataProvider(name = "searchString")
    public static Object[][] searchString() {
        return new Object[][]{{SEARCH_STRING, RESULT_BLOCK}};
    }
}

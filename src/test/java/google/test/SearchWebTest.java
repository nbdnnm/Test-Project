package google.test;

import general.AllureTestListener;
import general.BaseWebTest;
import google.test.testData.SearchTestData;
import google.ui.pages.SearchWebPage;
import google.ui.pages.SearchResultWebPage;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestListener.class)
public class SearchWebTest extends BaseWebTest {

    SearchWebPage searchPage = new SearchWebPage();

    @BeforeMethod()
    public void setUp() {
        searchPage.openPage();
    }

    @Test(dataProvider = "searchString", dataProviderClass = SearchTestData.class)
    public void searchTest(String searchString, Integer resultBlockNum) {
        searchPage.inputSearch(searchString).submitSearch();
        SearchResultWebPage searchResultPage = new SearchResultWebPage();
        Matchers.contains(searchResultPage
                .getResultBlock(resultBlockNum)
                .getResultSummary(), searchString);
    }

    @Test(enabled = false)
    public void openLoginPage() {
        searchPage.clickSignIn();
    }
}

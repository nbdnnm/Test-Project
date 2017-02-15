package google;

import general.AllureTestListener;
import general.BaseTest;
import google.testData.SearchTestData;
import google.ui.pages.SearchPage;
import google.ui.pages.SearchResultPage;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestListener.class)
public class TestSearch extends BaseTest {

    SearchPage searchPage = new SearchPage();

    @BeforeMethod()
    public void setUp() {
        searchPage.openPage();
    }

    @Test(dataProvider = "searchString", dataProviderClass = SearchTestData.class)
    public void searchTest(String searchString, Integer resultBlockNum) {
        searchPage.inputSearch(searchString).submitSearch();
        SearchResultPage searchResultPage = new SearchResultPage();
        Matchers.contains(searchResultPage
                .getResultBlock(resultBlockNum)
                .getResultSummary(), searchString);
    }

    @Test
    public void openLoginPage() {
        searchPage.clickSignIn();
    }
}

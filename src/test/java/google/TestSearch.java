package google;

import general.BaseTest;
import google.testData.SearchTestData;
import google.ui.pages.SearchPage;
import google.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        Assert.assertTrue(searchResultPage.getResultBlock(resultBlockNum).getResultSummary().contains(searchString));
    }

    @Test
    public void openLoginPage() {
        searchPage.clickSignIn();
    }
}

package google.search.test;

import google.search.test.general.BaseTest;
import google.search.test.testData.SearchTestData;
import google.search.ui.SearchPage;
import google.search.ui.SearchResultPage;
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
        Assert.assertTrue(searchResultPage
                .getResultSummary(resultBlockNum)
                .contains(searchString));
    }

    @Test
    public void openLoginPage() {
        searchPage.clickSignIn();
    }

}

package unibet;

import general.AllureTestListener;
import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import unibet.ui.pages.MainPage;
import unibet.ui.pages.SearchPage;

@Listeners(AllureTestListener.class)
public class SearchTest extends BaseTest {
    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();

    @BeforeMethod
    public void setUp() {
        mainPage.openPage();
    }

    @Test(dataProvider = "searchTest", dataProviderClass = TestData.class)
    public void searchTest(String searchItem, String resultBlockToTest) {
        searchPage = mainPage
                .navigationPanel
                .mouseOverSearchIcon()
                .inputSearch(searchItem);
        Assert.assertTrue(searchPage
                .resultBlocks
                .get(Integer.parseInt(resultBlockToTest))
                .getHeaderLinkText().toLowerCase()
                .contains(searchItem.toLowerCase()));
    }

}

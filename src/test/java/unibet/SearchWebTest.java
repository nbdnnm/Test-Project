package unibet;

import general.AllureTestListener;
import general.BaseWebTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import unibet.ui.pages.MainWebPage;
import unibet.ui.pages.SearchWebPage;

@Listeners(AllureTestListener.class)
public class SearchWebTest extends BaseWebTest {
    private MainWebPage mainPage = new MainWebPage();
    private SearchWebPage searchPage = new SearchWebPage();

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

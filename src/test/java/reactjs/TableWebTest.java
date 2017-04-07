package reactjs;

import general.AllureTestListener;
import general.BaseWebTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reactjs.ui.pages.ExampleWebPage;

@Listeners(AllureTestListener.class)
public class TableWebTest extends BaseWebTest {
    private ExampleWebPage examplePage = new ExampleWebPage();

    @BeforeMethod
    public void setUp() {
        examplePage.openPage();
    }

    @Test
    public void printTableTest() {
        examplePage.printTable();
    }

    @Test
    public void printCellValueByFirstName() {
        System.out.print(examplePage.getCellValueByFirstName(examplePage.takeFirstName(3),
                ExampleWebPage.Column.Zip_Code).get(0));
    }
}

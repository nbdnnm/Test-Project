package reactjs;

import general.AllureTestListener;
import general.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reactjs.ui.pages.ExamplePage;

@Listeners(AllureTestListener.class)
public class TableTest extends BaseTest {
    private ExamplePage examplePage = new ExamplePage();

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
                ExamplePage.Column.Zip_Code).get(0));
    }
}

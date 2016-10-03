package reactjs;

import general.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reactjs.ui.pages.ExamplePage;

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
        System.out.print(examplePage.getCellValueByFirstName(examplePage.takeOneOfFirstName(), "Zip Code"));
    }
}

package reactjs.ui.pages;

import general.BaseWebPage;
import general.utils.PropertyLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reactjs.ui.blocks.ReactJSTable;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ExampleWebPage extends BaseWebPage {

    @FindBy(xpath = "//div[@class='fixedDataTableLayout_main public_fixedDataTable_main']")
    private ReactJSTable table;

    public ExampleWebPage() {
        super();
        url = PropertyLoader.loadProperty("reactjs.page.json");
    }

    @Step
    public String takeFirstName(int lineNumber) {
        lineNumber--;
        return table.getColumnByIndex(Column.First_Name.getIndex()).get(lineNumber).getText();
    }

    public List<String> getCellValueByFirstName(String firstName, Column columnName) {
        List<String> results = new ArrayList<>();
        List<WebElement> targetColumn = table.getColumnByIndex(columnName.getIndex());
        List<WebElement> firstNameColumn = table.getColumnByIndex(Column.First_Name.getIndex());
        int tableSize = table.getRows().size();

        for (int i = 0; i < tableSize; i++) {
            if (firstName.equals(firstNameColumn.get(i).getText())) {
                results.add(targetColumn.get(i).getText());
            }
        }
        return results;
    }

    public ExampleWebPage printTable() {
        List<List<WebElement>> rows = table.getRows();
        for (List<WebElement> row : rows) {
            for (WebElement cell : row) {
                logger.log(Level.INFO, cell.getText() + "\t");
                //System.out.print(cell.getText() + "\t");
            }
            System.out.print("\n");
        }
        return this;
    }

    public enum Column {
        First_Name(1),
        Zip_Code(5);
        private final int index;

        Column(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public String getColumnName() {
            return this.name().replace("_", "");
        }

    }
}

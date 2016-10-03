package reactjs.ui.pages;

import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reactjs.ui.blocks.ReactJSTable;

import java.util.List;

public class ExamplePage extends BasePage {
    private String examplePageAddress = PropertyLoader.loadProperty("reactjs.page.json");

    @FindBy(xpath = "//div[@class='fixedDataTableLayout_main public_fixedDataTable_main']")
    private ReactJSTable table;

    public ExamplePage() {
        super();
        url = examplePageAddress;
    }

    public String takeOneOfFirstName() {
        return table.getColumnByIndex(1).get(3).getText();
    }

    public List<String> getCellValueByFirstName(String firstName, String columnName) {
        Integer firstNameColumnIndex = null;
        Integer columnNameIndex = null;
        List<WebElement> firstNameValues = null;
        List<WebElement> columnNameValues = null;
        List<Integer> rowIndexWithSufficientName = null;
        List<String> columnNameFromTable = table.getHeadingsAsString();
        List<String> results = null;

        //let's find the indexes of First name column  and the column from which we want to take value
        for (int i = 0; i < columnNameFromTable.size(); i++) {
            if (firstName.equals(columnNameFromTable)) {
                firstNameColumnIndex = i;
            } else if (columnName.equals(columnNameFromTable)) {
                columnNameIndex = i;
            }
        }

        //take indexes of rows where First name is equal to which we are looking for
        firstNameValues = table.getColumnByIndex(firstNameColumnIndex);
        for (int i = 0; i < firstNameValues.size(); i++) {
            if (firstName.equals(firstNameValues.get(i).getText())) {
                rowIndexWithSufficientName.add(Integer.valueOf(i));
            }
        }

        //take the column value from rows where First name what we are looking for
        for (int i = 0; i < rowIndexWithSufficientName.size(); i++) {
            results.add(columnNameValues.get(i).getText());
        }
        return results;
    }

    public ExamplePage printTable() {
        List<List<WebElement>> rows = table.getRows();
        for (List<WebElement> row : rows) {
            for (WebElement cell : row) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.print("\n");
        }
        return this;
    }

}

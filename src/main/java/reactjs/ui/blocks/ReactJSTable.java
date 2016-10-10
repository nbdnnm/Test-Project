package reactjs.ui.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.Table;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReactJSTable extends Table {


    public ReactJSTable(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public List<WebElement> getHeadings() {
        return this.getWrappedElement().findElements(By.xpath(".//div[contains(@class, 'public_fixedDataTable_header')]//div[contains(@class, 'public_fixedDataTableCell_main')]"));
    }

    @Override
    public List<List<WebElement>> getRows() {
        return this.getWrappedElement()
                .findElements(By.xpath(".//div[contains(@class, 'public_fixedDataTable_bodyRow')]"))
                .stream()
                .map(rowElement -> rowElement.findElements(By.xpath(".//div[contains(@class, 'public_fixedDataTableCell_main')]")))
                .filter(row -> row.size() > 0)
                .collect(toList());
    }

    //index start from first
    @Override
    public List<WebElement> getColumnByIndex(int index) {
        List<WebElement> columnCells = new ArrayList<>();
        for (List<WebElement> row : getRows()) {
            columnCells.add(row.get(index));
        }
        return columnCells;
    }

}

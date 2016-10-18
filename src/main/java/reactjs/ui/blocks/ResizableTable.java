package reactjs.ui.blocks;

import general.utils.MouseActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResizableTable extends ReactJSTable {

    @FindBy(xpath = "//div[@class='fixedDataTableCellLayout_columnResizerContainer']")
    public List<WebElement> columnResizer;

    public ResizableTable(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public ResizableTable moveColumnRight(Integer columnNumber, Integer pixels) {
        MouseActions.getInstance().moveElementLeft(columnResizer.get(columnNumber), pixels);
        return this;
    }


}

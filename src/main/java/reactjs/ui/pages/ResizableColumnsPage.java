package reactjs.ui.pages;

import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import reactjs.ui.blocks.ReactJSTable;

public class ResizableColumnsPage extends BasePage {

    private String resizableColumnsPageAddress = PropertyLoader.loadProperty("reactjs.page.resize.columns");

    @FindBy(xpath = "//div[@class='fixedDataTableLayout_main public_fixedDataTable_main']")
    private ReactJSTable table;

    public ResizableColumnsPage() {
        super();
        url = resizableColumnsPageAddress;
    }


}

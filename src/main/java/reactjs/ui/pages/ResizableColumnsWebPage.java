package reactjs.ui.pages;

import general.BaseWebPage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import reactjs.ui.blocks.ReactJSTable;

public class ResizableColumnsWebPage extends BaseWebPage {

    @FindBy(xpath = "//div[@class='fixedDataTableLayout_main public_fixedDataTable_main']")
    private ReactJSTable table;

    public ResizableColumnsWebPage() {
        super();
        String resizableColumnsPageAddress = PropertyLoader.loadProperty("reactjs.page.resize.columns");
        url = resizableColumnsPageAddress;
    }


}

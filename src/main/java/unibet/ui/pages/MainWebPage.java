package unibet.ui.pages;

import general.BaseWebPage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import unibet.ui.blocks.NavigationPanel;

public class MainWebPage extends BaseWebPage {


    @FindBy(xpath = "//div[@id='topnav']")
    public NavigationPanel navigationPanel;

    public MainWebPage() {
        super();
        url = PropertyLoader.loadProperty("unibet.mainpage");
    }

}

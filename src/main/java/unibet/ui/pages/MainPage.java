package unibet.ui.pages;

import general.BasePage;
import general.utils.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import unibet.ui.blocks.NavigationPanel;

public class MainPage extends BasePage {


    @FindBy(xpath = "//div[@id='topnav']")
    public NavigationPanel navigationPanel;

    public MainPage() {
        super();
        url = PropertyLoader.loadProperty("unibet.mainpage");
    }

}

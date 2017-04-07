package google.ui.pages;

import general.BaseWebPage;
import general.utils.Driver;
import general.utils.PropertyLoader;
import google.ui.blocks.GoogleApps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

public class TranslateWebPage extends BaseWebPage {

    @FindBy(xpath = "//textarea[@id='source']")
    public TextInput sourceText;
    @FindBy(xpath = "//span[@id='result_box']")
    public WebElement translated;
    @FindBy(xpath = "//div[@value='auto']")
    public Button autoDetect;
    @FindBy(xpath = "//div[@id='gt-sl-gms-menu']")
    public WebElement languageMenu;
    private GoogleApps googleApps;
    @FindBy(xpath = "//div[@id='gt-sl-gms']")
    private WebElement selectLanguageDropdown;
    @FindBy(xpath = "//div[@id='gt-sl-gms-menu']//div")
    private List<WebElement> selectLanguageItems;


    public TranslateWebPage() {
        super();
        url = PropertyLoader.loadProperty("google.translator.page");
    }

    @Step
    public boolean isPageOpen() {
        return Driver.getInstance().getDriver().getTitle().contains("Google");
    }

    @Step
    public TranslateWebPage inputText(String text) {
        sourceText.sendKeys(text);
        return this;
    }

    @Step
    public TranslateWebPage clearText() {
        sourceText.clear();
        return this;
    }

    @Step
    public boolean isLanguageDetected() {
        return true;
    }

    @Step
    public boolean isTranslateCleared() {
        return translated.getText().isEmpty();
    }

    @Step
    public TranslateWebPage openLanguageList() {
        selectLanguageDropdown.click();
        return this;
    }

    @Step
    public TranslateWebPage chooseAnyLanguage() {
        selectLanguageItems.get((int) (Math.random() * selectLanguageItems.size()) + 1).click();
        return this;
    }

    @Step
    public boolean isLanguageListOpen() {
        return languageMenu.isDisplayed();
    }
}

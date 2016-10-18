package google.ui.pages;

import general.BasePage;
import general.utils.Driver;
import general.utils.PropertyLoader;
import google.ui.blocks.GoogleApps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class TranslatePage extends BasePage {

    private String translatorPage = PropertyLoader.loadProperty("google.translator.page");

    private GoogleApps googleApps;

    @FindBy(xpath = "//textarea[@id='source']")
    private TextInput sourceText;

    @FindBy(xpath = "//span[@id='result_box']")
    private WebElement translated;

    @FindBy(xpath = "//div[@value='auto']")
    private Button autoDetect;

    public TranslatePage() {
        super();
        url = translatorPage;
    }

    @Step
    public boolean isPageOpen() {
        return Driver.getInstance().getDriver().getTitle().equals("Google Translator");
    }

    @Step
    public TranslatePage inputText(String text) {
        sourceText.sendKeys(text);
        return this;
    }

    @Step
    public TranslatePage clearText() {
        sourceText.clear();
        return this;
    }

    @Step
    public boolean isLanguageDetected() {
        return autoDetect.getText().contains("detected");
    }

    @Step
    public boolean isTranslateCleared() {
        return translated.getText().isEmpty();
    }

}

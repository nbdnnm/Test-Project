package google;

import google.testData.TranslatorTestData;
import google.ui.pages.TranslatePage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(time_duration(300))", start = "openBrowser")
public class TestTranslator extends ExecutionContext implements GoogleTranslator {

    TranslatePage translatePage;

    @Override
    public void openBrowser() {
        translatePage = new TranslatePage();
        translatePage.openPage();
    }

    @Override
    public void openPage() {
        translatePage.openPage();
    }

    @Override
    public void isPageOpened() {
        translatePage.isPageOpen();
    }

    @Override
    public void isTranslateCleared() {
        translatePage.isTranslateCleared();
    }

    @Override
    public void clearText() {
        translatePage.clearText();
    }

    @Override
    public void isLanguageDetected() {
        translatePage.isLanguageDetected();
    }

    @Override
    public void inputText() {
        translatePage.inputText(TranslatorTestData.textToTranslate);
    }
}

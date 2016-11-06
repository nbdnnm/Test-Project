package google;

import google.testData.TranslatorTestData;
import google.ui.pages.TranslatePage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.testng.Assert;
import org.testng.annotations.Test;

@GraphWalker(value = "random(edge_coverage(100))", start = "OpenBrowser")
public class TestTranslator extends ExecutionContext implements GoogleTranslator {

    TranslatePage translatePage;

    @Test
    @Override
    public void OpenBrowser() {
        translatePage = new TranslatePage();
        translatePage.openPage();
    }

    @Test
    @Override
    public void OpenPage() {
        translatePage.openPage();
    }

    @Test
    @Override
    public void LanguageListOpened() {

    }

    @Test
    @Override
    public void OpenLanguageList() {
        translatePage.openLanguageList();
    }

    @Test
    @Override
    public void PageOpened() {
        Assert.assertTrue(translatePage.isPageOpen());
    }

    @Test
    @Override
    public void TranslateCleared() {
        Assert.assertTrue(translatePage.isTranslateCleared());
    }

    @Test
    @Override
    public void ClearText() {
        translatePage.clearText();
    }

    @Test
    @Override
    public void LanguageDetected() {
        Assert.assertTrue(translatePage.isLanguageDetected());
    }

    @Test
    @Override
    public void InputText() {
        translatePage.inputText(TranslatorTestData.textToTranslate);
    }
}

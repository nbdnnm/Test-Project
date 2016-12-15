package google;

import google.testData.TranslatorTestData;
import google.ui.pages.TranslatePage;
import gwtests.BaseExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.testng.Assert;

@GraphWalker(value = "random(edge_coverage(100))", start = "OpenBrowser")
public class TestTranslator extends BaseExecutionContext implements GoogleTranslator {

    TranslatePage translatePage;

    @Override
    public void OpenBrowser() {
        translatePage = new TranslatePage();
        translatePage.openPage();
    }


    @Override
    public void OpenPage() {
        translatePage.openPage();
    }


    @Override
    public void LanguageListOpened() {

    }


    @Override
    public void OpenLanguageList() {
        translatePage.openLanguageList();
    }


    @Override
    public void PageOpened() {
        Assert.assertTrue(translatePage.isPageOpen());
    }


    @Override
    public void TranslateCleared() {
        Assert.assertTrue(translatePage.isTranslateCleared());
    }


    @Override
    public void ClearText() {
        translatePage.clearText();
    }


    @Override
    public void LanguageDetected() {
        Assert.assertTrue(translatePage.isLanguageDetected());
    }


    @Override
    public void InputText() {
        translatePage.inputText(TranslatorTestData.textToTranslate);
    }
}

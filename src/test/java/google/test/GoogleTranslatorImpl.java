package google.test;

import google.test.testData.TranslatorTestData;
import google.ui.pages.TranslateWebPage;
import googleRes.GoogleTranslator;
import gwtests.BaseExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.testng.Assert;

@GraphWalker(value = "random(edge_coverage(100))", start = "OpenBrowser")
public class GoogleTranslatorImpl extends BaseExecutionContext implements GoogleTranslator {

    TranslateWebPage translatePage;

    @Override
    public void OpenBrowser() {
        translatePage = new TranslateWebPage();
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

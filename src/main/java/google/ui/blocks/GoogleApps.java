package google.ui.blocks;

import google.ui.pages.TranslateWebPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

public class GoogleApps extends HtmlElement {

    @FindBy(xpath = ".//a[@id='gb192']")
    private Link myAccount;

    @FindBy(xpath = ".//a[@id='gb1']")
    private Link search;

    @FindBy(xpath = ".//a[@id='gb8']")
    private Link maps;

    @FindBy(xpath = ".//a[@id='gb36']")
    private Link youtube;

    @FindBy(xpath = ".//a[@id='gb78']")
    private Link play;

    @FindBy(xpath = ".//a[@id='gb23']")
    private Link gmail;

    @FindBy(xpath = ".//a[@id='gb49']")
    private Link drive;

    @FindBy(xpath = ".//a[@id='gb51']")
    private Link translate;


    public TranslateWebPage openTranslate() {
        translate.click();
        return new TranslateWebPage();
    }


}

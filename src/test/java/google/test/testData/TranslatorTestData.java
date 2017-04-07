package google.test.testData;

import org.testng.annotations.DataProvider;

public class TranslatorTestData {

    public static String textToTranslate = "translate";

    @DataProvider(name = "translatorInputText")
    public static Object[][] translate() {
        return new Object[][]{{"translate"}};
    }
}

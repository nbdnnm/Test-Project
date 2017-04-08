package miscellaneous.fuzzy;

import org.testng.annotations.DataProvider;

public class FuzzyDataProvider {

    @DataProvider(name = "urlsForGremlins")
    public static Object[][] urlsForGremlins() {
        return new Object[][]{{"bing.com"}, {"google.com"}};
    }
}

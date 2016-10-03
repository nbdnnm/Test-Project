package angular;

import angular.ui.pages.TutorialPage;
import general.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TutorialTest extends BaseTest {

    private TutorialPage tutorialPage = new TutorialPage();

    @BeforeMethod
    public void setUp() {
        tutorialPage.openPage();
    }

    @Test
    public void test() {

    }
}

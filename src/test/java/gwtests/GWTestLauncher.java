package gwtests;

import general.AllureTestListener;
import google.test.GoogleTranslatorImpl;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(AllureTestListener.class)
public class GWTestLauncher extends BaseGWTestLauncher {


    @Test
    public void launchLoginTest() throws IOException {
        executor = new TestExecutor(new LoginParametrizedImpl().getClass());
        Result result = executor.execute(true);
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
        checkTestResult();
    }

    @Test
    public void launchTranslatorTest() {
        executor = new TestExecutor(new GoogleTranslatorImpl().getClass());
        Result result = executor.execute();
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
        checkTestResult();
    }
}

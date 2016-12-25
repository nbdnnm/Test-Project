package gwtests;

import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.testng.annotations.Test;

import java.io.IOException;

public class GWTestLauncher extends BaseGWTestLauncher {


    @Test
    public void launchLoginTest() throws IOException {
        executor = new TestExecutor(new LoginParametrizedImpl().getClass());
        Result result = executor.execute(true);
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
        checkTestResult();
    }
}

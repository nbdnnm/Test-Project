package gwtests;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.testng.annotations.Test;

import java.io.IOException;

public class GWTestLauncher {

    Executor executor;

    @Test
    public void launchLoginTest() throws IOException {
        executor = new TestExecutor(LoginParametrizedImpl.class);
        Result result = executor.execute(true);
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
    }
}

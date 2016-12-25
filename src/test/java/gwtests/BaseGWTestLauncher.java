package gwtests;

import org.graphwalker.core.machine.ExecutionStatus;
import org.graphwalker.java.test.Executor;
import org.testng.Assert;

public class BaseGWTestLauncher {

    Executor executor;

    public void checkTestResult() {
        Assert.assertTrue(executor.getMachine().getCurrentContext().getExecutionStatus().equals(ExecutionStatus.COMPLETED));
    }
}

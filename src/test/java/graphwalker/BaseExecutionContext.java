package graphwalker;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;

public class BaseExecutionContext extends ExecutionContext {

    @BeforeElement
    public void printElementNameBefore() {
        System.out.println("Going to execute element " + this.getCurrentElement().getName());
    }

    @AfterElement
    public void printElementAfter() {
        System.out.println("Have executed element " + this.getCurrentElement().getName());
    }
}

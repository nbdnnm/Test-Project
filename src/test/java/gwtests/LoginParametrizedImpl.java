package gwtests;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))", start = "LaunchApplication")
public class LoginParametrizedImpl extends ExecutionContext implements LoginParametrized {

    Integer counter = 1;


    @Override
    public void LaunchApplication() {
    }

    @Override
    public void Login() {
        if (counter.equals(3)) {
            setAttribute("loginTested", true);
        }
        counter++;

    }

    @Override
    public void LogOut() {
    }

    @Override
    public void LoggedOut() {
    }

    @Override
    public void TheRestOfAppFunctionality() {

    }

    @Override
    public void ApplicationLaunched() {
    }

    @Override
    public void LoggedIn() {
    }

    @Override
    public void GoToAnotherTests() {
    }
}

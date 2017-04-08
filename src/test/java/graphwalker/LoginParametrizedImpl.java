package graphwalker;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import java.util.Iterator;
import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "LaunchApplication")
public class LoginParametrizedImpl extends ExecutionContext implements LoginParametrized {

    List<String> logins = TestData.testDataSample();
    Iterator<String> loginIterator;

    @Override
    public void LaunchApplication() {
        loginIterator = logins.iterator();
    }

    @Override
    public void Login() {
        System.out.println("Log in with " + loginIterator.next());
        if (!loginIterator.hasNext()) {
            setAttribute("loginTested", true);
        }

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

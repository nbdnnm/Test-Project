package general.utils;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    private static MouseActions instance = null;
    private Actions builder = new Actions(Driver.getInstance().getDriver());

    private MouseActions() {

    }

    public static MouseActions getInstance() {
        if (instance == null) {
            instance = new MouseActions();
        }
        return instance;
    }

    public void moveElementRight(WebElement element, Integer pixels) {
        builder
                .clickAndHold(element)
                .moveByOffset(element.getLocation().getX() + pixels, element.getLocation().getY())
                .build().perform();
    }

    public void moveElementLeft(WebElement element, Integer pixels) {
        builder
                .clickAndHold(element)
                .moveByOffset(element.getLocation().getX() - pixels, element.getLocation().getY())
                .build().perform();
    }

    public void mouseOverElement(WebElement element) {
        builder.moveToElement(element).build().perform();
    }

}

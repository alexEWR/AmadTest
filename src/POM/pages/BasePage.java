package POM.pages;

import POM.elements.CustomElement;
import utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Logger;

import java.util.List;

/**
 * Created by Alex on 29.03.2017.
 */
public class BasePage {
    protected String url;

    public BasePage open() {
        Logger.STEP("Navigating to: " + url);

        WebDriverManager.getDriver().get(url);
        WebDriverManager.getDriver().manage().window().maximize();
        return this;
    }

//GETTERS FOR WEB_ELEMENT WRAPPERS

    public CustomElement getElement(By locator) {
        return new CustomElement(locator);
    }

    public List<WebElement> getElements(By locator){
        return new CustomElement(locator).getWebElements();
    }




    /**
     * Switches to default content of the page.
     * Useful when IFrame was selected and access to default content is required
     */
    public void switchToDefaultContent() {
        Logger.DEBUG("Switching to default content");
        WebDriverManager.getDriver().switchTo().defaultContent();
    }

    /**
     * Returns current url of the page
     *
     * @return String - Current url
     */
    public String getCurrentUrl() {
        return WebDriverManager.getDriver().getCurrentUrl();
    }

    /**
     * Try to avoid using this function!
     * Wrapper for Thread.sleep
     *
     * @param millis - time in milliseconds
     */
    public static void sleep(int millis) {

        Logger.DEBUG("Sleeping for " + millis + " milliseconds.");

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Logger.EXCEPTION("Problem was encountered during using Thread.sleep() method.");
        }
    }

    public void reloadPage() {
        Logger.STEP(this.getClass().getSimpleName() + ": Reload page");

        WebDriverManager.getDriver().navigate().refresh();
    }



}

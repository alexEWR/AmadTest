package POM.pages;

import org.openqa.selenium.By;

/**
 * Created by Alex on 29.03.2017.
 */
public class TelephonesPage extends BasePage {
    private static final By SMARTPHONES_LINK_LOCATOR = By.xpath("//li[@param='60974']//li[@class='m-cat-subl-i'][1]/a");

    public SmartPhonesPage clickSmartphones(){
        getElement(SMARTPHONES_LINK_LOCATOR).waitForVisibleAndClick(5);
        return new SmartPhonesPage();
    }
}

package POM.pages;

import org.openqa.selenium.By;
import utils.Logger;


/**
 * Created by Alex on 30.03.2017.
 */
public class TelephonesAndElectronicsPage extends BasePage{
    private static final By TELEPHONES_LINK_LCATOR = By.xpath("//h4/a[@href='http://rozetka.com.ua/telefony/c4627900/']");

    public TelephonesPage clickTelephones(){
        Logger.STEP("Click Telephones link");
        getElement(TELEPHONES_LINK_LCATOR).waitForVisibleAndClick(5);
        return new TelephonesPage();
    }

}

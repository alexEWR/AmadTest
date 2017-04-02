package POM.pages;

import configs.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import utils.Logger;

/**
 * Created by Alex on 30.03.2017.
 */
public class SideBar extends BasePage {

    private static final By TELEPHONES_TV_AND_ELECTRONICS_LINK_LOCATOR = By.xpath("//li[@menu_id='3361']/a");
    private static final By HOVERED_MENU_ELEMENT_LOCATOR = By.xpath("//nav[@class='m-main m-menu-btn-hover hover-layer']");

    public SideBar() {
        url = Config.getEnvironmentUrl();
    }

    @Override
    public SideBar open(){
        super.open();
        return this;
    }

    public TelephonesAndElectronicsPage clickTelephonesTvAndElectronics(){
        Logger.STEP("Open section Telephones TV and Electronics");
        getElement(TELEPHONES_TV_AND_ELECTRONICS_LINK_LOCATOR).waitForVisibleAndClick(5);
        //Added for stable work of test. Resolves problem of unexpected work after clicking on previous element
        try{
            getElement(HOVERED_MENU_ELEMENT_LOCATOR).waitForElementVisible(2);
            getElement(TELEPHONES_TV_AND_ELECTRONICS_LINK_LOCATOR).waitForVisibleAndClick(2);
        }catch (TimeoutException e){
            Logger.EXCEPTION(e.getMessage());
        }
        return new TelephonesAndElectronicsPage();
    }
}

package POM.pages;

import configs.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

/**
 * Created by Alex on 29.03.2017.
 */
public class SideBar extends BasePage {

    private static final By TELEFONY_TV_I_ELECTRONIKA_LOCATOR = By.xpath("//li[@menu_id='3361']/a");
    private static final By HOVERED_MENU_LOCATOR = By.xpath("//nav[@class='m-main m-menu-btn-hover hover-layer']");

    public SideBar() {
        url = Config.getEnvironmentUrl();
    }

    @Override
    public SideBar open(){
        super.open();
        return this;
    }

    public TelefonyElectronikaPage clickTelefonyTvIElectronika(){
        getElement(TELEFONY_TV_I_ELECTRONIKA_LOCATOR).waitForVisibleAndClick(5);
        //resolve problem of unexpected work after clicking on previous element
        //TODO write by better way, for example add javascript executor waitForCallBacks
        try{
            getElement(HOVERED_MENU_LOCATOR).waitForElementVisible(2);
            getElement(TELEFONY_TV_I_ELECTRONIKA_LOCATOR).waitForVisibleAndClick(2);
        }catch (TimeoutException e){

        }
        return new TelefonyElectronikaPage();
    }
}

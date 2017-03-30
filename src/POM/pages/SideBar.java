package POM.pages;

import configs.Config;
import org.openqa.selenium.By;

/**
 * Created by Alex on 29.03.2017.
 */
public class SideBar extends BasePage {

    private static final By TELEFONY_TV_I_ELECTRONIKA_LOCATOR = By.xpath("//a[@data-title='Смартфоны, ТВ и электроника']");
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
        getElement(HOVERED_MENU_LOCATOR).waitForElementVisible(5);
        getElement(TELEFONY_TV_I_ELECTRONIKA_LOCATOR).waitForVisibleAndClick(5);
        return new TelefonyElectronikaPage();
    }
}

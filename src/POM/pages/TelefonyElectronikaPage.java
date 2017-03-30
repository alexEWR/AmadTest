package POM.pages;

import org.openqa.selenium.By;

/**
 * Created by Alex on 29.03.2017.
 */
public class TelefonyElectronikaPage extends BasePage{
    private static final By TELEFONU_LINK_LCATOR = By.xpath("//h4/a[contains(., 'Телефоны')]");

    public TelephonesPage clickTelefonu(){
        getElement(TELEFONU_LINK_LCATOR).waitForClickableAndClick(5);
        return new TelephonesPage();
    }

}

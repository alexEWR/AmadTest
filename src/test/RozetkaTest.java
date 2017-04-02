package test;

import POM.pages.SideBar;
import utils.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DataBaseManager;
import utils.Logger;

/**
 * Created by Alex on 30.03.2017.
 */
public class RozetkaTest {
    public static int RUN_ID;

    @BeforeClass
    public void beforeClass() {
        Logger.INFO("Before class executing");
        RUN_ID = new DataBaseManager().getNewRunId();

        new SideBar()
                .open();

    }

    @AfterClass
    public void afterClass() {
        WebDriverManager.close();
        Logger.INFO("After class executed");
    }


    @Test
    public void testListOfPopularSmartPhones() {
        new SideBar()
                .clickTelephonesTvAndElectronics()
                .clickTelephones()
                .clickSmartphones()
                .setToDbTopSaleItemsNamesAndPrices(RUN_ID)
                .openSecondPage()
                .setToDbTopSaleItemsNamesAndPrices(RUN_ID)
                .openThirdPage()
                .setToDbTopSaleItemsNamesAndPrices(RUN_ID);

        Assert.assertTrue(true, "There can be your assert ");
    }
}

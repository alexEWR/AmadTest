package tests;

import POM.pages.SideBar;
import configs.WebDriverManager;
import org.testng.annotations.*;
import utils.DataBaseManager;
import utils.StringHelper;

/**
 * Created by Alex
 */
public class RozetkaTests {
    public static int RUN_ID;

    @BeforeClass
    public void beforeClass() {
        RUN_ID = new DataBaseManager().getNewRunId();

        new SideBar()
                .open();

    }

    @BeforeMethod
    public void beforeTest() {
        System.out.println("Before Test");

    }

    @AfterMethod
    public void afterTest() {
    }

    @AfterClass
    public void afterClass() {
        WebDriverManager.close();
    }



    @Test
    public void testListOfPopularSmartPhones(){
        new SideBar()
                .clickTelefonyTvIElectronika()
                .clickTelefonu()
                .clickSmartphones()
                .setToDbTopSaleItemsNamesAndPrices(RUN_ID)
                .openSecondPage()
                .setToDbTopSaleItemsNamesAndPrices(RUN_ID)
                .openThirdPage()
                .setToDbTopSaleItemsNamesAndPrices(RUN_ID);

//        new DataBaseManager().printAllInDataBase();
    }


}

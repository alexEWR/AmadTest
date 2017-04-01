package test;

import POM.pages.SideBar;
import configs.WebDriverManager;
import org.testng.annotations.*;
import utils.DataBaseManager;

/**
 * Created by Alex
 */
public class RozetkaTest {
    public static int RUN_ID;

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
        RUN_ID = new DataBaseManager().getNewRunId();

        new SideBar()
                .open();

    }

//    @BeforeMethod
//    public void beforeTest() {
//        System.out.println("Before Test");
//
//    }
//
//    @AfterMethod
//    public void afterTest() {
//    }

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

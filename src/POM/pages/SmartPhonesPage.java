package POM.pages;

import configs.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DataBaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 29.03.2017.
 */
public class SmartPhonesPage extends BasePage{
    private static final By TOP_SALE_PHONES_ELEMENT_LOCATOR =
            By.xpath("//div[@class='g-i-tile g-i-tile-catalog'][.//i[@class='g-tag g-tag-icon-middle-popularity sprite']]");
    private static final By PHONE_NAME_LOCATOR = By.xpath("//div[@class='g-i-tile-i-title clearfix']");
    private static final By PHONE_PRICE_LOCATOR = By.xpath("//div[@class='g-price-uah']");
    private static final By SECOND_PAGE_BUTTON_LOCATOR = By.xpath("//li[@id='page2']/a");
    private static final By THIRD_PAGE_BUTTON_LOCATOR = By.xpath("//li[@id='page3']/a");


    public SmartPhonesPage openSecondPage(){
        getElement(SECOND_PAGE_BUTTON_LOCATOR).waitForVisibleAndClick(5);
        getElement(SECOND_PAGE_BUTTON_LOCATOR).waitForElementIsNotVisible(5);
        return this;
    }

    public SmartPhonesPage openThirdPage(){
        getElement(THIRD_PAGE_BUTTON_LOCATOR).waitForVisibleAndClick(5);
        getElement(THIRD_PAGE_BUTTON_LOCATOR).waitForElementIsNotVisible(5);
        return this;
    }

    private List<WebElement> getListOfTopSalesPhones(){
        return getElements(TOP_SALE_PHONES_ELEMENT_LOCATOR);
    }

    public SmartPhonesPage setToDbTopSaleItemsNamesAndPrices(int runId){
        //List<WebElement> list = new ArrayList<>(WebDriverManager.getDriver().findElements(TOP_SALE_PHONES_ELEMENT_LOCATOR));
        List<WebElement> list = getListOfTopSalesPhones();
        if(list.size()>0){
            for(int i=0; i<list.size(); i++){
                String price = getElement(By.xpath("//div[@class='g-i-tile g-i-tile-catalog'][.//i[@class='g-tag g-tag-icon-middle-popularity sprite']]["+(i+1)+"]" +
                        "//div[@class='g-price-uah']")).getText();
                String name = getElement(By.xpath("//div[@class='g-i-tile g-i-tile-catalog'][.//i[@class='g-tag g-tag-icon-middle-popularity sprite']]["+(i+1)+"]" +
                        "//div[@class='g-i-tile-i-title clearfix']")).getText();
                new DataBaseManager().insertInDataBaseSmatrphones(name, price, runId);
            }
        }
        return this;
    }
}

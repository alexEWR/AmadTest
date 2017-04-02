package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DataBaseManager;
import utils.Logger;

import java.util.List;

/**
 * Created by Alex on 30.03.2017.
 */
public class SmartPhonesPage extends BasePage {
    private static final By TOP_SALE_PHONES_ELEMENT_LOCATOR =
            By.xpath("//div[@class='g-i-tile g-i-tile-catalog'][.//i[@class='g-tag g-tag-icon-middle-popularity sprite']]");
    private static final By PHONE_NAME_LOCATOR = By.xpath("//div[@class='g-i-tile-i-title clearfix']");
    private static final By PHONE_PRICE_LOCATOR = By.xpath("//div[@class='g-price-uah']");
    private static final By SECOND_PAGE_BUTTON_LOCATOR = By.xpath("//li[@id='page2']/a");
    private static final By THIRD_PAGE_BUTTON_LOCATOR = By.xpath("//li[@id='page3']/a");


    public SmartPhonesPage openSecondPage() {
        Logger.STEP("Open second page on Smartphone's page");
        getElement(SECOND_PAGE_BUTTON_LOCATOR).waitForVisibleAndClick(5);
        getElement(SECOND_PAGE_BUTTON_LOCATOR).waitForElementIsNotVisible(5);
        return this;
    }

    public SmartPhonesPage openThirdPage() {
        Logger.STEP("Open third page on Smartphone's page");
        getElement(THIRD_PAGE_BUTTON_LOCATOR).waitForVisibleAndClick(5);
        getElement(THIRD_PAGE_BUTTON_LOCATOR).waitForElementIsNotVisible(5);
        return this;
    }

    private List<WebElement> getListOfTopSalesPhones() {
        return getElements(TOP_SALE_PHONES_ELEMENT_LOCATOR);
    }

    //This method can be improved. Class of card item can be created. In this class will be documented all locators
    // which needed. And some method of getting special data can be created.
    // It will help to avoid repeated peaces of code
    public SmartPhonesPage setToDbTopSaleItemsNamesAndPrices(int runId) {
        Logger.STEP("Collecting names and prices of top sales smartphones");

        String cardLocator = "//div[@class='g-i-tile g-i-tile-catalog'][.//i[@class='g-tag g-tag-icon-middle-popularity sprite']]";
        String priceLocator = "//div[@class='g-price-uah']";
        String nameLocator = "//div[@class='g-i-tile-i-title clearfix']";

        List<WebElement> list = getListOfTopSalesPhones();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String price = getElement(By.xpath(cardLocator + "[" + (i + 1) + "]" + priceLocator)).getText();
                String name = getElement(By.xpath(cardLocator + "[" + (i + 1) + "]" + nameLocator)).getText();

                new DataBaseManager().insertInDataBaseSmatrphones(name, price, runId);
                Logger.ACTION("Row added to DB with name: " + name + " price: " + price);
            }
        }
        return this;
    }
}

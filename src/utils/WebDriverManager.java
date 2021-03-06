package utils;

/**
 * Created by Alex on 30.03.2017.
 */

import configs.Config;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriver driver = null;

    private WebDriverManager() {
    }

    private static WebDriver getDriver(String browser) {
        if (driver != null) {
            return driver;
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                driver = new ChromeDriver();

                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return getDriver(Config.getBrowserName());
    }

    /**
     * Closes WebDriver as well as Browser.
     */
    public static void close() {
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.ERROR("It was unable to close WebDriver properly for some reason");
                driver.quit();
                driver = null;
            }
        }
    }

}

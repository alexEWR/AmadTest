package configs;

/**
 * Created by Alex on 29.03.2017.
 */

import utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriver driver = null;

    private WebDriverManager() {
    }

    public static WebDriver getDriver(String browser) {
        if (driver != null) {
            return driver;
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;
        }
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

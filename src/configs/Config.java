package configs;

/**
 * Created by Alex on 29.03.2017.
 */
import utils.DataBaseManager;
import utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private static Browser currentBrowser = Browser.CHROME;
    private static EnvironmentType environment = EnvironmentType.PRODUCTION;


    /**
     * Returns environment URL for <sitename></sitename> by specified environment name
     *
     * @return String with environment URL
     */
    private static String getEnvironmentUrl(EnvironmentType environmentName) {
        Map<EnvironmentType, String> environmentUrl = new HashMap<EnvironmentType, String>();
        environmentUrl.put(EnvironmentType.UAT, "http://rozetka.com.ua/");
        environmentUrl.put(EnvironmentType.PRODUCTION, "http://rozetka.com.ua/");

        return environmentUrl.get(environmentName);
    }

    public static String getEnvironmentUrl(){
        return getEnvironmentUrl(environment);
    }

    private static String setBrowserName(Browser browser) {
        Map<Browser, String> environmentUrl = new HashMap<Browser, String>();
        environmentUrl.put(Browser.CHROME, "chrome");
        environmentUrl.put(Browser.FIREFOX, "firefox");

        return environmentUrl.get(browser);
    }
    /**
     * Use this function to specify ImplicitlyWait for WebDriver
     *
     * @return int seconds
     */
    public static int getDefaultImplicitlyWait() {
        return 2;
    }

    public static String getBrowserName() {
        return setBrowserName(currentBrowser);
    }

    public enum EnvironmentType {
        PRODUCTION,
        UAT,
    }

    public enum Browser {
        CHROME,
        FIREFOX,
    }

    /**
     * Selects one of available LogLevels.
     */
    public static int getLogLevel() {
        return Logger.LOG_LEVEL_INFO;
    }
}

package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    static Logger LOGGER = Logger.getLogger(BrowserFactory.class);
    public static WebDriver driver;

    public static WebDriver startBrowser(String Browser, String URL) throws MalformedURLException, InterruptedException {
        if (driver == null || !isSessionActive()) {
            driver = startRemoteWebBrowser(Browser, URL);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static boolean isSessionActive() {
        try {
            return driver.findElements(By.tagName("body")).size() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public static WebDriver startRemoteWebBrowser(String browser, String URL) {
        if (AutomationConstants.REMOTE_BROWSER.equalsIgnoreCase("true")) {
            try {
                LOGGER.info("grid started in BrowserStack...");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                if (System.getProperty("Browser").equalsIgnoreCase("firefox")) {
                    capabilities = DesiredCapabilities.firefox();
                    capabilities.setPlatform(Platform.WIN8);
                    capabilities.setVersion("47");
                } else if (System.getProperty("Browser").equalsIgnoreCase("chrome")) {

                    capabilities = DesiredCapabilities.chrome();
                    capabilities.setPlatform(Platform.WIN10);
                    capabilities.setVersion("54");
                }
                java.net.URL url = new URL(AutomationConstants.SELENIUM_GRID_URL);
                driver = new RemoteWebDriver(url, capabilities);
                capabilities.setCapability("browserstack.debug", "true");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/browsers/geckodriver.exe");
                LOGGER.info("starting local firefox...");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver.exe");
                LOGGER.info("starting local chrome...");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "src/browsers/IEDriver.exe");
                LOGGER.info("starting local IE...");
                driver = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("Safari")) {
                System.setProperty("webdriver.ie.driver", "src/browsers/SafariDriver.exe");
                LOGGER.info("starting local safari...");
                driver = new SafariDriver();
            }
        }
        driver.get(URL);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void stopBrowser() {
        driver.quit();
    }
}

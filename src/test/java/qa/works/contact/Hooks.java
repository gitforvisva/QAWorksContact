package qa.works.contact;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.AutomationConstants;
import utils.BrowserFactory;

public class Hooks {

    public WebDriver driver;

    @Before
    public void start() {
        try {
            BrowserFactory.startBrowser(AutomationConstants.BROWSER_TYPE, AutomationConstants.URL);
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeBrowser() {
        BrowserFactory.stopBrowser();
    }
}
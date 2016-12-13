package qa.works.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

public class BasePage extends BrowserFactory {

    WebDriver driver = BrowserFactory.getDriver();

    BasePage() {
        PageFactory.initElements(driver, this);
    }
}


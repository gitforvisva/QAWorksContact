package qa.works.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "logo")
    WebElement qaworksLogo;
    @FindBy(linkText = "Contact")
    WebElement contact;

    public String iAmInHomePage() {
        return driver.getCurrentUrl();
    }

    public void navigateToContactPage() throws InterruptedException {
        Thread.sleep(5000);
        contact.click();
    }

    public void inQAWorks() {
        try {
            qaworksLogo.click();
        } catch (Exception e) {
            driver.navigate().back();
            qaworksLogo.click();
        }
    }
}


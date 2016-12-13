package qa.works.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//div[@id='ContactHead']/h1")
    WebElement contactPageText;
    @FindBy(css = "input[id$='_NameBox']")
    WebElement nameField;
    @FindBy(css = "input[id$='_EmailBox']")
    WebElement emailField;
    @FindBy(css = "textarea[id$='_MessageBox']")
    WebElement messageField;
    @FindBy(xpath = "//div[@id='ContactSend']/input")
    WebElement sendMessage;
    @FindBy(xpath = "//div[@id='ContactMessageUs']/h2")
    WebElement messageSent;
    @FindBy(css = "span[id$='_rfvName']")
    WebElement blankName;
    @FindBy(css = "span[id$='_rfvEmailAddress']")
    WebElement blankEmail;
    @FindBy(css = "span[id$='_rfvMessage']")
    WebElement blankMessage;
    @FindBy(xpath = "//html/body/span/h1")
    WebElement invalidDtlsMessage;


    public String contactPageURL() {
        return driver.getCurrentUrl();
    }

    public String inContactPage() {
        return contactPageText.getText();
    }

    public void provideDetails(String name, String email, String message) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        messageField.sendKeys(message);
    }

    public void sendDetails() {
        sendMessage.click();
    }

    public String successMessage() {
        return messageSent.getText();
    }

    public String blankNameMessageDispalyed() {
        return blankName.getText();
    }

    public String blankEmailMessageDispalyed() {
        return blankEmail.getText();
    }

    public String blankMessageDispalyed() {
        return blankMessage.getText();
    }

    public void invalidDetailsSent(String invalidname, String invalidemail, String invalidmessage) {
        nameField.sendKeys(invalidname);
        emailField.sendKeys(invalidemail);
        messageField.sendKeys(invalidmessage);
    }

    public String invalidDetailsErrorMessage() {
        return invalidDtlsMessage.getText();
    }

    public String invalidEmailMessage() {
        return blankEmail.getText();
    }
}


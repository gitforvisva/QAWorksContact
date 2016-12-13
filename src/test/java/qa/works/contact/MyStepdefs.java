package qa.works.contact;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import utils.AutomationConstants;
import utils.Utilities;

import java.io.IOException;

public class MyStepdefs {
    Logger LOGGER = Logger.getLogger(MyStepdefs.class);
    HomePage homepage = new HomePage();
    ContactPage contactPage = new ContactPage();

    @Given("^I am on the QAWorks Site$")
    public void iAmOnTheQAWorksSite() {
        LOGGER.info("I am in HomePage...");
        homepage.inQAWorks();
        String hompePageURL = homepage.iAmInHomePage();
        try {
            Utilities.captureScreenshot("InHomePage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(AutomationConstants.URL, hompePageURL);
    }

    @When("^I navigate to Contact Page$")
    public void iNavigateToContactPage() throws InterruptedException {
        homepage.navigateToContactPage();
    }

    @Then("^I should be in the Contact Page$")
    public void iShouldBeInTheContactPage() {
        LOGGER.info("I am in ContactUs page...");
        String contactPageUrl = contactPage.contactPageURL();
        try {
            Utilities.captureScreenshot("InContactPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("http://www.qaworks.com/contact.aspx", contactPageUrl);
        String contactPageText = contactPage.inContactPage();
        Assert.assertEquals("Contact", contactPageText);
    }

    @When("^I provide my name \"([^\"]*)\" email \"([^\"]*)\" and message  \"([^\"]*)\"$")
    public void iProvideMyNameEmailAndMessage(String name, String email, String message) {
        contactPage.provideDetails(name, email, message);
    }

    @And("^send the details$")
    public void sendTheDetails() {
        contactPage.sendDetails();
    }

    @Then("^I should see Message \"([^\"]*)\"$")
    public void iShouldSeeMessage(String successMessage) {
        LOGGER.info("Message Successfully sent ...");
        String successMessageText = contactPage.successMessage();
        try {
            Utilities.captureScreenshot("MessageSuccesfullySent");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(successMessage, successMessageText);
    }

    @When("^I provide invalid details  in name \"([^\"]*)\" email \"([^\"]*)\" and message  \"([^\"]*)\"$")
    public void iProvideInvalidDetailsInNameEmailAndMessage(String name, String email, String message) {
        contactPage.provideDetails(name, email, message);
    }

    @Then("^I should see Error Message for Blank Name \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForBlankName(String errorName) {
        LOGGER.info("Blank Name error...");
        String blankNameMessage = contactPage.blankNameMessageDispalyed();
        try {
            Utilities.captureScreenshot("BlankNameError");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(errorName, blankNameMessage);
    }

    @Then("^I should see Error Message for Blank Email \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForBlankEmail(String errorEmail) {
        LOGGER.info("Blank email Error...");
        String blankEmailMessage = contactPage.blankEmailMessageDispalyed();
        try {
            Utilities.captureScreenshot("BlankEmailError");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(errorEmail, blankEmailMessage);
    }

    @Then("^I should see Error Message for Blank Message \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForBlankMessage(String errorMessage) {
        LOGGER.info("Blank Message Error...");
        String blankMessage = contactPage.blankMessageDispalyed();
        try {
            Utilities.captureScreenshot("BlankMessageError");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(errorMessage, blankMessage);
    }

    @When("^I provide invalid name \"([^\"]*)\" email \"([^\"]*)\" and message  \"([^\"]*)\"$")
    public void iProvideInvalidNameEmailAndMessage(String invalidName, String invalidEmail, String invalidMessage) {
        contactPage.invalidDetailsSent(invalidName, invalidEmail, invalidMessage);
    }

    @Then("^I should see Error Message for Invalid Details \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForInvalidDetails(String invalidDetails) {
        LOGGER.info("Invalid Details Error...");
        String invalidDetailsErrorMessage = contactPage.invalidDetailsErrorMessage();
        try {
            Utilities.captureScreenshot("InvalidDetailsError");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(invalidDetails, invalidDetailsErrorMessage);
    }

    @Then("^I should see Error Message for InvalidEmail \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForInvalidEmail(String invalidEmail) {
        LOGGER.info("Invalid Email Error...");
        String invalidEmailText = contactPage.invalidEmailMessage();
        try {
            Utilities.captureScreenshot("InvalidEmailError");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(invalidEmail, invalidEmailText);
    }
}




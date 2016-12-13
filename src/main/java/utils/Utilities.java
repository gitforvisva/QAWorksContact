package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Utilities extends BrowserFactory {

    static WebDriverWait wait = new WebDriverWait(driver, 60);

    public static void captureScreenshot(String screenshotName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceScreenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationScreenShot = new File("src/test/resources/Screenshots/" + screenshotName + ".png");
        FileUtils.copyFile(sourceScreenShot, destinationScreenShot);
    }

    public static void waitForElementToBeClickable(WebElement ElementToBeClickable) {
        wait.until(ExpectedConditions.elementToBeClickable(ElementToBeClickable));
    }

    public static void waitForTextElementToBe(WebElement locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
    }

    public static Boolean waitForURLToBe(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }
}


package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Browser;

import static utils.Browser.driver;

public class Base {

    /**
     * Click to specific web element
     *
     * @param locator object of type 'By'
     */
    protected static void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Click to specific web element using JavascriptExecutor
     *
     * @param locator object of type 'By'
     */
    protected static void clickFromJSExecutor(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Get text from web element
     *
     * @param locator object of type 'By'
     * @return text from web element as a String
     */
    protected static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * Scroll to element until the element get into view
     * The method is using the JavascriptExecutor
     * @param locator object of type 'By'
     */
    protected static void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

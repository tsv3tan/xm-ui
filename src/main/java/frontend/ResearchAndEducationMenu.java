package frontend;

import base.Base;
import org.openqa.selenium.By;
import utils.Browser;

public class ResearchAndEducationMenu extends Base {

    public static final By ECONOMIC_CALENDAR = By.xpath("//div[@class='block']" +
            "//a[contains(@href,'economicCalendar')]");

    public static final By ECONOMIC_CALENDAR_BUTTON =
            By.xpath("(//a[contains(@href,'economicCalendar')])[2]");


    /**
     * Click to Economy Calendar Link
     */
    public static void clickToEconomyCalendarLink() {
        if (Browser.driver.findElement(ECONOMIC_CALENDAR_BUTTON).isDisplayed()) {
            clickFromJSExecutor(ECONOMIC_CALENDAR_BUTTON);
        } else {
            scrollToElement(ECONOMIC_CALENDAR);
            clickFromJSExecutor(ECONOMIC_CALENDAR);
        }
    }
}

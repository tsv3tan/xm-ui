package frontend;

import base.Base;
import org.openqa.selenium.By;
import utils.Browser;

public class UserHomePage extends Base {

    private static final By ACCEPT_ALL_COOKIES_BUTTON = By.xpath("//button[contains(@class, " +
            "'gtm-acceptDefaultCookieFirstVisit')]");

    /**
     * The method is open user Homepage
     * (Here we can use environments param)
     */
    public static void open() {
        Browser.driver.get("https://www.xm.com/");
    }

    /**
     * The method accept the website cookies
     */
    public static void acceptCookies() {
        click(ACCEPT_ALL_COOKIES_BUTTON);
    }


}

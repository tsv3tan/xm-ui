package frontend;

import base.Base;
import org.openqa.selenium.WebDriver;
import utils.Browser;

import java.time.Duration;

import static org.junit.Assert.*;
import static utils.Browser.driver;

public class UserRiskWarningPage extends Base {


    /**
     * The method verify that the Disclaimer Link is open
     */
    public static void verifySuccessfulOpeningOfDisclaimerLink() {
        Browser.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
        String expectedUrl = "https://www.xm.com/research/risk_warning";
        assertEquals("Disclaimer Link was not successful open", expectedUrl, driver.getCurrentUrl());
    }
}

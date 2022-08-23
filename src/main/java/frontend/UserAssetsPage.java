package frontend;

import base.Base;

import static utils.Browser.driver;
import static org.junit.Assert.*;

public class UserAssetsPage extends Base {

    /**
     * The method is switch to the new open
      */
    public static void navigateToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    /**
     * Verify the correct .pdf document was opened
     */
    public static void verifyAssetsPageDocumentIsOpenInNewWindow()  {
        String expectedUrlSubString = "XM-Risk-Disclosures-for-Financial-Instruments.pdf";
        assertTrue("The Risk Disclosures doc was not opened",
                driver.getCurrentUrl().contains(expectedUrlSubString));
    }
}

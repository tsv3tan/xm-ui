package frontend;

import base.Base;
import org.openqa.selenium.By;

public class RiskWarningBlock extends Base {

    private static final By RISK_WARNING_LINK = By.xpath("//span[@class='js-esmaRiskMsg']/a");

    /**
     * Click to the Risk Warning Link
     */
    public static void clickToRiskWarningLink() {
        click(RISK_WARNING_LINK);
    }
}

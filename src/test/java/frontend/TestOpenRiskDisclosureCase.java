package frontend;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Browser;


public class TestOpenRiskDisclosureCase {
    @BeforeTest
    public void setup() {
        Browser.open("maximized");
    }

    @Test
    public void openRiskDisclosureTest() throws InterruptedException {
        UserHomePage.open();
        UserHomePage.acceptCookies();
        UserHeader.clickToResearchAndEducationLink();
        ResearchAndEducationMenu.clickToEconomyCalendarLink();
        EconomicCalendar.navigateToEconomicCalendarFrame();
        EconomicCalendar.clickToDateFilterButton(EconomicCalendar.YESTERDAY_FILTER_BUTTON);
        EconomicCalendar.verifyDateIsCorrect("Yesterday");
        EconomicCalendar.clickToDateFilterButton(EconomicCalendar.TODAY_FILTER_BUTTON);
        EconomicCalendar.verifyDateIsCorrect("Today");
        EconomicCalendar.clickToDateFilterButton(EconomicCalendar.TOMORROW_FILTER_BUTTON);
        EconomicCalendar.verifyDateIsCorrect("Tomorrow");
        EconomicCalendar.clickToDateFilterButton(EconomicCalendar.THIS_WEEK_FILTER_BUTTON);
        EconomicCalendar.verifyDateIsCorrect("This Week");
        EconomicCalendar.switchToParenFrameAndClickToDisclaimerLink();
        UserRiskWarningPage.verifySuccessfulOpeningOfDisclaimerLink();
        RiskWarningBlock.clickToRiskWarningLink();
        UserAssetsPage.navigateToNewWindow();
        UserAssetsPage.verifyAssetsPageDocumentIsOpenInNewWindow();
    }

    @AfterTest
    public void tearDown() {
        Browser.close();
    }
}

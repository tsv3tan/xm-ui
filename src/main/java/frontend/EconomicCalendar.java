package frontend;

import base.Base;
import static java.time.DayOfWeek.*;
import static org.junit.Assert.*;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import static utils.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;


public class EconomicCalendar extends Base {

    public static final By YESTERDAY_FILTER_BUTTON = By.xpath("//a[@id='timeFrame_yesterday']");
    public static final By TODAY_FILTER_BUTTON = By.xpath("//a[@id='timeFrame_today']");
    public static final By TOMORROW_FILTER_BUTTON = By.xpath("//a[@id='timeFrame_tomorrow']");
    public static final By THIS_WEEK_FILTER_BUTTON = By.xpath("//a[@id='timeFrame_thisWeek']");
    private static final By DATE_FIELD_RANGE = By.xpath("//div[@id='widgetFieldDateRange']");
    private static final By DISCLAIMER_LINK = By.xpath("//a[contains(@href, 'risk_warning')]");
    private static final By SAVE_SPACE_TIME_BUTTON = By.xpath("//li[@class='saveSpace']/a");

    /**
     * Switching to Economic Calendar Frame
     */
    public static void navigateToEconomicCalendarFrame() {
        WebElement iframe = driver.findElement(By.xpath("//div[@class='economic-calendar']/iframe"));
        driver.switchTo().frame(iframe);
    }

    /**
     * Click to date filter button. The try/catch block is used from some different resolutions
     * @param dateFilterButton represent the static fields from the class
     */
    public static void clickToDateFilterButton(By dateFilterButton) {
        try {
            click(SAVE_SPACE_TIME_BUTTON);
        } catch (Exception e) {
            System.out.println("Button was not displayed, browser dimension was enough");
        }
        clickFromJSExecutor(dateFilterButton);
    }

    /**
     * The method verify the correct DATE range is shown
     * It used pattern 'dd/MM/yyyy' and preset TimeZone - 'Europe/London'
     * @param dateType can be 'yesterday', 'today', 'tomorrow' and 'this week'
     * @throws InterruptedException
     */
    public static void verifyDateIsCorrect(String dateType) throws InterruptedException {
        Thread.sleep(3000);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        Calendar cal = Calendar.getInstance();
        String actualDates = Base.getText(DATE_FIELD_RANGE).trim();
        String date = null;
        String expectedDates = null;

        if (dateType.equalsIgnoreCase("yesterday")) {
            cal.add(Calendar.DATE, -1);
            date = dateFormat.format(cal.getTime());
            expectedDates = date + " - " + date;
        }
        if (dateType.equalsIgnoreCase("today")) {
            date = dateFormat.format(cal.getTime());
            expectedDates = date + " - " + date;
        }
        if (dateType.equalsIgnoreCase("tomorrow")) {
            cal.add(Calendar.DATE, +1);
            date = dateFormat.format(cal.getTime());
            expectedDates = date + " - " + date;
        }
        if (dateType.equalsIgnoreCase("this week")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate today = LocalDate.now(ZoneId.of("Europe/London"));
            LocalDate monday = today.with(previousOrSame(SUNDAY));
            LocalDate sunday = today.with(nextOrSame(SATURDAY));

            String startDate = formatter.format(monday);
            String endDate = formatter.format(sunday);

            expectedDates = startDate + " - " + endDate;
        }

        assertEquals("The date is not correct", actualDates, expectedDates);
    }

    /**
     * The method is return the driver to the parent frame
      */
    public static void switchToParenFrameAndClickToDisclaimerLink() {
        driver.switchTo().parentFrame();
        clickFromJSExecutor(DISCLAIMER_LINK);
    }
}

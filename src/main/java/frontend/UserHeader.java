package frontend;

import base.Base;
import org.openqa.selenium.By;
import utils.Browser;

public class UserHeader extends Base {
    public static final By RESEARCH_AND_EDUCATION = By.xpath("//li[@class='main_nav_research']");

    public static final By RESEARCH_AND_EDUCATION_NAVIGATION_BUTTON
            = By.xpath("//a[@aria-controls='researchMenu']");

    public static final By BURGER_MENU = By.xpath("//button[@class='toggleLeftNav']");

    /**
     * Click to 'Research and Education Link' no matter the browser resolutions
     */
    public static void clickToResearchAndEducationLink() {
        if (Browser.driver.findElement(BURGER_MENU).isDisplayed()) {
            click(BURGER_MENU);
            clickFromJSExecutor(RESEARCH_AND_EDUCATION_NAVIGATION_BUTTON);
        } else {
            click(RESEARCH_AND_EDUCATION);
        }
    }
}

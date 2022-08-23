package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Browser {
    public static WebDriver driver;

    /**
     * The method open the browser
     * @param dimension can be 'width, height' separated by comma or text 'maximized'
     */
    public static void open(String dimension) {
        String[] resolution = null;
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.edge.driver", path + "\\src\\main\\resources\\webdrivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (dimension.contains(",")) {
            resolution = dimension.split(",");
            int width = Integer.parseInt(resolution[0].trim());
            int height = Integer.parseInt(resolution[1].trim());
            driver.manage().window().setSize(new Dimension(width, height));
        } else {
            driver.manage().window().maximize();
        }
    }

    /**
     * The method is closing the browser
     */
    public static void close() {
        driver.quit();
    }
}

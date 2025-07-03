package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;

    // WebDriver'ı alır, yoksa oluşturur ve döner
    public static WebDriver createDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("force-device-scale-factor=1.0");
            options.addArguments("high-dpi-support=1.0");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    // WebDriver'ı kapatır
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
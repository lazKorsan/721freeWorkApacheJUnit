package utilities.BrowserUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;

public class WindowHAndleTestUtils {

    /**
     * Bir butona tıklanarak yeni pencere/sekmeye geçişi ve kontrolünü örnekler.
     */
    public static void runWindowHandleSwitchTest(String siteUrl, String buttonLocator, String testName) {
        WebDriver driver = null;
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("force-device-scale-factor=1.0");
            options.addArguments("high-dpi-support=1.0");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("\n======= " + testName + " =======");
            driver.get(siteUrl);

            String mainHandle = driver.getWindowHandle();
            System.out.println("Ana pencere handle: " + mainHandle);

            // Örnek: Bir butona tıklayarak yeni pencere açtır (locator'a göre)

            driver.findElement(By.xpath(buttonLocator)).click();

            // Tüm handle’ları topla
            Set<String> allHandles = driver.getWindowHandles();

            // Yeni pencereye geç
            for (String handle : allHandles) {
                if (!handle.equals(mainHandle)) {
                    driver.switchTo().window(handle);
                    System.out.println("Yeni pencereye geçildi. Handle: " + handle);
                    System.out.println("Yeni pencere title: " + driver.getTitle());
                    break;
                }
            }

            // Gerekirse tekrar ana pencereye dön
            driver.switchTo().window(mainHandle);

        } catch (Exception e) {
            System.out.println("⚠️ Test sırasında bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println("==============================\n");
        }
    }
}
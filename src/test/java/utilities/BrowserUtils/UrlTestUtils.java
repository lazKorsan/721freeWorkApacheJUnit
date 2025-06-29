package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
/*
çagırmak için 4 önemli bileşen
1 runUrlContentTest(
2 String siteUrl,
3 String expectedContent,
4String testName
5 )
//==================================//
UrlTestUtils.runUrlContentTest(
            "https://www.testotomasyonu.com",
            "testotomasyonu",
            "Test Otomasyonu URL Testi"
//==================================//
 */

public class UrlTestUtils {

    /**
     * Verilen siteUrl'ye gider, URL'de expectedContent olup olmadığını test eder.
     * Sonucu ekrana yazdırır.
     */
    public static void runUrlContentTest(String siteUrl, String expectedContent, String testName) {
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
            System.out.println("Siteye gidiliyor: " + siteUrl);

            driver.get(siteUrl);
            String actualUrl = driver.getCurrentUrl();

            System.out.println("Beklenen içerik  : " + expectedContent);
            System.out.println("Gerçek URL       : " + actualUrl);

            if (actualUrl.contains(expectedContent)) {
                System.out.println("✅ Test Geçti: URL beklenen içeriği içeriyor.");
            } else {
                System.out.println("❌ Test Başarısız: URL beklenen içeriği içermiyor!");
            }

            // Eğer kendi bekle methodun varsa kullan, yoksa aşağıdaki satırı kaldırabilirsin.
            ReusableMethods.bekle(1);
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
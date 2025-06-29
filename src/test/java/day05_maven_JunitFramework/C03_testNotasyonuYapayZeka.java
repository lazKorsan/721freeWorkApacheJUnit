package day05_maven_JunitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_testNotasyonuYapayZeka {

    /**
     * Belirtilen URL'ye gider, beklenen içeriğin URL'de olup olmadığını kontrol eder.
     * @param siteUrl site adresi (örn: "https://www.testotomasyonu.com")
     * @param expectedContent URL'de beklenen anahtar kelime (örn: "testotomasyonu")
     * @param testName Testin adı (çıktı için)
     */
    private void runUrlContentTest(String siteUrl, String expectedContent, String testName) {
        WebDriver driver = null;
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("force-device-scale-factor=1.0");
            options.addArguments("high-dpi-support=1.0");
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("\n======= " + testName + " =======");  //satır31
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
    }  //satır56

    @Test
    public void testOtomasyonuTesti() {
        runUrlContentTest(
                "https://www.testotomasyonu.com",
                "testotomasyonu",
                "Test Otomasyonu URL Testi"
        );
    }

    @Test
    public void wiseQuarterOtomasyonTesti() {
        runUrlContentTest(
                "https://www.wisequarter.com",
                "wisequarter",
                "Wise Quarter URL Testi"
        );
    }

    @Test
    public void youtubeOtomasyonTesti() {
        runUrlContentTest(
                "https://www.youtube.com",
                "youtube",
                "YouTube URL Testi"
        );
    }
}
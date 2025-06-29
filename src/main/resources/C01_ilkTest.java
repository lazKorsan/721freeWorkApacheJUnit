package day05_maven_JunitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ilkTest {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.0");
        options.addArguments("high-dpi-support=1.0");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ilgili ayarları yap
        // testotomasyonu sayfasına git

        driver.get("https://www.testotomasyonu.com");

        // title nın test aotomasyonu içeridğini test et


        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        if (actualTitle.equals(actualTitle)){
            System.out.println("sayfa başlığı testi"+" Passed");
        }else {
            System.out.println("sayfa başlığı testi" + " Failed");
        }

        ReusableMethods.bekle(3);
        driver.quit();


    }
}

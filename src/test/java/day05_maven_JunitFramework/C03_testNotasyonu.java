package day05_maven_JunitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_testNotasyonu {


        // 1 testotomasyonu.com adresine git
        // url in "testotomasyonu" icerdigini kontrol et
        //2 wisequarter.com a gidip url in "wisequarter" icerdigini
        // kontrol edin
        // 3 youtube.com a gidip url in "youtube"içerdigini test edin

    @Test
    public  void testOtomasyonuTesti(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.0");
        options.addArguments("high-dpi-support=1.0");
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");


        String expectedURlicerik = "testotomasyonu";    //satır1
        String actualUrlicerik   =  driver.getCurrentUrl();  // satır2
        if (actualUrlicerik.contains(expectedURlicerik)){
            System.out.println("test Passed");
        }else{
            System.out.println("test Failed");
        }
        ReusableMethods.bekle(1);
        driver.quit();
    }


    @Test
    public  void wiseQuarterOtomasyonTesti(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.0");
        options.addArguments("high-dpi-support=1.0");
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.wisequarter.com");


        String expectedURlicerik = "wisequarter";
        String actualUrlicerik   =  driver.getCurrentUrl();
        if (actualUrlicerik.contains(expectedURlicerik)){
            System.out.println("test Passed");
        }else{
            System.out.println("test Failed");
        }
        ReusableMethods.bekle(1);
        driver.quit();
    }


    @Test
    public  void youtubeOtomasyonTesti(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.0");
        options.addArguments("high-dpi-support=1.0");
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");


        String expectedURlicerik = "youtube";
        String actualUrlicerik   =  driver.getCurrentUrl();
        if (actualUrlicerik.contains(expectedURlicerik)){
            System.out.println("test Passed");
        }else{
            System.out.println("test Failed");
        }
        ReusableMethods.bekle(1);
        driver.quit();
    }
}

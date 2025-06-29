package day05_maven_JunitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_OrtakBaslingicVeBitisAdimlari {
    /*
    bir birinden bağımsız çalışabilen 3 mini test yapalım
    "https://www.testotomasyonu.com" a gidip "testotomasyonu
    içeriğini kontrol edin
    2 "https://www.wisequarter.com" adresine gidip url nin "wisequarter"
    içerdiğini kontrol et
    3 "http://www.youtube.com" adresine gidip url nin "youtube" içerdiğini
    kontrol et


     */
    WebDriver driver ;

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.0");
        options.addArguments("high-dpi-support=1.0");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void driverKapatma(){
        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test
    public  void testOtomasyonuTesti(){
        setUp();


        driver.get("https://www.testotomasyonu.com");


        String expectedURlicerik = "testotomasyonu";    //satır1
        String actualUrlicerik   =  driver.getCurrentUrl();  // satır2
        if (actualUrlicerik.contains(expectedURlicerik)){
            System.out.println("test Passed");
        }else{
            System.out.println("test Failed");
        }
        driverKapatma();

    }


    @Test
    public  void wiseQuarterOtomasyonTesti(){
        setUp();

        driver.get("https://www.wisequarter.com");


        String expectedURlicerik = "wisequarter";
        String actualUrlicerik   =  driver.getCurrentUrl();
        if (actualUrlicerik.contains(expectedURlicerik)){
            System.out.println("test Passed");
        }else{
            System.out.println("test Failed");
        }
        driverKapatma();
    }


    @Test
    public  void youtubeOtomasyonTesti(){
        setUp();

        driver.get("https://www.youtube.com");


        String expectedURlicerik = "youtube";
        String actualUrlicerik   =  driver.getCurrentUrl();
        if (actualUrlicerik.contains(expectedURlicerik)){
            System.out.println("test Passed");
        }else{
            System.out.println("test Failed");
        }
       driverKapatma();
    }
}


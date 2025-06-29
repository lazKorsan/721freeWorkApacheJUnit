package day05_maven_JunitFramework;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.BulXpath;
import utilities.ReusableMethods;



import java.time.Duration;

public class C02_ZeroWebTesti {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.0");
        options.addArguments("high-dpi-support=1.0");
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // http//zero.webappsecurity.com

        driver.get("http://zero.webappsecurity.com");

        WebElement signButton = driver.findElement(By.xpath("//button[@class='signin btn btn-info']"));
        ReusableMethods.bekle(1);
        signButton.click();
        ReusableMethods.bekle(2);

        // loginBox a "username" yazdır
        WebElement loginBOx = driver.findElement(By.xpath("//*[contains(@id,'user_login')]"));
        loginBOx.sendKeys("username");

        // password alanına "password" yazdır

        WebElement passWordBox = driver.findElement(By.xpath("//*[contains(@id,'user_password')]"));
        passWordBox.sendKeys("password");

        //signin butununa tıklayın

        WebElement signBox = driver.findElement(By.xpath("//input[@name='submit']"));
        signBox.click();
        ReusableMethods.bekle(2);

        // navigateBack yap

        driver.navigate().back();

        ReusableMethods.bekle(5);
        // onlineBAnking menusunden PAyBills sayfasına gidin

        WebElement onlineBAnking = driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
        onlineBAnking.click();

        // PayyBills sayfasına git

        WebElement payBilsPage = driver.findElement(By.xpath("//*[@id='pay_bills_link']"));
        payBilsPage.click();
        // amount istediğin kadar yatırmaklıklık

        WebElement amountBOx = driver.findElement(By.xpath("//input[@id='sp_amount']"));

        amountBOx.sendKeys("100");

        WebElement dateBox = driver.findElement(By.xpath("//input[@id='sp_date']"));


        dateBox.sendKeys("14.06.2025");

        ReusableMethods.bekle(2);

        WebElement payButon = driver.findElement(By.xpath("//input[@id='pay_saved_payees']"));

        payButon.click();

        // alerkutusunda "The payment was successfully submitted." yazını kotrol edin.




        WebElement mesajKUtusu = driver.findElement(By.xpath("//*[@id='alert_content']"));



        // önemli nokta expectedTExt actual texten sonra alınacak

        String expectedText = "The payment was successfully submitted." ;
        String actualText = mesajKUtusu.getText();



       if (actualText.equals(expectedText)){
           System.out.println("içerik testi  Passed");
       }else {
           System.out.println("içerik testi Failed");
       }



        ReusableMethods.bekle(3);
        driver.quit();




    }
}

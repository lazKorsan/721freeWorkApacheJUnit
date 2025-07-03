package expendTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class DropDawnMenu {
    public static WebDriver driver ;
    @BeforeEach
    public void setUp(){
        driver = TestBase.createDriver();
    }
    @AfterEach
    public void tearDown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }
    @Test
    public void dropDownMenuTest(){
        driver.get("https://practice.expandtesting.com/form-validation");

        WebElement contactNameBox = driver.findElement(By.id("validationCustom01"));
        contactNameBox.clear();
        contactNameBox.sendKeys("lapseki lapseki");

        WebElement contactNumberBox = driver.findElement(By.xpath("(//input[@id='validationCustom05'])[1]")); // Telefon kutusu
        contactNumberBox.clear();
        contactNumberBox.sendKeys("012-3456789");


        WebElement pickUpDateBox = driver.findElement(By.xpath("(//input[@id='validationCustom05'])[2]")); // Örnek: id'yi kontrol et!
        pickUpDateBox.clear();
        pickUpDateBox.sendKeys("2025-07-03"); // Eğer input type="date" ise bu format kullanılmalı
        /// /////////////////////////////////////////////////////
        /// ////////////////////////////////////////////////////
        /// /////satır45  den  satır 67 arası dropdawn menu seçenekleri///////////
        /// /////////////////////////////////////////////////
        /// ///////////////////////////////////////////////////
        WebElement paymentMethodBox = driver.findElement(By.id("validationCustom04"));
        Select select = new Select(paymentMethodBox);
        select.selectByVisibleText("card");
        //select.selectByValue("option_value");
        //select.selectByVisibleText("Kredi Kartı");
        //select.selectByIndex(2);
        /// ////////////////////////////

        //Custom (Özel) Drop-down için (div, li, span ile yapılmışsa)
        // 1.adım  Kutuyu aç
        // WebElement paymentMethodBox = driver.findElement(By.xpath("//*[@id='validationCustom04']"));
        //paymentMethodBox.click();
        //2.adım  Açılan listeden istediğin seçeneği bul ve tıkla
        //WebElement krediKartiOption = driver.findElement(By.xpath("//li[text()='Kredi Kartı']"));
        //krediKartiOption.click();
        // diger yol
        // WebElement option = driver.findElement(By.xpath("//div[contains(@class,'dropdown-menu')]//span[text()='Kredi Kartı']"));
        //option.click();
        /// /////////////////////////////////
        // daha sağlam bir yöntem
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Kredi Kartı']")));
        //option.click();

        /// ////////////////////////////////////////////////////
        /// ////////////////////////////////////////////////////
        /// /////////////////////////////////////////////////////
        /// ///////////////////////////////////////////////////

        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"core\"]/div/div/div/div/div/form/div[5]/button")) ;
        registerButton.click(); // Formu gönder


        WebElement alertbox = driver.findElement(By.xpath("//*[@id=\"core\"]/div/div/div"));

        String expectedTextAlertBox= "Thank you for validating your ticket";
        System.out.println(driver.findElement(By.xpath("//*[@id=\"core\"]/div/div/div/p")).getText());

        if (driver.findElement(By.xpath("//*[@id=\"core\"]/div/div/div/p")).getText().equalsIgnoreCase(expectedTextAlertBox)) {
            System.out.println("huguh");
        }else System.out.println("nahuguh");

        // Gerekirse bekleme ekleyebilirsin
        // ReusableMethods.bekle(2);
        // //*[text()='CodeName']
        /*
        import org.openqa.selenium.support.ui.Select;

WebElement paymentMethodBox = driver.findElement(By.xpath("//*[@id='validationCustom04']"));
Select select = new Select(paymentMethodBox);

// Seçeneklerden birini value ile seçmek:
select.selectByValue("option_value");

// Seçeneklerden birini görünen yazı ile seçmek:
select.selectByVisibleText("Kredi Kartı");

// Seçeneklerden birini index ile seçmek:
select.selectByIndex(2);
         */
    }

}


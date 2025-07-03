package expendTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class upLoadTesting {
    public static WebDriver driver ;
    @BeforeEach
    public void setDriver(){
        driver = TestBase.createDriver();
    }
    @AfterEach
    public void tearDown(){
        ReusableMethods.bekle(3);
        driver.quit();
    }
    @Test
    public void upLoadTesting() throws IOException {
        driver.get("https://practice.expandtesting.com/upload");
        ReusableMethods.bekle(4);

        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\sdlc\\pom.txt";


        WebElement uploadElement = driver.findElement(By.id("fileInput"));

        ReusableMethods.bekle(3);

        uploadElement.sendKeys(filePath);

        WebElement upLoadButton = driver.findElement(By.id("fileSubmit"));

        upLoadButton.click();

        WebElement alertBox = driver.findElement(By.id("uploaded-files"));
        File alertBoxScreenshot = alertBox.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(alertBoxScreenshot,new File("C:\\\\Users\\\\Hp\\\\OneDrive\\\\Desktop\\\\sdlc\\\\alertBoxScreenshot.png"));
        FileHandler.copy(alertBoxScreenshot, new File("C:\\Users\\Hp\\OneDrive\\Desktop\\alertBoxScreenshot.png"));
        //  "C:\\Users\\Hp\\OneDrive\\Desktop\\sdlc\\alertBoxScreenshot.png"

        boolean isDisplayed  = alertBox.isDisplayed();
        String uploadedFileName = alertBox.getText() ;
        alertBox.getText();

        System.out.println("dosya yükleme "+isDisplayed);

        System.out.println("dosya adı "+uploadedFileName);


            /*
            Assert.assertTrue(alertBox.isDisplayed());
            Assert.assertTrue(uploadedFileName.contains("pom.txt"));
            Assert.assertEquals(alertBox.getText(), "pom.txt");

            // siteye yuklenen dosya adı bire bir aynıysa
            Assert.assertEquals(alertBox.getText(), "pom.txt");
            // siteye eklenen dosyanın sonuna yada başına ekleme yapıyorsa
            Assert.assertTrue(uploadedFileName.contains("pom.txt"));

             */









        // uploadElement.sendKeys("\"C:\\\\Users\\\\Hp\\\\OneDrive\\\\Desktop\\\\sdlc\\\\ustundeYazi.png\"");

        //
        //// Yüklenecek dosyanın tam yolunu gönder (örneğin: C:\Users\kullanici\Desktop\dosya.txt)
        //uploadElement.sendKeys("C:\\Users\\kullanici\\Desktop\\dosya.txt");
        //
        //// (Eğer varsa) Yükleme butonuna tıklayın
        //driver.findElement(By.id("file-submit")).click();
    }

}


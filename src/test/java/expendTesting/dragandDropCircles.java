package expendTesting;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import screenShotBilgileri.ScreenshotWithText;
import utilities.BulXpath;
import utilities.ReusableMethods;
import utilities.ScreenShotUtil;
import utilities.TestBase;

import java.io.File;

public class dragandDropCircles {
    public static WebDriver driver ;
    @BeforeEach
    public void setUp(){
        driver = TestBase.createDriver();
    }
    @AfterEach
    public void tearDown(){
        ReusableMethods.bekle(3);
        driver.quit();
    }
    @Test
    public void dragAndDropCircles() throws Exception {
        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        WebElement targetBigKare =driver.findElement(By.xpath("//div[@id='target']"));


        WebElement redCircle = driver.findElement(By.xpath("//div[@class='red']"));




        WebElement greenCircle = driver.findElement(By.xpath("//div[@class='green']"));



        WebElement blueCircle = driver.findElement(By.xpath("//div[@class='blue']"));



        Actions actions = new Actions(driver);
        actions.dragAndDrop(redCircle, targetBigKare).perform();
        actions.dragAndDrop(greenCircle, targetBigKare).perform();
        actions.dragAndDrop(blueCircle, targetBigKare).perform();

        WebElement redCircles2 = driver.findElement(By.xpath("//div[@class='red']"));
        BulXpath.printXpathFormulas(redCircles2);

        WebElement greenCircles2 = driver.findElement(By.xpath("//div[@class='green']"));
        BulXpath.printXpathFormulas(greenCircles2);

        WebElement blueCircles2 = driver.findElement(By.xpath("//div[@class='blue']"));
        BulXpath.printXpathFormulas(blueCircles2);

        System.out.println("Rapor:");
        System.out.println("- Kırmızı daire büyük kareye taşındı.");
        System.out.println("- Yeşil daire büyük kareye taşındı.");
        System.out.println("- Mavi daire büyük kareye taşındı.");
        System.out.println("Tüm dairelerin taşınma işlemi başarıyla tamamlandı.");

        File elementScreenshot = targetBigKare.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementScreenshot, new File("element.png"));


        ScreenShotUtil.ekranGoruntusuAl(driver,
                "C:\\Users\\Hp\\OneDrive\\Desktop\\sdlc\\ekrangoruntusu.png");

        ScreenshotWithText.ekranGoruntusuUzerineYaziYaz(driver,
                "C:\\Users\\Hp\\OneDrive\\Desktop\\sdlc\\ustundeYazi.png",
                "Test Başarılı!");

    }

}

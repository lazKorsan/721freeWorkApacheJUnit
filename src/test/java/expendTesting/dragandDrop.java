package expendTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import static org.testng.AssertJUnit.assertEquals;

public class dragandDrop {
    public static WebDriver driver ;
    @BeforeEach
    public void setUP(){
        driver = TestBase.createDriver();
    }
    @AfterEach
    public void tearDown(){
        ReusableMethods.bekle(3);
    }
    @Test
    public void dragANDdrop() {
        driver.get("https://practice.expandtesting.com/drag-and-drop");

        WebElement kareA = driver.findElement(By.xpath("//*[@id='column-a']"));
        WebElement kareB = driver.findElement(By.xpath("//*[@id='column-b']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(kareA, kareB).perform();

        // Son durumları oku
        String textA = kareA.getText();
        String textB = kareB.getText();

        // Konsola anlamlı açıklama yazdır
        System.out.println("Drag&Drop işlemi sonrası:");
        System.out.println("A kutusunun içindeki yazı: " + textA);
        System.out.println("B kutusunun içindeki yazı: " + textB);

        // Yer değişti mi, insan gözüyle anlamlı çıktı
        if ("B".equals(textA) && "A".equals(textB)) {
            System.out.println("Başarılı: A ve B kutuları yer değiştirdi.");
        } else {
            System.out.println("Başarısız: Kutular beklenen şekilde yer değiştirmedi.");
        }

        // Otomasyon assertionları
        assertEquals("A", textB);
        assertEquals("B", textA);
        assertEquals("A", textB);
        assertEquals("B", textA);
        System.out.println("Test sonucu: " + (("B".equals(textA) && "A".equals(textB)) ? "Başarılı" : "Başarısız"));
    }

    }


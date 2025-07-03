package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil {
    public static void ekranGoruntusuAl(WebDriver driver, String dosyaYolu) {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(dosyaYolu));
            System.out.println("Ekran görüntüsü kaydedildi: " + dosyaYolu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // cağırılması
   // ScreenShotUtil.ekranGoruntusuAl(driver, "C:\\Users\\Hp\\OneDrive\\Desktop\\sdlc\\ekrangoruntusu.png");
}
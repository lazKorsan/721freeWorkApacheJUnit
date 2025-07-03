package screenShotBilgileri;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenshotWithText {
    public static void ekranGoruntusuUzerineYaziYaz(WebDriver driver, String dosyaYolu, String yazilacakMetin) throws Exception {
        // Screenshot al ve BufferedImage olarak oku
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(screenshot);

        // Yazı eklemek için Graphics2D kullan
        Graphics2D g2d = image.createGraphics();
        g2d.setFont(new Font("Arial", Font.BOLD, 48)); // Font ve boyut
        g2d.setColor(Color.RED); // Yazı rengi
        g2d.drawString(yazilacakMetin, 50, 100); // (x, y) koordinat ve metin

        g2d.dispose();

        // Yeni resmi dosyaya kaydet
        ImageIO.write(image, "png", new File(dosyaYolu));
        System.out.println("Yazılı ekran görüntüsü kaydedildi: " + dosyaYolu);
    }

}
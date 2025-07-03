package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class ZZZisDisplayed {
    private static final By LOGOUTBOX = By.xpath("//*[@id=\"flash\"]");
    public static boolean isLogoutBoxDisplayed(WebDriver driver) {
        WebElement verifyOTPcodeLogoutBox = driver.findElement(LOGOUTBOX);
        boolean isDisplayed = verifyOTPcodeLogoutBox.isDisplayed();
        System.out.println(isDisplayed); // Sonucu ekrana yazdırır (isteğe bağlı)
        return isDisplayed;

        // cağırmak için
        //  boolean result = ZZZisDisplayed.isLogoutBoxDisplayed(driver);
        //  assertTrue(result,"Logout kutusu görüntülenmiyor!" );

    }
}

package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class zzzAlertBoxService {

    private static final By SECURE_ALERT_BOX = By.xpath("//*[@id=\"flash\"]");

    public static boolean isSecureAreaMessageDisplayed(WebDriver driver, String expectedMessage) {
        String actualMessage = driver.findElement(SECURE_ALERT_BOX).getText();
        boolean result = expectedMessage.equals(actualMessage);
        System.out.println(result); // true veya false olarak yazdırır
        return result;
    }


}

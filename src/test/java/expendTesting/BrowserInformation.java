package expendTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utilities.*;

public class BrowserInformation {
    public static WebDriver driver ;
    @BeforeEach
    public void browserTest(){
        driver =TestBase.createDriver();
    }
    @AfterEach
    public void tearDown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }
    @Test
    public void browserinformaticion(){
        zzzURL.uuUrl_MyBrowserInformationPage(driver);
        zzzBox.bbbutton_showBrowser(driver);
        ReusableMethods.bekle(10);


    }
}

package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class zzzBox {

    private static final By USERNAME_BOX = By.xpath("(//input[@id='username'])[1]");
    private static final By PASSWORD_BOX = By.xpath("//input[@name='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id=\"login\"]/button");
    private static final By ALERT_BOX = By.xpath("//*[@id=\"flash\"]");
    private static final By REGISTER_USERNAME_BOX = By.xpath("//input[@id='username']");
    private static final By REGISTER_PASSWORD_BOX = By.xpath("//input[@id='password']");
    private static final By REGISTER_COMFIRM_PASSWORD_BOX = By.xpath("//input[@name='confirmPassword']");
    private static final By REGISTER_REGISTER_BOX = By.xpath("//*[@id=\"register\"]/button");
    private static final By FORGOT_PASSWORD_BOX = By.className("form-control");
    private static final By FORGOT_ALAERT_BOX = By.xpath("//*[@id=\"confirmation-alert\"]") ;
    private static final By OTP_EMAIL_BOX = By.xpath("//*[@id=\"email\"]");
    private static final By OTP_VERTIFICATION_BOX =By.xpath("//*[@id=\"otp\"]") ;
    private static final By BUTTON_SHOW_BROWSER_INFORMATION = By.xpath("//*[@id=\"browser-toggle\"]") ;

    public static void bbbutton_showBrowser(WebDriver driver){
        WebElement BUTTONshowBrowserInformation = driver.findElement(BUTTON_SHOW_BROWSER_INFORMATION);
        BUTTONshowBrowserInformation.click();
    }
    public static void otp_vertificationBOX(WebDriver driver,String keyword){
        WebElement otp_vertificationBox=driver.findElement(OTP_VERTIFICATION_BOX);
        otp_vertificationBox.clear();
        otp_vertificationBox.sendKeys(keyword);
    }


    public static void otp_emailBox(WebDriver driver ,String keyword){
        WebElement otp_emailBox =driver.findElement(OTP_EMAIL_BOX);
        otp_emailBox.clear();
        otp_emailBox.sendKeys(keyword);
    }

    public static void forgotAlertBox (WebDriver driver ,String expectedMessage){
        String actualMessage = driver.findElement(FORGOT_ALAERT_BOX).getText();
        assertEquals(expectedMessage, actualMessage);
    }

    public static void forgotPasswordBOX(WebDriver driver,String keyword){
        WebElement forgotPassWordBox= driver.findElement(FORGOT_PASSWORD_BOX) ;
        forgotPassWordBox.clear();
        forgotPassWordBox.sendKeys(keyword);
    }

    public static void register_Register_Box(WebDriver driver){

        driver.findElement(REGISTER_REGISTER_BOX).click();
    }

    public static void registerComfirmPasswordBox(WebDriver driver, String keyword) {
        WebElement registerComfirmPasswordBox = driver.findElement(REGISTER_COMFIRM_PASSWORD_BOX);
        registerComfirmPasswordBox.clear();
        registerComfirmPasswordBox.sendKeys(keyword);
    }
    public static void registerPasswordBox(WebDriver driver, String keyword) {
        WebElement registerPasswordBox = driver.findElement(REGISTER_PASSWORD_BOX);
        registerPasswordBox.clear();
        registerPasswordBox.sendKeys(keyword);
    }

    public static void registerSendName(WebDriver driver, String keyword) {
        WebElement registerUserNameBOX = driver.findElement(REGISTER_USERNAME_BOX);
        registerUserNameBOX.clear();
        registerUserNameBOX.sendKeys(keyword);
    }
    // (//input[@id='username'])[1]

    public static void sendName(WebDriver driver, String keyword) {
        WebElement userNameBox = driver.findElement(USERNAME_BOX);
        userNameBox.clear();
        userNameBox.sendKeys(keyword);
    }
    public static void sendPassword(WebDriver driver, String keyword) {
        WebElement passwordBox = driver.findElement(PASSWORD_BOX);
        passwordBox.clear();
        passwordBox.sendKeys(keyword);
    }
    public static void loginButton(WebDriver driver ) {
        WebElement loginKutusu = driver.findElement(LOGIN_BUTTON);
        loginKutusu.click();
    }
    // 1. Yöntem: Doğrulamayı direkt yapan method
    public static void verifyInvalidPasswordMessage(WebDriver driver, String expectedMessage) {
        String actualMessage = driver.findElement(ALERT_BOX).getText();
        assertEquals(expectedMessage, actualMessage);
        // cagırma
        // loginPageForm.verifyInvalidPasswordMessage(driver, "Your password is invalid!");
    }

    // 2. Yöntem: Sadece mesajı döndüren method
    public static String getAlertMessage(WebDriver driver) {
        return driver.findElement(ALERT_BOX).getText();
    }



}

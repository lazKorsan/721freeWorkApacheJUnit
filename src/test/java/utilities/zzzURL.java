package utilities;

import org.openqa.selenium.WebDriver;

public class zzzURL {

    public static String uuUrl_MyBrowserInformationPage(WebDriver driver){
        String myBrowserInformationPage = " https://practice.expandtesting.com/my-browser    " ;
        driver.get(myBrowserInformationPage);
        return myBrowserInformationPage ;
    }




    public static String loginexercises(WebDriver driver){
        String loginexercisesCases = "  https://practice.expandtesting.com/test-cases/login " ;
        driver.get(loginexercisesCases);
        return loginexercisesCases;
        // çağırılması
        // driver.get(UrlPE.expandtesting2(driver));
    }
    public static String registerPage(WebDriver driver){
        String registerPageExcercises = "  https://practice.expandtesting.com/register " ;
        driver.get(registerPageExcercises);
        return registerPageExcercises;
        // çağırılması
        // driver.get(UrlPE.expandtesting2(driver));
    }



}

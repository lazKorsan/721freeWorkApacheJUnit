package day05_maven_JunitFramework;

import org.junit.jupiter.api.Test;
import utilities.BrowserUtils.UrlTestUtils;

public class C03_testNotasyonuMetodluYapayZeka {

    @Test
    public void testOtomasyonuTesti() {
        UrlTestUtils.runUrlContentTest(
                "https://www.testotomasyonu.com",
                "testotomasyonu",
                "Test Otomasyonu URL Testi"
        );
    }
    @Test
    public void youtube(){
        UrlTestUtils.runUrlContentTest(
                "https://www.youtube.com",
                "youtube",
                "youtube Url Tesi"
        );
    }
}
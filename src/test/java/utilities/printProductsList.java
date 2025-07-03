// TestUtils.java
package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class printProductsList {

    public static void printProductsInCategory(WebDriver driver, String categoryUrl, String productLocator) {
        driver.get(categoryUrl);
        List<WebElement> products = driver.findElements(By.xpath(productLocator));

        System.out.println("Ürün sayısı: " + products.size());
        System.out.println("Ürünler:");
        for (WebElement urun : products) {
            System.out.println(urun.getText());
        }
    }
}


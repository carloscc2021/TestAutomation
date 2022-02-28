package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

@Test
public class ListaDespegar {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/home/carlos/Documents/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.despegar.com.ar/");
        Thread.sleep(500);
        List<WebElement> lista = driver.findElements(By.xpath("//label[@class='button-circle-label']"));
        for (int i = 0; i < lista.size(); i++){
        System.out.println(lista.get(i).getText());
        Assert.assertTrue(lista.get(i).isDisplayed());
        Thread.sleep(500);
        }
        driver.quit();
    }
}

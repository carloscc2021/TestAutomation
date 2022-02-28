package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class WikiTests1 {

        @Test(description = "Validar que las busquedas en Wikipedia funcionan")
        public void ValidarBusquedaWikipedia() throws Exception {
            System.setProperty("webdriver.chrome.driver", "/home/carlos/Documents/drivers/chrome/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("http://wikipedia.org");
            Thread.sleep(1000);
            WebElement searchInput = driver.findElement(By.id("searchInput"));
            Assert.assertTrue(searchInput.isDisplayed());
            searchInput.sendKeys("Selenium");
            Thread.sleep(1000);
            searchInput.submit();
            WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
            Assert.assertTrue(tituloResultado.isDisplayed());
            Thread.sleep(2000);
            driver.close();

        }
    }

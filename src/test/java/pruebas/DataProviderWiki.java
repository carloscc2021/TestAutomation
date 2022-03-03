package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWiki {

    @DataProvider(name = "Data Provider Wikipedia")
    public Object[][] dbMethod() {
        return new Object[][] {{"Selenium"}, {"Java"}, {"TestNG"}};
    }

    @Test(dataProvider = "Data Provider Wikipedia", description = "Validar que las busquedas en Wikipedia funcionan")
    public void ValidarBusquedaWikipedia(String parametroDataProvider) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/carlos/Documents/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://wikipedia.org");
        Thread.sleep(500);

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        Assert.assertTrue(searchInput.isDisplayed());
        searchInput.sendKeys(parametroDataProvider);
        Thread.sleep(1000);
        searchInput.submit();

        WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
        Assert.assertTrue(tituloResultado.isDisplayed());
        Thread.sleep(2000);
        driver.close();

    }
}

package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.Test;


@Test()
public class primera_prueba {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/home/carlos/Documents/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.despegar.com.ar/");
        Thread.sleep(500);
        WebElement alojamiento = driver.findElement(By.xpath("//i[@title='Alojamientos']"));
        Assert.assertTrue(alojamiento.isDisplayed());
        alojamiento.click();
        Thread.sleep(500);
        WebElement destino = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox5-box-places-ovr.sbox-places-container--3kBK7 > div > div > div > input"));
        Assert.assertTrue(destino.isDisplayed());
        Thread.sleep(500);
        destino.sendKeys("Necochea, Buenos Aires, Argentina");
        Thread.sleep(500);
        WebElement fechaDesde = driver.findElement(By.xpath("//input[@placeholder='Entrada']"));
        Assert.assertTrue(fechaDesde.isDisplayed());
        fechaDesde.click();
        Thread.sleep(2000);
        WebElement fechaIda = driver.findElement(By.xpath("(//div[contains(.,'2')])[165]"));
        Assert.assertTrue(fechaIda.isDisplayed());
        fechaIda.click();
        Thread.sleep(2000);
        WebElement fechaVuelta = driver.findElement(By.xpath("(//div[contains(.,'16')])[30]"));
        Assert.assertTrue(fechaVuelta.isDisplayed());
        fechaVuelta.click();
        Thread.sleep(500);
        WebElement habitaciones = driver.findElement(By.cssSelector("div.sbox5-3-double-input:nth-child(2)"));
        Assert.assertTrue(habitaciones.isDisplayed());
        habitaciones.click();
        Thread.sleep(500);
        WebElement adulto = driver.findElement(By.xpath("//*[@id=\"component-modals\"]/div[5]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]"));
        Assert.assertTrue(adulto.isDisplayed());
        adulto.click();
        Thread.sleep(500);
        WebElement menor = driver.findElement((By.xpath("(//button[@class='steppers-icon-right stepper__icon'])[4]")));
        Assert.assertTrue(menor.isDisplayed());
        menor.click();
        Thread.sleep(500);
        WebElement sel = driver.findElement(By.xpath("//select[@class='select']"));
        Assert.assertTrue(sel.isDisplayed());
        Thread.sleep(500);
        sel.click();
        Select select = new Select(sel);
        select.selectByValue("6");
        Thread.sleep(500);
        WebElement buscar = driver.findElement(By.xpath("//em[@class='btn-text'][contains(.,'Buscar')]"));
        Assert.assertTrue(buscar.isDisplayed());
        buscar.click();
        Thread.sleep(500);
        driver.quit();

    }
}

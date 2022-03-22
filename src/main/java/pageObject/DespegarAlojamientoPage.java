package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DespegarAlojamientoPage {

    @FindBy(xpath = "//input[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
    WebElement destino;
    @FindBy(xpath = "//input[@placeholder='Entrada']")
    WebElement fechaDesde;
    @FindBy(xpath = "(//div[contains(.,'2')])[165]")
    WebElement fechaIda;
    @FindBy(xpath = "(//div[contains(.,'16')])[30]")
    WebElement fechaVuelta;
    @FindBy(css = "div.sbox5-3-double-input:nth-child(2)")
    WebElement habitaciones;
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[5]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]")
    WebElement adulto;
    @FindBy(xpath = "(//button[@class='steppers-icon-right stepper__icon'])[4]")
    WebElement menor;
    @FindBy(xpath = "//select[@class='select']")
    WebElement sel;
    @FindBy(css = "em.btn-text")
    WebElement aplicar;
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div[2]/button/em")
    WebElement buscar;

    private WebDriver driver = null;

    public DespegarAlojamientoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait wait(WebElement locator) {
        return this.wait(locator);
    }

    public DespegarResultPage alojamientos(String ciudad) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(destino));
        destino.click();
        destino.clear();
        Thread.sleep(2000);
        destino.sendKeys(ciudad);
        Thread.sleep(500);
        destino.sendKeys(Keys.TAB);

        wait.until(ExpectedConditions.visibilityOf(fechaDesde));
        fechaDesde.click();

        wait.until(ExpectedConditions.visibilityOf(fechaIda));
        fechaIda.click();

        fechaVuelta.click();
        wait.until(ExpectedConditions.visibilityOf(fechaVuelta));

        habitaciones.click();

        wait.until(ExpectedConditions.visibilityOf(adulto));
        adulto.click();

        menor.click();
        wait.until(ExpectedConditions.visibilityOf(menor));

        wait.until(ExpectedConditions.elementToBeClickable(sel));
        sel.click();

        Select select = new Select(sel);
        select.selectByValue("6");
        sel.sendKeys(Keys.ESCAPE);

        wait.until(ExpectedConditions.visibilityOf(aplicar));
        aplicar.click();

        buscar.click();

        return new DespegarResultPage(this.driver);
    }
}

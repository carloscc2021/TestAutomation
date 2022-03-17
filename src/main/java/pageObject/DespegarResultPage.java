package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarResultPage {
    @FindBy(css = "div.eva-3-results-list.-banner-top")
    WebElement primeraBusqueda;

    @FindBy(xpath = "(//span[@class='accommodation-name -eva-3-ellipsis'])[1]")
    WebElement nombreHotel;

    private WebDriver driver = null;

    public DespegarResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean PrimeraBusqueda() {
        return this.primeraBusqueda.isDisplayed();
    }
    public void NombreHotel() {
        System.out.println("Nombre hotel: " + nombreHotel.getText());
    }
}

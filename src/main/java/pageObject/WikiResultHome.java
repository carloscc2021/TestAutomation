package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiResultHome {
    @FindBy(id = "firstHeading")
    WebElement titulo;

    private  WebDriver driver = null;

    public WikiResultHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean tituloEsVisible() {
        return this.titulo.isDisplayed();
    }
}

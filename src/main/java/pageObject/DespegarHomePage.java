package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarHomePage {
    @FindBy(xpath = "//i[@title='Alojamientos']")
    WebElement alojamientos;

    private WebDriver driver = null;

    public DespegarHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean DespegarVisible() {
        return this.alojamientos.isDisplayed();
    }

    public DespegarAlojamientoPage iraAlojamiento() {
        this.alojamientos.click();
        return new DespegarAlojamientoPage(this.driver);
    }
}

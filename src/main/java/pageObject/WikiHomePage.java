package pageObject;

import until.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage extends BaseTest {
    @FindBy(id = "searchInput")
    WebElement searchInput;
    private WebDriver driver = null;

    public WikiHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean searchInputIsVisible() {
        return this.searchInput.isDisplayed();
    }
    public WikiResultHome searchInput(String text) {
        this.searchInput.sendKeys(text);
        searchInput.submit();

        return new WikiResultHome(this.driver);
    }
}


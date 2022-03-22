package until;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    private WebDriver driver;

    public static void gotoMainPageWiki(WebDriver driver) {
        driver.get("http://wikipedia.org");
    }

    public static void gotoMainPageDespegar(WebDriver driver) {
        driver.get("https://www.despegar.com.ar/");
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "/home/carlos/Documents/drivers/chrome/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver iniciarBrowser(String browserName) {
        WebDriver driver = null;

        switch (browserName) {

            case "FIREFOX": {
                System.setProperty("webdriver.gecko.driver", ".drivers/firefox/geckodriver");
                driver = new FirefoxDriver();
                break;
            }
            /*case "CHROME": {
                System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver");
                driver = new ChromeDriver();
                break;
            }*/

            default: {
                System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver");
                driver = new ChromeDriver();
                break;
            }
        }
        return driver;

    }
}

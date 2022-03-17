package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.WikiHomePage;
import pageObject.WikiResultHome;
import until.BaseTest;

public class WikiTest extends BaseTest {
        private WebDriver driver = null;

        @BeforeMethod
        public void setup(ITestContext context) {
            String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
            String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
            driver = BaseTest.iniciarBrowser(navegador);
            BaseTest.gotoMainPageWiki(driver);

        }

        @Test(dataProvider = "buscar")
        public void ValidarBusquedaWikiPedia(String Busqueda) throws Exception {
            WikiHomePage homePage = new WikiHomePage(driver);
            Assert.assertTrue(homePage.searchInputIsVisible());
            WikiResultHome resultPage = homePage.searchInput(Busqueda);
            Assert.assertTrue(resultPage.tituloEsVisible());
        }

        @AfterMethod
        public void endSetup() {
            driver.close();
        }

        @DataProvider(name = "buscar")
        public Object[][] getData() {
            return new Object[][] { { "Selenium" }, { "java" }, { "python" } };

        }
    }

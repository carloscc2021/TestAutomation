package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.WikiHomePage;
import pageObject.WikiResultsPage;
import until.BaseTest;

public class WikiTest1 extends BaseTest {
        private WebDriver driver = null;

        @BeforeMethod
        public void setup(ITestContext context) {
            String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
            String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
            driver = BaseTest.iniciarBrowser(navegador);
            BaseTest.gotoMainPageWiki(driver);

        }

        @Test(dataProvider = "buscar")
        public void testBusquedaWikiPedia(String busqueda) throws Exception {
            WikiHomePage homePage = new WikiHomePage(driver);
            Assert.assertTrue(homePage.searchInputIsVisible());
            WikiResultsPage resultPage = homePage.searchText(busqueda);
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

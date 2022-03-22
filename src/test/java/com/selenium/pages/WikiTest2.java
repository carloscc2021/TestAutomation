package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.WikiHomePage;
import pageObject.WikiResultsPage;

import until.BaseTest;

public class WikiTest2 extends BaseTest {
    private WebDriver driver = null;

    @BeforeClass
    public void setup(ITestContext context) {
        String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
        String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
        driver = BaseTest.iniciarBrowser(navegador);
        BaseTest.gotoMainPageWiki(driver);
    }

    @Test
    public void ValidarBusquedaWikiPedia() {
        WikiHomePage homePage = new WikiHomePage(driver);
        Assert.assertTrue(homePage.searchInputIsVisible());
        WikiResultsPage resultPage = homePage.searchText("Selenium");
        Assert.assertTrue(resultPage.tituloEsVisible());
    }

    @AfterClass
    public void endSetup() {
        driver.close();
    }
}

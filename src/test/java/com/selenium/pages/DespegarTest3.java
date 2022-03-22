package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.DespegarAlojamientoPage;
import pageObject.DespegarHomePage;
import pageObject.DespegarResultPage;
import until.BaseTest;

public class DespegarTest3 extends BaseTest {

    private WebDriver driver = null;

    @BeforeMethod(alwaysRun=true)
    public void setup(ITestContext context) {
        String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
        String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
        driver = BaseTest.iniciarBrowser(navegador);
        BaseTest.gotoMainPageDespegar(driver);

    }

    @Test(groups= {"group3"}, description = "Validar busqueda en Despegar y mostrar nombre del primer hotel")
    public void Alojamiento() throws InterruptedException {
        DespegarHomePage homePage = new DespegarHomePage(driver);
        Assert.assertTrue(homePage.DespegarVisible());
        homePage.iraAlojamiento();
        DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(driver);
        alojamiento.alojamientos("Necochea, Buenos Aires, Argentina");
        DespegarResultPage result = new DespegarResultPage(driver);
        Assert.assertTrue(result.PrimeraBusqueda());
        result.NombreHotel();
    }

    @AfterMethod(alwaysRun=true)
    public void endSetup() {
        driver.close();
    }
}

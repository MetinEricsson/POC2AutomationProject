package Pages;

import BaseFiles.DriverManager;
import BaseFiles.TestBase;
import ExtendReport.ExtendReportMethods;
import GeneralFiles.BasePage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class MainPage extends BasePage {

    private static By contacCenterMenu_Btn= By.xpath("//p[text()='Contact Center']");

    ExtendReportMethods reporter=new ExtendReportMethods();

    public MainPage openMainPage(){

        try {
            DriverManager.getDriver().navigate().to(TestBase.BASEURL);
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(120L, TimeUnit.SECONDS);
            reporter.Report_Info("Web sayfasi basarili bir sekilde acilmistir. URL: "+ TestBase.BASEURL);

        }catch (Exception e){
            reporter.Report_Fail("Sayfa acilamamistir! Detay: "+e.getMessage());
        }
        return this;
    }

    public MainPage contactCenterMenuSec(){

        try {
            waitElementWithThreadSleep(contacCenterMenu_Btn,5);
            clickElement(contacCenterMenu_Btn);
            reporter.Report_Info("Contact Center tabi secilmistir.");
        }catch (Exception e){
            reporter.Report_Fail("Contact Center tabinda hata alinmistir! Detay: "+e.getMessage());
        }
        return this;
    }






}

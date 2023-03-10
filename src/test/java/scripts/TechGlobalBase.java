package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class TechGlobalBase {
    WebDriver driver;
    SoftAssert softAssert;

    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicElementsPage techGlobalDynamicElementsPage;
    TechGlobalRadioButtonsPage techGlobalRadioButtonsPage;
    TechGlobalCheckBoxPage techGlobalCheckBoxPage;
    TechGlobalDropdownsPage techGlobalDropdownsPage;
    TechGlobalMultipleWindowsPage techGlobalMultipleWindowsPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalWaitsPage techGlobalWaitsPage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalIFramesPage techGlobalIFramesPage;
    TechGlobalFileUploadPage techGlobalFileUploadPage;
    TechGlobalFileDownloadPage techGlobalFileDownloadPage;
    TechGlobalStaticTablesPage techGlobalStaticTablesPage;
    TechGlobalCalendarPage techGlobalCalendarPage;
    TechGlobalSortableTablesPage techGlobalSortableTablesPage;
    TechGlobalActionsPage techGlobalActionsPage;
    Actions actions;
    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("appURL"));

       techGlobalBasePage =new TechGlobalBasePage();
    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean up
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
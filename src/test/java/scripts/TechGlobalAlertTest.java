package scripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalAlertTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Alerts");
    }

    /**
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Alerts" card
    Click on "Warning alert" button
    Validate the alert text equals "You are on TechGlobal Training application."
    Click on "OK" button on the alert
    Validate the result message equals "You accepted warning by clicking OK."
     */

    @Test(priority = 1, description = "Validate warning alert")
    public void warningAlert() {


        techGlobalAlertsPage.clickOnAlert("Warning alert");
        // Switching to alert
        Alert alert = driver.switchTo().alert();

        //Validate the alert text
        Assert.assertEquals(alert.getText(), "You are on TechGlobal Training application.");

        //Confirming the alert button
        alert.accept();

        //Validate the result text
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You accepted warning by clicking OK.");
    }

    /**
    Go to https://techglobal-training.netlify.app/
Click on "Practices" dropdown in the header
Select the "Frontend Testing" option
Click on the "Alerts" card
Click on "Confirmation alert" button
Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
Click on "Cancel" button on the alert
Validate the result message equals "You rejected the alert by clicking Cancel."
Click on "Confirmation alert" button again
Click on "OK" button on the alert
Validate the result message equals "You confirmed the alert by clicking OK."
     */

    @Test(priority = 2, description = "Validate Confirmation alert")
    public void confirmationAlert() {

        techGlobalAlertsPage.clickOnAlert("Confirmation alert");
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Would you like to stay on TechGlobal Training application?");
        alert.dismiss();
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You rejected the alert by clicking Cancel.");
        Waiter.pause(3);

        techGlobalAlertsPage.clickOnAlert("Confirmation alert");
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You confirmed the alert by clicking OK.");
    }








}

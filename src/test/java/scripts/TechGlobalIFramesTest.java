package scripts;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIFramesPage;

import java.util.stream.IntStream;


public class TechGlobalIFramesTest extends TechGlobalBase {


    @BeforeMethod
    public void setPage() {

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIFramesPage = new TechGlobalIFramesPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");
    }


    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “IFrames” card
     * Validate the “Please fill out your information below” text
     */


    @Test(priority = 1, description = "Validating input header text")
    public void validateInputText() {

        driver.switchTo().frame(techGlobalIFramesPage.iframe);
        Assert.assertTrue(techGlobalIFramesPage.inputHeaderText.isDisplayed());
        Assert.assertEquals(techGlobalIFramesPage.inputHeaderText.getText(), "Please fill out your information below");

    }


    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “IFrames” card
     * Enter “John” to first name input box
     * Enter “Doe” to last name input box
     * Click on “SUBMIT” button
     * Validate the result equals “You entered: John Doe”
     */


    @Test(priority = 2, description = "Validate result text")
    public void validateResultText() {

        driver.switchTo().frame(techGlobalIFramesPage.iframe);

        String[] credentials = {"John", "Doe"};

        IntStream.range(0, credentials.length).forEach(i ->
                techGlobalIFramesPage.InputBoxs.get(i).sendKeys(credentials[i]));


        techGlobalIFramesPage.submitButton.click();
        driver.switchTo().parentFrame();

        Assert.assertEquals(techGlobalIFramesPage.result.getText(), "You entered: " + credentials[0] + " " + credentials[1]);
    }








}





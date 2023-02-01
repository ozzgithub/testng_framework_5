package scripts;

import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.time.Duration;

public class TechGlobalActionsTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalActionsPage = new TechGlobalActionsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Actions");
        actions = new Actions(driver);
    }


    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled as "Click on me"
     * Verify that  message appears next of the element stating "You clicked on a button!"
     * Perform a right click action on the second web element labeled as "Right-Click on me""
     * Verify that  message appears next of the element stating "You right-clicked on a button!"
     * Perform a double click action on the third web element labeled as "Double-Click on me"
     * Verify that  message appears next of the element stating "You double-clicked on a button!"
     */


    @Test(priority = 1, description = "Click first 3 boxes and validate the result")
    public void clickActions() {

        actions.moveToElement(techGlobalActionsPage.clickBox).click().perform();
        Assert.assertEquals(techGlobalActionsPage.clickResult.getText(), "You clicked on a button!");

        actions.moveToElement(techGlobalActionsPage.rightClickBox).contextClick().perform();
        Assert.assertEquals(techGlobalActionsPage.rightClickResult.getText() , "You right-clicked on a button!");

        actions.moveToElement(techGlobalActionsPage.doubleClickBox).doubleClick().perform();
        Assert.assertEquals(techGlobalActionsPage.doubleClickResult.getText(), "You double-clicked on a button!");

    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the  web element stating "An element dropped here!"
     */

    @Test(priority = 2, description = "Validate last two web elements")
    public void clickActions2() {

//
//        actions.moveToElement(techGlobalActionsPage.DragMeBox).
//               clickAndHold().moveToElement(techGlobalActionsPage.dropHereBox).release().perform();

        actions.dragAndDrop(techGlobalActionsPage.DragMeBox, techGlobalActionsPage.dropHereBox).perform();

        Waiter.waitForVisibilityOfElement(techGlobalActionsPage.dragAndDropResult, 10);
        Assert.assertEquals(techGlobalActionsPage.dragAndDropResult.getText(), "An element dropped here!");

    }





    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “Hello” to search input box
     * Validate value attribute is “Hello”
     */
    @Test(priority = 3, description = "Keyword actions")
    public void keywordActions() {

        actions.keyDown(Keys.SHIFT).
                sendKeys(techGlobalActionsPage.inputBox, "h")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .sendKeys("ello")
                .pause(Duration.ofSeconds(2)).perform();
       Assert.assertEquals(techGlobalActionsPage.inputBox.getAttribute("value"), "Hello");

    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “techglobal” to input box with uppercases
     * Validate the value attribute for search input box is “TECHGLOBAL”
     * Then, copy the text and paste again
     * Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test(priority = 4, description = "Keyword actions 2")
    public void keywordActions2() {

        actions.keyDown(Keys.SHIFT).
                sendKeys(techGlobalActionsPage.inputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .pause(Duration.ofSeconds(2))
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND)
                .sendKeys("v").pause(Duration.ofSeconds(2))
                .perform();



        Assert.assertEquals(techGlobalActionsPage.inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");





    }






}

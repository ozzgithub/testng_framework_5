package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalRadioButtonsPage;
import utilities.Waiter;

public class TechGlobalRadioButtonsTest extends TechGlobalBase{


     /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Radio Buttons" card
    Validate "Java", "JavaScript" and "C#" radio buttons are displayed, enabled and not selected
    Select "Java" and validate it is selected but the other 2 are deselected
    Select "JavaScript" validate it is selected but the other 2 are deselected
     */

    @BeforeMethod
    public void setPage(){

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalRadioButtonsPage = new TechGlobalRadioButtonsPage();
    }

    @Test(priority = 1, description = "Validate TechGlobal Language Radio Buttons")
    public void languageRadioButtons() {

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(5);

        for (int i = 0; i < techGlobalRadioButtonsPage.radioButtonLabel.size(); i++) {

            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonLabel.get(i).isDisplayed());
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonLabel.get(i).isEnabled());
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput.get(i).isSelected());


        }


        techGlobalRadioButtonsPage.radioButtonLabel.get(0).click();
        Waiter.pause(3);

        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonInput.get(0).isSelected());


        for (int i = 1; i < techGlobalRadioButtonsPage.radioButtonInput.size(); i++) {

            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput.get(i).isSelected());

        }

        techGlobalRadioButtonsPage.radioButtonLabel.get(1).click();
        Waiter.pause(3);

        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonInput.get(1).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput.get(0).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput.get(2).isSelected());


    }

        /*
        Go to https://techglobal-training.netlify.app/
        Click on "Practices" dropdown in the header
        Select the "Frontend Testing" option
        Click on the "Radio Buttons" card
        Validate "Selenium", "Cypress" and "Playwright" radio buttons are displayed, enabled and not selected
        Select "Cypress" and validate it is selected but the other 2 are deselected
        Select "Playwright" validate it is selected but the other 2 are deselected
         */




        @Test(priority = 2, description = "Validate TechGlobal Language Practice")
        public void languageRadioButtons2(){

                techGlobalFrontendTestingHomePage.getFrontendTestingPage();
                techGlobalFrontendTestingHomePage.clickOnCard(5);

                for(int i = 0; i < techGlobalRadioButtonsPage.radioButtonLabel2.size();i++) {

                    Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonLabel2.get(i).isDisplayed());
                    Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonLabel2.get(i).isEnabled());
                    Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput2.get(i).isSelected());

                }

            techGlobalRadioButtonsPage.radioButtonLabel2.get(1).click();
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonInput2.get(1).isSelected());

            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput2.get(0).isSelected());
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput2.get(2).isSelected());


            techGlobalRadioButtonsPage.radioButtonLabel2.get(2).click();
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonInput2.get(2).isSelected());

            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput2.get(0).isSelected());
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonInput2.get(1).isSelected());



        }









        }



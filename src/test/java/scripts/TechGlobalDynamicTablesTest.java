package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalDynamicTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage() {


        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dynamic Tables");
    }


    @Test(priority = 1, description = "pop up validation")
    public void popupValidation() {

        /**
         Go to https://techglobal-training.netlify.app/
         Click on "Practices" dropdown in the header
         Select the "Frontend Testing" option
         Click on the "Dynamic Tables" card
         Click on the "ADD PRODUCT" button
         Validate the modal title equals "Add New Product"
         */


        techGlobalDynamicTablesPage.addProductButton.click();
        Waiter.pause(3);
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCard.getText(), "Add New Product");
    }
}

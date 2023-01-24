package scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalBasePage;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;

public class TechGlobalDropdownsTest extends TechGlobalBase {


    @BeforeMethod
    public void setPage() {

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropdownsPage = new TechGlobalDropdownsPage();


        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");

    }

    /*

     */

    @Test(priority = 1, description = "Select Delivery Options")
    public void selectDeliveryOption(){

        DropdownHandler.clickOnDropdownOptions(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions,
                "Delivery");

        Waiter.pause(5);


    }



    @Test(priority = 2, description = "Select iPhone 14 Pro Max option")
    public void selectProductOption() {

    //    Select select = new Select(techGlobalDropdownsPage.productDropdown);

     //   select.selectByVisibleText("iPhone 14 Pro Max");
    //   select.selectByVisibleText("MacBook Pro 13");

//        for(WebElement element : select.getOptions()){
//            System.out.println(element.getText());
//        }

       DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.productDropdown, "iPhone 14 Pro Max");


        Waiter.pause(5);
    }


    @Test(priority = 3, description = "Select Yellow option")
    public void selectColorOption(){

     DropdownHandler.selectByIndex(techGlobalDropdownsPage.colorDropdown, 1);
        Waiter.pause(5);
    }


    /*
    Go to TechGlobal Training app
    Select Frontend Testing from Practices Dropdown
    Select Dropdowns card
    Select "MacBook Pro 13" option from product dropdown
    Select "Silver" option from the color dropdown
    Select "Delivery" option from devivery dropdown
    Click on SUBMIT button
    Validate "Your Silver MacBook Pro 13 will be delivered to you." message
     */


    @Test(priority = 4, description = "Validate the selected item message")
    public void validateTheItemSelected() {

        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.productDropdown, "MacBook Pro 13");
        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.colorDropdown, "Silver");
        DropdownHandler.clickOnDropdownOptions(techGlobalDropdownsPage.deliveryDropdown, techGlobalDropdownsPage.deliveryDropdownOptions, "Delivery");

        techGlobalDropdownsPage.submitButton.click();

        Assert.assertEquals(techGlobalDropdownsPage.resultMessage.getText(),"Your Silver MacBook Pro 13 will be delivered to you.");
    }




}

package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalMultipleWindowsPage;
import utilities.Waiter;
import utilities.WindowHandler;

public class TechGlobalMultipleWindowsTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalMultipleWindowsPage = new TechGlobalMultipleWindowsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Multiple Windows");

    }

    @Test(priority = 1, description = "Validate the Apple link")
    public void validateAppleLink() {

        Waiter.pause(2);

        // 1 window/ tabs

        techGlobalMultipleWindowsPage.links.get(0).click();
        WindowHandler.switchToChildWindow();


        Assert.assertEquals(driver.getTitle(), "Apple");
        driver.close();

        WindowHandler.switchBackToParentWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));
    }


    @Test(priority = 2, description = "Validate link urls")
    public void validateLinkURL() {



        String[] url = {"https://www.apple.com/", "https://www.microsoft.com/en-ca/", "https://www.tesla.com/"};

        for (int i = 0; i < techGlobalMultipleWindowsPage.links.size(); i++) {

            techGlobalMultipleWindowsPage.links.get(i).click();

            WindowHandler.switchToChildWindow();

            Assert.assertEquals(driver.getCurrentUrl(), url[i]);

            driver.close();
            WindowHandler.switchBackToParentWindow();



        }
    }
}

package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalCalendarPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalCalendarTest extends TechGlobalBase{


    @BeforeMethod
    public void setPage() {

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalCalendarPage = new TechGlobalCalendarPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Calendar");
    }


   @Test(priority = 1, description = "Validate data picker")
    public void ValidateDatePicker() {

        techGlobalCalendarPage.calendarButton.click();

        techGlobalCalendarPage.navigateToYearAndMonth(2024, "May");

       Waiter.pause(3);

        techGlobalCalendarPage.clickOnDate(16);

       Assert.assertEquals(techGlobalCalendarPage.result.getText(), "You have selected Thu  May 16 2024.");
   }
}





package scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFileDownloadPage;
import pages.TechGlobalFrontendTestingHomePage;

public class TechGlobalFileDownloadTest extends TechGlobalBase{


    @BeforeMethod
    public void setPage() {

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFileDownloadPage = new TechGlobalFileDownloadPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("File Download");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “File Download” card
     * Click on the “TechGlobal School.pptx” file
     */

    @Test(priority = 1, description = "Validate download file")
    public void validateDownloadFile() {

        techGlobalFileDownloadPage.fileDownload.click();
    }
}

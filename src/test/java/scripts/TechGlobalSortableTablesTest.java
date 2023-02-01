package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalSortableTablesPage;
import utilities.TableHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalSortableTablesTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalSortableTablesPage = new TechGlobalSortableTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Sortable Tables");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Quantity sort button to toggle Ascending Order
     * Verify that the Quantity column of the table is sorted in ascending order
     */

    @Test(priority = 1, description = "Sort table by asc and validate it's sorted by quantity")
    public void validateSortAscByQuantity() {
        techGlobalSortableTablesPage.ascByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(driver, 1);
        List<Integer> quantityColumn = new ArrayList<>();

        for (WebElement element : quantityColumnElements) {
            quantityColumn.add((Integer.parseInt(element.getText())));
        }

        IntStream.range(1, quantityColumn.size()).forEach(i ->{
            Assert.assertTrue(quantityColumn.get(i) <= quantityColumn.get(i - 1));

        } );
    }


    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Quantity sort button to toggle descending order
     * Verify that the Quantity column of the table is sorted in descending order
     */

    @Test(priority = 2, description = "Sort table by descending and validate it's sorted by quantity")
    public void ValidateSortDesQuantity() {

        techGlobalSortableTablesPage.descByQuantity.click();
        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(driver, 1);
        List<Integer> quantityColumn = new ArrayList<>();
        for (WebElement element : quantityColumnElements) {
            quantityColumn.add((Integer.parseInt(element.getText())));
        }
        IntStream.range(1, quantityColumn.size()).forEach(i ->{
            Assert.assertTrue(quantityColumn.get(i) <= quantityColumn.get(i - 1));

        } );
    }




    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Price sort button to toggle Ascending Order
     * Verify that the Price column of the table is sorted in ascending order
     */
    @Test(priority = 3, description = "Sort table by ascending and validate it's sorted by price")
    public void validateSortAscPrice() {

        techGlobalSortableTablesPage.ascByPrice.click();
        List<WebElement> priceColumnElements = TableHandler.getTableColumn(driver, 3);
        List<Integer> priceColumn = new ArrayList<>();

        for (WebElement element : priceColumnElements) {
            priceColumn.add((Integer.parseInt(element.getText())));
        }
        IntStream.range(1, priceColumn.size()).forEach(i ->{
            Assert.assertTrue(priceColumn.get(i) >= priceColumn.get(i - 1));

        } );
    }


    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Price sort button to toggle descending order
     * Verify that the Price column of the table is sorted in descending order
     */

    @Test(priority = 3, description = "Sort table by descending and validate it's sorted by price")
    public void validateSortDesPrice() {

        techGlobalSortableTablesPage.descByPrice.click();

        List<WebElement> priceColumnElement = TableHandler.getTableColumn(driver, 3);
        List<Integer> priceColumn = new ArrayList<>();

        for (WebElement element : priceColumnElement) {
            priceColumn.add((Integer.parseInt(element.getText())));
        }
        IntStream.range(1, priceColumn.size()).forEach(i -> {
            Assert.assertTrue(priceColumn.get(i) <= priceColumn.get(i - 1));

        });
    }







}
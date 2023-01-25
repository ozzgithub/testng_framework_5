package testng_knowledge;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _05_SoftAssertion {

    @Test
    public void hardAssertionExample() {

        Assert.assertTrue(2==2);
        Assert.assertEquals("Hello", "abc");

        //When it failed the assertion program will stop.

        System.out.println("Hello World");
    }


    @Test
    public void softAssertionExample() {

        //We need create an object of SoftAssert class
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(2==2);

        System.out.println("Hello Word");

        softAssert.assertAll(); // shows the all the failed
    }
}

package testng_knowledge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.concurrent.TimeUnit;

public class _10_Parameterization {

    @Parameters({"username", "password"})
    @Test
    public void login(String username, String password) {

        System.out.println("Username comes from xml = " + username);
        System.out.println("Password comes from xml = " + password);




    }
}

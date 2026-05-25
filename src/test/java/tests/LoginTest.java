package tests;

import drivers.WebDriverFactory;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;

public class LoginTest {
    //Variables
    WebDriver driver;

    //Tests
    @Test
    //@DisplayName("Valid Login Test") //Change the name with TestNG itself
    @Description("Verify that the user is redirected to home page after providing correct credentials") //Change the description of the testcase in the Allure report
    @Tag("validLogin")
    @Owner("Yousef")
    @Severity(SeverityLevel.CRITICAL)
    @Link("www.confluence.jira.com/login") // any useful link related to the test case like a ticket link or a documentation link
    @TmsLink("TC-001") // link to the test case in the test management system (Zephyr for example)
    @Issue("BUG-01") //Link the test case with an issue
    public void validLoginTest(){
        Allure.getLifecycle().updateTestCase(results ->
                results.setName("Valid Login") //Change the name of the testcase in the Allure report
        );
        new LoginPage(driver) //anonymous object
                .login(PropertyReader.getProperty("validUsername"), PropertyReader.getProperty("validPassword"))
                .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTest(){
        //pages.LoginPage loginPage = new pages.LoginPage(driver); //this.driver(page object's driver) = driver(test file's driver)
        new LoginPage(driver) //anonymous object
                .login(PropertyReader.getProperty("invalidUsername"), PropertyReader.getProperty("invalidPassword"))
                .isLoggedIn(PropertyReader.getProperty("baseUrl"));
    }

    //Configuration
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.initDriver(); //chrome
        driver.get(PropertyReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }
}

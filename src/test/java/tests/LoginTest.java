package tests;

import drivers.WebDriverFactory;
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
    public void validLoginTest(){
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

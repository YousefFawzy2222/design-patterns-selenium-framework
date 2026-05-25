package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    //Variables
    WebDriver driver;

    //Tests
    @Test
    public void validLoginTest(){
        new LoginPage(driver) //anonymous object
                .login("standard_user", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inValidLoginTest(){
        //pages.LoginPage loginPage = new pages.LoginPage(driver); //this.driver(page object's driver) = driver(test file's driver)
        new LoginPage(driver) //anonymous object
                .login("admin", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/");
    }

    //Configuration
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }
}

package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.json.Json;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonReader;

public class HomeTest {
    WebDriver driver;
    JsonReader jsonReader;

    @Test
    public void addToCartTC(){
        new LoginPage(driver) //anonymous object
                .login(jsonReader.getJsonReader("username"), jsonReader.getJsonReader("password"))
                .isLoggedIn("https://www.saucedemo.com/inventory.html")
                .addToCart()
                .validateCartCount();
    }


    //Configuration
    @BeforeMethod
    public void setUp(){
        jsonReader = new JsonReader("home-data");
        driver = WebDriverFactory.initDriver();
        driver.get("https://www.saucedemo.com");
    }
    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }
}

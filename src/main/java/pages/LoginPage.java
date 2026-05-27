package pages;

import bots.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //Variables
    private WebDriver driver; //must be  single webdriver no more -> this driver is temporary to use WebDriver's methods
    private ActionsBot actionsBot;

    //Locators
    // private to encapsulate the locators and not allow other classes to access them directly, and final to make sure that they are not changed after initialization
    private final By userName= By.id("user-name");
    private final By password= By.id("password");
    private final By loginBtn= By.id("login-button");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver; //this will assign the driver that we pass from the test file as our driver variable in this class, so we can use it to interact with the elements in this page
        this.actionsBot = new ActionsBot(driver); // we will use this bot to perform the actions on the elements in this page, and we will pass the same driver to it so it can use it to find the elements and perform the actions
    }


    // Actions
    // best practice not to make an action to each function make it generic
    @Step("login to web portal with {username} and {pass}") //
    public LoginPage login(String username, String pass){ // We made the return type as pages.LoginPage to implement Method Chaining -> Fluent Pattern Approach
//        driver.findElement(userName).sendKeys(username);
//        driver.findElement(password).sendKeys(pass);
//        driver.findElement(loginBtn).click(); //-> After making the ActionBot we don't need that
        actionsBot.type(userName, username);
        actionsBot.type(password, pass);
        actionsBot.click(loginBtn);
        return this; //Same as if we said "return new LoginPage(driver)"
    }

    //validations
    @Step("Validate that the user is logged-in with {expectedUrl}")
    public HomePage isLoggedIn(String expectedUrl){
        // Here we violate the documentation of selenium in the POM part by adding our assertion not on the test but on the Page Object and this is because we want to make method chaining to make our tests much abstracted and clean
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
        return new HomePage(driver); // here we return the pages.HomePage object because after the login we will be redirected to the home page and we want to be able to call the methods of the home page after the login method in our test file
    }

}

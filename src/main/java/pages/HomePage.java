package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    //Variables
    private WebDriver driver;
    private ActionsBot actionsBot;
    //Locators
    private final By addToCartButton = By.xpath("//div[.='Sauce Labs Backpack'] //following::button[1]");
    private final By cartIcon = By.xpath("//*[@class=\"shopping_cart_link\"] /span");
    //Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
        actionsBot = new ActionsBot(driver);
    }

    //Actions
    public HomePage addToCart(){
//        driver.findElement(addToCartButton).click();
        actionsBot.click(addToCartButton);
        return this;
    }

    //Validations
    public HomePage validateCartCount(){
//        String cartIconText = driver.findElement(cartIcon).getText();
        String cartIconText = actionsBot.getText(cartIcon);
        Assert.assertEquals(cartIconText, "1");
        return this;
    }
}

package bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsBot {
    private WebDriver driver;
    private final WaitBot waitBot;

    public ActionsBot(WebDriver driver) {
        this.driver = driver;
        this.waitBot = new WaitBot(driver);

    }


    //Clicking
    public void click(By locator){
        waitBot
                .fluentWait()
                .until(d ->{

                    try {
                        WebElement element = d.findElement(locator); // re-fined the element again when polling
                        new Actions(d)
                                .scrollToElement(element);
                        element.click();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
        ); //this until will return true if the element was clicked successfully within the 10 sec wait if not it returns false
    }

    //Typing
    public void type(By locator, String text){
        waitBot
                .fluentWait()
                .until(d ->{

                    try {
                        WebElement element = d.findElement(locator); // re-fined the element again when polling
                        new Actions(d)
                                .scrollToElement(element);
                        element.clear(); // to clear the field before typing
                        element.sendKeys(text);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
                );

    }

    //Getting Text
    public String getText(By locator){
        return waitBot
                .fluentWait()
                .until(d ->{

                    try {
                        WebElement element = d.findElement(locator); // re-fined the element again when polling
                        new Actions(d)
                                .scrollToElement(element);
                        String msg = element.getText();
                        return !msg.isEmpty() ? msg : null; // if the element was empty return null if not return the message (true)
                    } catch (Exception e) {
                        return null;
                    }
                }
        );
    }
}

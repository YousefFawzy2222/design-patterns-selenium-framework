package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String name){
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("test-output/screenshots/" + name + ".png");
            FileUtils.copyFile(src, dest);
            AllureUtils.attachedScreenshotsToAllure(name, dest.getPath());
        } catch (Exception e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }
}

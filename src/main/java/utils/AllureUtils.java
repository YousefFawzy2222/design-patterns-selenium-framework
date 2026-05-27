package utils;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Path;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.nio.file.Files.newInputStream;

public class AllureUtils {
    //Clean Allure results folder
    public void cleanAllureResults(){
        FileUtils.deleteQuietly(new java.io.File("test-output/allure-results"));
    }

    public static void attachedScreenshotsToAllure(String screeName, String screenPath){
        try{
            Allure.addAttachment(screeName, newInputStream(Path.of(screenPath)));
        }catch (Exception e){
            System.out.println("Error attaching screenshot to Allure: " + e.getMessage());
        }
    }
    public static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("OS", PropertyReader.getProperty("os.name"))
                        .put("JDK Version", PropertyReader.getProperty("java.runtime.version"))
                        .put("URL", "https://www.saucedemo.com/")
                        .build(),
                PropertyReader.getProperty("user.dir")+ File.separator
                        + "test-output/allure-results" + File.separator);
    }
}

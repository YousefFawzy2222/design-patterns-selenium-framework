package utils;

import org.apache.commons.io.FileUtils;

public class AllureUtils {
    //Clean Allure results folder
    public void cleanAllureResults(){
        FileUtils.deleteQuietly(new java.io.File("test-output/allure-results"));
    }
}

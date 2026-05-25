package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import utils.PropertyReader;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    //ThreadLocal gives Each thread its own separate copy of a variable
    //We use it instead of WebDriver driver; -> shared across threads
    // ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>(); -> one driver per one thread
    private final static String browser = PropertyReader.getProperty("browserType");
    private static WebDriver getDriver(){
//        return switch (browser){
//            case "chrome" -> new ChromeFactory();
//            case "edge" -> new EdgeFactory();
//            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
//            //Either it will return a Chrom/Edge Object that it is intialized with all its options or an error
//        }; ----------> Commented because it violates the Open/Closed Principle
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserType.getDriverFactory();
        return abstractDriver.createDriver();
    }
    //These two methods above are what is going to do everything for the Drivers Factory
    public static WebDriver initDriver (){
        WebDriver driver = ThreadGuard.protect(getDriver());
        //ThreadGuard This WebDriver can ONLY be used by the thread that created it
        //ThreadGuard provides an exception if a WebDriver instance is accessed by a thread other than the one that created it, helping to prevent concurrency issues in multi-threaded test environments.
        driverThreadLocal.set(driver);
        return driverThreadLocal.get();
    }
    public static void quitDriver(){
        driverThreadLocal.get().quit();
    }
}

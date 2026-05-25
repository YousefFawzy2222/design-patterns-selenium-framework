package CustomListeners;

import org.testng.*;
import utils.PropertyReader;

import java.util.Properties;

//After making the listener we need to connect it to our test class, we can do that by adding @Listeners annotation to our test class and providing the listener class as a parameter
//Runs before the execution of the method
public class TestNGListeners implements IInvokedMethodListener, ITestListener, IExecutionListener { //Look up the implementation of IInvokedMethodListener and implement the methods
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) //this if condition tells the Listeners to run the interface only if it was a test method/case
            System.out.println(method.getTestMethod().getMethodName() + " started");
    }

    // Runs after the execution of the method
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod())
            System.out.println(method.getTestMethod().getMethodName() + " finished");
    }

    // Runs after the execution if the method passed
    public void onTestSuccess(ITestResult result){
        System.out.println(result.getMethod().getMethodName() + " passed");
    }

    //Runs after the execution if the method failed
    public void onTestFailure(ITestResult result){
        System.out.println(result.getMethod().getMethodName() + " failed");
    }

    //Runs after the execution if the method was skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " skipped");
    }

    // Executes before everything finishes
    public void onExecutionStart() {
        System.out.println("Execution started");
        PropertyReader.loadProperties(); //this will load all the properties files in our project and make them available as system properties, so we can use System.getProperty() to get any property we want from any file
    }

    // Executes after everything finishes
    public void onExecutionFinish() {
        System.out.println("Execution finished");
    }


}

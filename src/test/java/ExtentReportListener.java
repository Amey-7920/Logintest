import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import extenthtmlreporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static final String Output_Folder= "./build/";
    private static final String File_Name="extentReport.html";
    private static ExtentHtmlReporter htmlReporter;


    // Initialize ExtentReports and the HTML Reporter in a static block
    static {
         htmlReporter = new ExtentHtmlReporter("extentReport.html"); // Output file name
        extentReports = new ExtentReports();
        extentReports.attachReporter((ExtentObserver) htmlReporter);  // Attach the HTML Reporter to ExtentReports
    }
    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report when a test starts
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Mark the test as passed in the report
        extentTest.pass("Test passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        // If the test fails, log the failure in the report
        extentTest.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // If the test is skipped, log the skip in the report
        extentTest.skip("Test skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // You can handle this scenario if needed
    }

    @Override
    public void onStart(ITestContext context) {
        // You can initialize resources if needed before the test suite starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // After all tests have finished, flush the reports
        extentReports.flush();
    }
}

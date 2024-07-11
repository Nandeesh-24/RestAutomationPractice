import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.services.MyServiceRequests;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseClass {

    static MyServiceRequests serviceRequests;

    static ExtentReports extentReports;
    static ExtentTest extentTest;

    @BeforeSuite
    public void setupReport(){
        serviceRequests = new MyServiceRequests();
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
        extentReports.attachReporter(sparkReporter);
    }

    @BeforeTest
    public void addTestToReport(ITestContext context){
        extentTest = extentReports.createTest(context.getName());
    }

    @AfterSuite
    public void loadReport() throws IOException {
        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }
}

import org.services.MyServiceRequests;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class VerifyRestApis extends BaseClass {

    @Test
    public void verifyGetApi(){
        serviceRequests.getBookResponse();
//        extentReports.createTest("Pass")
//                .addScreenCaptureFromPath("sample.png")
//                .addScreenCaptureFromPath("sample.png");
//        extentTest.info("Some info for another");
//        extentTest.pass("Pass1");
    }

    @Test
    public void verifyGetApi1(){
        serviceRequests.getBookResponse();
//        extentReports.createTest("Pass")
//                .addScreenCaptureFromPath("sample.png")
//                .addScreenCaptureFromPath("sample.png");
//        extentTest.info("Some info for another");
//        extentTest.pass("Pass1");
    }
}

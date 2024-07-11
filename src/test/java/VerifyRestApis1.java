import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;

public class VerifyRestApis1 extends BaseClass {

    @Test(threadPoolSize = 2, invocationCount = 5,timeOut = 3000)
    public void verifyGetApi(){
        serviceRequests.getBookResponse();
//        extentReports.createTest("Pass1")
//                .addScreenCaptureFromPath("sample.png")
//                .addScreenCaptureFromPath("sample.png");


        extentTest.info("Some info");
        extentTest.pass("Pass");
    }



    @Test
    public void testAsync() throws ExecutionException, InterruptedException {
        serviceRequests.asyncGet(5);
    }

    @Test
    public void testTimeout() throws ExecutionException, InterruptedException {
        serviceRequests.timeoutGetRequest();
    }
}

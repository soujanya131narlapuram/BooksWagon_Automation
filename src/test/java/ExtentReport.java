import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class ExtentReport  {



   public ExtentReports reports;
   public  ExtentTest test;
public WebDriver driver;


@BeforeTest
    public void beforeTest() {

    reports = new ExtentReports();
    File file = new File("extentReport.html");
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("file");
    reports.attachReporter(sparkReporter);

}
        @Test
        public void test_1() {
        test = reports.createTest("Test Case 1", "The test case 1 has passed");
            Assert.assertTrue(true);
        }


        @Test
        public void test_2() {
            test = reports.createTest("Test Case 2", "The test case 2 has failed");
            Assert.assertTrue(false);
        }

        @Test
        public void test_3() {
             test = reports.createTest("Test Case 3", "The test case 3 has been skipped");
            throw new SkipException("The test has been skipped");
        }



@Test
        public void logTest_4() {
             reports.createTest("Test 4","log statements")
            .log(Status.PASS,"PASS")
            .log(Status.FAIL,"FAIL")
            .log(Status.SKIP,"SKIP")
            .log(Status.INFO,"INFO 1").log(Status.WARNING,"WARNING");


}

        @AfterMethod
    public void getResult(ITestResult result) {
            if(result.getStatus() == ITestResult.FAILURE) {
               test.log(Status.FAIL,result.getThrowable());
            }
            else if(result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, result.getTestName());
            }
            else {
                test.log(Status.SKIP, result.getTestName());
            }
        }

        @AfterTest
        public void tearDown() {
//to write or update test information to reporter
            reports.flush();
        }

    }



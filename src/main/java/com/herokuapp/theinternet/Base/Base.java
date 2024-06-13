package com.herokuapp.theinternet.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
    }

    ExtentSparkReporter reporter;
    ExtentReports report;
    ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void openReport(){
        reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/report.html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setTimelineEnabled(true);
        reporter.config().setTimeStampFormat("MMMM dd, yyyy, hh:mm a '('zzz')'");
        reporter.config().setReportName("report");
        reporter.config().setDocumentTitle("Test Run Report");

        report = new ExtentReports();
        report.attachReporter(reporter);
    }

    @AfterSuite(alwaysRun = true)
    public void closeReport(){
        report.flush();
    }

    @AfterMethod(alwaysRun = true)
    public  void afterEachTestMethod(ITestResult result) throws IOException {
        test = report.createTest(result.getMethod().getDescription());
        if(result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot();
            result.setAttribute("screenshotPath", screenshotPath);
            test.addScreenCaptureFromPath(screenshotPath);
            test.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getTestName());
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
    }

    public String captureScreenshot() throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" +  dateName
                + ".png";
        File finalDestination = new File(destination);
        FileHandler.copy(source, finalDestination);
        return destination;
    }
}

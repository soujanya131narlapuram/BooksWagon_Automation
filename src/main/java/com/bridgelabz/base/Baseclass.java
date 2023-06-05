package com.bridgelabz.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Baseclass {
    public WebDriver driver;
    public static Logger log;
    public ExtentReports reports;


    public void setup() throws IOException
    {
        log = Logger.getLogger(Baseclass.class.getName());
        reports=new ExtentReports();
        File file=new File("extentReport.html");
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter("file");
        reports.attachReporter(sparkReporter);
        PropertyConfigurator.configure("C:\\Users\\narla\\IdeaProjects\\BooksWagon1\\src\\log4j.properties");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.bookswagon.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void closeWindow() {
        driver.quit();
        reports.flush();

    }


}

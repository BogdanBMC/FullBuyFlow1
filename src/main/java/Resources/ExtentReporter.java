package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.annotations.VisibleForTesting;

public class ExtentReporter {



    public static ExtentReports config(){
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("test1");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;

    }



}

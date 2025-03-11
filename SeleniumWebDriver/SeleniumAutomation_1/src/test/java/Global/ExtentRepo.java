package Global;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepo {

	public static ExtentReports setUp() {
        // Initialize ExtentReports and attach the Spark reporter
		String path=System.getProperty("user.dir")+"//reports//index.html";
		 ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(path);
        spark.config().setReportName("Results");
        spark.config().setDocumentTitle("Test Results");
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Meenakshi");
        return extent;
}
}
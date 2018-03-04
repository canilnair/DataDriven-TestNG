package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportInit {
	public ExtentReports report;
	public ExtentTest test;

	public ExtentReportInit(String TestClassName, Boolean reportOverRider) {
		
		String Path = "/Users/anair/Desktop/TestReport/DataDriver-Framework-Report.html";
		report = new ExtentReports(Path, reportOverRider);
		report.addSystemInfo("Selenium Version", "2.52").addSystemInfo("Platform", "Mac");
//		this.report = ExtentReportFactory.getInstance();
		this.test = report.startTest(TestClassName);
	}
	
	public void loggingINFO(String INFOmessage){
		test.log(LogStatus.INFO, INFOmessage);
	}
	
	public void loggingPASS(String PASSmessage){
		test.log(LogStatus.PASS, PASSmessage);
	}
	
	public void loggingFAIL(String FAILmessage){
		test.log(LogStatus.FAIL, FAILmessage);
	}

	public void EndReporting() {
		report.endTest(test);
		report.flush();
	}

}

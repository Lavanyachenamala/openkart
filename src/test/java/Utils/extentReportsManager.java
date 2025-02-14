package Utils;

import java.util.Date;
import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class extentReportsManager implements ITestListener {

	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	public void onStart(ITestContext testContext) {
	
	/*SimpleDateFormat df= new SimpleDateFormat("yyyy.dd.mm.HH.mm.ss");
	Date dt= new Date();
	String currentDateTimeStamp=df.format(dt);*/
		
		String timeStamp= new SimpleDateFormat("yyyy.dd.mm.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+timeStamp +".html";
		sparkReporter= new ExtentSparkReporter(".\\reports\\" + repName);//specify location of the report
		
		sparkReporter.config().setDocumentTitle("Open cart Automation Report");//Tiltle of report
		sparkReporter.config().setReportName("opencart Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
	    extent.setSystemInfo("Module", "Admin");
	    extent.setSystemInfo("subModule", "Customers");
	    extent.setSystemInfo("User Name", System.getProperty("user.name"));
	    extent.setSystemInfo("Environment","QA");
	    
	    String os=testContext.getCurrentXmlTest().getParameter("os");
	    extent.setSystemInfo("operating system",os);
	    
	    String browser=testContext.getCurrentXmlTest().getParameter("browser");
	    extent.setSystemInfo("Browser", browser);
	    		
	    List<String> includedgroups=testContext.getCurrentXmlTest().getIncludedGroups();
	    
	    if(!(includedgroups.isEmpty())) {
	    	extent.setSystemInfo("Groups",includedgroups.toString());
	    	
	    	 }		
	    		}
	public  void onTestSuccess(ITestResult result) {
		test= extent.createTest(result.getTestClass().getName());
		
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"got succesfullu ececuted");
		}
	
	public  void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+"got Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		try {
		String imgpath= new BaseClass().CaptureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		
	}
		catch (Exception e1) {
       e1.printStackTrace();
		}
		}
	public void onTestSkipped(ITestResult result) {
	  test= extent.createTest(result.getTestClass().getName());
	  test.assignCategory(result.getMethod().getGroups());
	  test.log(Status.SKIP,result.getName()+"got Skipped");
	  test.log(Status.INFO,result.getThrowable().getMessage());
  }
  public void onFinish(ITestContext textcontext) {
	  
	  extent.flush();
	  String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+"repName";
	  File ExtentReport = new File(pathofExtentReport);
	  try {
		  Desktop.getDesktop().browse(ExtentReport.toURI());
	  
	  }catch (Exception e) {
		e.printStackTrace();
	}
	/* try {
		 
		 URL url =new URL("file:///+System.getProperty(user.dir)+\\reports"+"repName");
		 //create the email message 
		 ImageHtmlEmail email=new ImageHtmlEmail();
		 email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 email.setHostName("smtp.googlemail.com");
		 email.setSmtpPort(465);
		 email.setAuthenticator(new DefaultAuthenticator("lavanya.4a1@gmail.com","password"));
		 email.setSSLOnConnect(true);
		 email.setFrom("laavipallelli@gmail.com");//sender
		 email.setSubject("Test Results");
		 email.setMsg("please find Attached Report...");
		 email.addTo("lavanya.4a1@gmail.com");//receiver
		 email.attach(url,"extent report","please check report... ");
		 email.send();//send the email
	 }catch (Exception e) {
		e.printStackTrace();
		 
	 } */
	  
	  
	  
  }
  }
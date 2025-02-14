package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {

	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters({"os","browser"})
   public void setup(String os,String br) throws IOException {
	//Loading  the file from properties file	
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			 DesiredCapabilities cap= new DesiredCapabilities();
		if(os.equalsIgnoreCase("windows")) {
			cap.setPlatform(Platform.WIN11);
			
		}else if(os.equalsIgnoreCase("mac"))
		{
			cap.setPlatform(Platform.MAC);
		}
		
		else 
		{
			System.out.println("no os is matching ");
			return;	
		}
		
		switch(br.toLowerCase()) {
		
		case "chrome":cap.setBrowserName("chrome");break;
		case "edge":cap.setBrowserName("Microsoftedge");break;
		default:System.out.println("Invalid browser name");
		return;
		}
		
		 driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	}

 if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
  
	 switch(br.toLowerCase()){
		case"chrome":driver= new ChromeDriver();break;
		case"firefox":driver=new FirefoxDriver();break;
		case"edge":driver=new EdgeDriver();break;
		default:System.out.println("Invalid browser name");
		return;
		}
		
 }
	    driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));//Reading appUrl from properties file which is under src/test/resources folder
		driver.manage().window().maximize();
	
		}
@AfterClass(groups= {"Master","Sanity","Regression"})
public void teardown()
{
      driver.quit();		
}	
@SuppressWarnings("deprecation")
public String randomestring() {
	
	String randomestring= RandomStringUtils.randomAlphabetic(5);
	return randomestring;
	
}
@SuppressWarnings("deprecation")
public String randomeNum() {
	
	String randomnum=RandomStringUtils.randomNumeric(10);
	return randomnum;
}

@SuppressWarnings("deprecation")
public String randomealphaNum() {
	return(RandomStringUtils.randomAlphanumeric(10));
}
public String CaptureScreen(String tname) {
	// TODO Auto-generated method stub
	
	String timeStamp= new SimpleDateFormat("yyyy.dd.mm.HH.mm.ss").format(new Date());
	TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
	String TargetfilePath= System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+ timeStamp+".PNG";
	
	File targetfile= new File(TargetfilePath);
	sourceFile.renameTo(targetfile);
	
	
	return TargetfilePath;
}
	
	
}

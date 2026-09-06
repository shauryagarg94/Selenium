package pack;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Register_ExtentReport {

	public static void main(String[] args) throws InterruptedException {

		ExtentHtmlReporter sparkReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/reports/myExtentReport.html");//design html page
		sparkReporter.config().setDocumentTitle("Automation Report"); 
		sparkReporter.config().setReportName("Functional Testing"); 
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		ExtentReports extent=new ExtentReports();// this is main engine manages whole report, attaches html report, add systeminfo, final report
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Environment","QA-SIT");// to display values
		extent.setSystemInfo("Tester Name","Kapoor");
		extent.setSystemInfo("os","Windows11");
		extent.setSystemInfo("Browser name","Chrome");
		
		
		ExtentTest test = extent.createTest("MyFirstTest- RegisterPage", "This is register Page testCase"); //(test name, description)

	
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://logicnextgen.com/projects/logiccart/upload/index.php?route=account/register&language=en-gb");
		
		test.log(Status.PASS, "Strating test here");
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Kundan");
		
		test.log(Status.PASS, "First Name Entered");
		
		driver.findElement(By.id("input-lastname")).sendKeys("Kapoor");
		
		test.log(Status.PASS, "Last Name Entered");
		
		driver.findElement(By.id("input-email")).sendKeys("kapoor" + System.currentTimeMillis() + "@test.com");
		test.log(Status.PASS, "Email Entered");
		
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		test.log(Status.PASS, "Phone Entered");
		
		driver.findElement(By.id("input-password")).sendKeys("Test@123");
		test.log(Status.PASS, "Password Entered");
		
		Thread.sleep(5000);
		driver.findElement(By.id("k_kapoor_check_box")).click();
		test.log(Status.PASS, "Checkbox click Done");
		
		Thread.sleep(5000);
		driver.findElement(By.id("k_kapoor_developer_button")).click();
		test.log(Status.PASS, "Button Click Done");
		Thread.sleep(5000);
		
		extent.flush();  
		
	}
	}


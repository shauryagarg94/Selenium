package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P14_IFrame {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://logicnextgen.com/projects/AutomationTestingPractice/iframe.php");
		
		WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
		
		
		Thread.sleep(5000);
		
		
		

		String text1 = driver.findElement(By.xpath("//span[normalize-space()='Logic']")).getText();

		System.out.println("Text displayed: " + text1);

		driver.switchTo().defaultContent();
		driver.quit();
	}

}

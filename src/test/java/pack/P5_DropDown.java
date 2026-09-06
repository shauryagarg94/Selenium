


package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P5_DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://logicnextgen.com/projects/AutomationTestingPractice/dropdown.php");
		
		Select select=new Select(driver.findElement(By.id("state")));
		Thread.sleep(5000);
		select.selectByVisibleText("Uttar Pradesh");
		Thread.sleep(5000);
		select.selectByVisibleText("Delhi");
	}

}

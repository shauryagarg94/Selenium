package pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P16_Wait2ExplicitWait {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//(jisme wait ki zaoorat hai usko mention karna hai)
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));//(agar jaldi mil gaya to nhi wait karega)

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).sendKeys("Admin");


        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        driver.findElement(By.name("password")).sendKeys("admin123");


        wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//button[@type='submit']"))).click();
	}

}

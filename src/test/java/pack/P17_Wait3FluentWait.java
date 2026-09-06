package pack;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class P17_Wait3FluentWait {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Wait<WebDriver> wait = new FluentWait<>(driver)

                .withTimeout(Duration.ofSeconds(10))// total kitna time

                .pollingEvery(Duration.ofSeconds(2))//every 2 sec attempt is made

                .ignoring(NoSuchElementException.class);

        WebElement username = wait.until(

                driver1 -> driver1.findElement(By.name("username"))

        );

        username.sendKeys("Admin");

		
	}

}
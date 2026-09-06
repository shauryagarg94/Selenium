package pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P13_Calendar {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://logicnextgen.com/projects/AutomationTestingPractice/date-calendar.php");
		
		// Required date
        String requiredMonth = "Mar";
        String requiredYear = "2028";
        String requiredDate = "3";

      
        driver.findElement(By.id("datepicker")).click();

       
        Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
        month.selectByVisibleText(requiredMonth);

       
        Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
        year.selectByVisibleText(requiredYear);

        
      
        List<WebElement> allDates = driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td"));

        // Select required date
        for (WebElement ele : allDates) {

            String date = ele.getText();

            if (date.equals(requiredDate) && !ele.getAttribute("class").contains("ui-datepicker-other-month")) 
            {
                ele.click();
                break;
            }
        }
	}

}

package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev66492.service-now.com/navpage.do");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Venba@96779");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.id("filter")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@role='search']//input[1]")).sendKeys("INC0010010");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']//span[1]")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowhandles);
		String parentw= windows.get(0);
		String childw = windows.get(1);
		driver.switchTo().window(childw);
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(parentw);
		driver.switchTo().frame(0);
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Assigned the Incident to Software Group");
		WebElement assign = driver.findElement(By.xpath("sys_display.incident.assignment_group"));
		if (assign.equals("Software")) {
			System.out.println("Assignment group is Validated");
		}
		else {
			System.out.println("Assignment group is not Validated");
		}
	}

}

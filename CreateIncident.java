package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident {

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
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@data-for='sys_display.incident.caller_id']//span[1]")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowhandles);
		String parentw= windows.get(0);
		String childw = windows.get(1);
		driver.switchTo().window(childw);
		driver.findElement(By.linkText("Abel Tuter")).click();
		driver.switchTo().window(parentw);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.id("incident.short_description")).sendKeys("This is a sample Incident");
		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.switchTo().frame(0);
		String incidentnum = driver.findElement(By.xpath("//td[@class='vt'][1]")).getText();
		driver.findElement(By.xpath("//div[@role='search']//input[1]")).sendKeys(incidentnum);
		if (incidentnum.contains("This is a sample Incident")) {
			System.out.println("Incident Successfully Created and display validated");
		}
		else {
			System.out.println("Incident Not created");
		}
		
		
		

	}

}

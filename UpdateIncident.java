package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident {

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
		driver.findElement(By.xpath("//td[@class='vt'][1]")).click();
		WebElement prior = driver.findElement(By.id("incident.urgency"));
		Select priority = new Select (prior);
		priority.selectByIndex(0);
		WebElement state = driver.findElement(By.id("incident.state"));
		Select statedrop = new Select (state);
		statedrop.selectByIndex(1);
		String priortext = driver.findElement(By.id("incident.urgency")).getText();
		String statetext = driver.findElement(By.id("incident.state")).getText();
		if(priortext.contains("1-High")) {
			System.out.println("Priority is Correct");
		}
		else {
			System.out.println("Proirty is not correct");
		}
		if (statetext.contains("In Progress")){
			System.out.println(" State of progress is validated");
		}
		else {
			System.out.println("State is not correct");
		}
		
		
		
	}

}

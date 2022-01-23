package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident {

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
		driver.findElement(By.xpath("//input[@class='checkbox ']/following-sibling::label[1]")).click();
		WebElement deldrop = driver.findElement(By.xpath("//select[@class='list_action_option form-control ']"));
		Select deletedrop = new Select(deldrop);
		deletedrop.selectByIndex(2);
		driver.switchTo().alert().accept();
	}

}

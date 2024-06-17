package lk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class FrameSection {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/frame");
		
		WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src=\"frameUI\"]"));
		driver.switchTo().frame(outerFrame);
		WebElement FirstName = driver.findElement(By.name("fname"));
		FirstName.sendKeys("Sai");
		
		WebElement  innerFrame = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
		driver.switchTo().frame(innerFrame);
		WebElement emailId = driver.findElement(By.xpath("//input[@name = 'email']"));
		emailId.sendKeys("SDrth@gmail.com");	
		
		driver.switchTo().parentFrame();
		WebElement LastName = driver.findElement(By.name("lname"));
		LastName.sendKeys("Kannan");
		
		WebElement Text1 = driver.findElement(By.xpath("//div[@class='content mt-4']/p"));
		System.out.println(Text1.getText());
		driver.switchTo().defaultContent(); 
		
		WebElement heading = driver.findElement(By.xpath("//div[@class='container']/h1"));
		System.out.println("The heading of that web page is : "+ heading.getText());
	
		driver.quit();

	} }

package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutor_Scenario_1 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/test");

		WebElement inputMenu = driver.findElement(By.xpath("(//footer[@class=\"card-footer\"])[1]"));
		inputMenu.click();

		WebElement fullName = driver.findElement(By.id("fullName"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='asdf'", fullName);

		System.out.println("Input page's url : " + driver.getCurrentUrl());
		System.out.println("-------------------------");
		driver.navigate().back();
		System.out.println("Test page's url : " + driver.getCurrentUrl());
		System.out.println("-------------------------");
	
		WebElement imageLink = driver.findElement(By.xpath("//div[@class=\"container\"]//a/img"));
		js.executeScript("arguments[0].click()", imageLink);
		System.out.println("Home page's url : " + driver.getCurrentUrl());

	}

}

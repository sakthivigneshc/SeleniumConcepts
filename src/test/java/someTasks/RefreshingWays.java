package someTasks;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshingWays {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("abcd");
		Thread.sleep(5000);
//		driver.navigate().refresh(); it is working even though I used get()
//		driver.get(driver.getCurrentUrl());
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("location.reload()");
		
		
		/* not gonna use
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_5);
		robot.keyRelease(KeyEvent.VK_5);
		*/

		
		
		
	}

}

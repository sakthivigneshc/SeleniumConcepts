package selenium_Concepts_I;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertSection {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/alert");

		// Alert 1
		WebElement alert1 = driver.findElement(By.id("accept"));
		alert1.click();

		Alert alert01 = driver.switchTo().alert();
		String text = alert01.getText();
		System.out.println("Text inside in the first alert: "+text);
		alert01.accept();

		// Alert 2
		WebElement alert2 = driver.findElement(By.id("confirm"));
		alert2.click();

		Alert alert02 = driver.switchTo().alert();
		String Textalert = alert02.getText();
		System.out.println("Text of the alert in second alert is: " + Textalert);
		alert02.dismiss();
 
		//Alert 3
		
		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 600);
			
		Alert alert03 = driver.switchTo().alert();

		String alertText = 	alert03.getText();
		System.out.println("Text of the alert in second alert is: " + alertText);

		Thread.sleep(3000);

		alert03.sendKeys("Ram");
		alert03.accept();
		Thread.sleep(3000);

		WebElement textMsg = driver.findElement(By.xpath("//div[@class='control']/div/div/p"));
		System.out.println(textMsg.getText());

		
		Actions actions1 = new Actions(driver);
		actions1.scrollByAmount(0, 600);

		// ModernAlert
		WebElement ModernAlert = driver.findElement(By.id("modern"));
		ModernAlert.click();

		WebElement closebtn = driver.findElement(By.xpath("//div[@class='modal is-active']/button"));
		closebtn.click();
		
		driver.close();

	}

}

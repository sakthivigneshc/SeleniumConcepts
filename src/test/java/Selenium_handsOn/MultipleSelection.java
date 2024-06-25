package Selenium_handsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleSelection {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/selectable");

		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).perform();
		for (int i = 1; i <= 9; i+=2) {
		WebElement values =	driver.findElement(By.xpath("//div[@id='selectable'][" + i + "]"));
		values.click();
		System.out.println(	values.getText());
		}
		act.keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
		driver.quit();
	}
}

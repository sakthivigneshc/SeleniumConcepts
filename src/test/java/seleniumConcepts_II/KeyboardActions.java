package seleniumConcepts_II;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardActions {
public static void main(String[] args) {
	
	// Using Tab and Enter
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://www.saucedemo.com/");
	WebElement userName = driver.findElement(By.xpath("//div[@class='form_group']/input[@id='user-name']"));
	userName.sendKeys("visual_user" + Keys.TAB + "secret_sauce");
	userName.sendKeys(Keys.ENTER);
	

	String UrlOfThePage  =	driver.getCurrentUrl();
	
	//Check whether we switch into the products page
	
	if("https://www.saucedemo.com/inventory.html".equals(UrlOfThePage)) {
		System.out.println("The URL is present as expected.");
	}
	else {
		System.out.println("The URL isn't present as expected.");

	}
	
	driver.quit();
	
	/*
	 
	 Keys.CONTROL+'a'
	 Keys.CONTROL+'c'
	 Keys.CONTROL+'v'

------------------------------------

if you need to perform more complex keyboard interactions, such as pressing multiple keys at once, releasing keys, or combining mouse and keyboard actions, the Actions class can be useful. Here's an example of how you might use the Actions class to perform the same Tab and Enter actions:


WebElement inputField = driver.findElement(By.id("yourElementId"));

        // Create an Actions instance
        Actions actions = new Actions(driver);

        // Perform Tab and Enter key actions using the Actions class
        actions.sendKeys(inputField, Keys.TAB)
               .sendKeys(Keys.ENTER)
               .perform();


	 
	
	 */
	
	
}
}

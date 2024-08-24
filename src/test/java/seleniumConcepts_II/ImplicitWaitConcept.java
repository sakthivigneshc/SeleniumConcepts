package seleniumConcepts_II;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.saucedemo.com");
		
		WebElement userName = driver.findElement(By.xpath("//div[@class='form_group']/input[@id='user-name']"));
		userName.sendKeys("visual_user");
		WebElement passWord = driver.findElement(By.xpath("//div[@class='form_group']/input[@id='password']"));
		passWord.sendKeys("secret_sauce");
		WebElement LoginBtn = driver.findElement(By.xpath("//input[@name='login-button']"));
		LoginBtn.click();
		
		String UrlOfThePage  =	driver.getTitle();
		
		if("https://www.saucedemo.com/inventory.html".equals(UrlOfThePage)) {
			System.out.println("The URL is present as expected.");
		}
		else {
			System.out.println("The URL isn't present as expected.");

		}
		
		WebElement Heading = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span"));
		String HeadingText  = Heading.getText();
		
		if("Products".equals(HeadingText)) {
			System.out.println("The heading is present as expected.");
		}
		
		else {
			System.out.println("The heading isn't present as expected.");

		}	
	}	
}

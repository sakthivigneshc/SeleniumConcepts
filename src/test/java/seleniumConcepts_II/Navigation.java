package seleniumConcepts_II;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.demoblaze.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,180)", "");
		
		WebElement FirstProduct = driver.findElement(By.xpath("//a[normalize-space()='Samsung galaxy s6']"));
		FirstProduct.click();
		
		System.out.println("Product's add to cart page: "+driver.getCurrentUrl());
		driver.navigate().refresh();
		
		driver.navigate().back();
		System.out.println("Back to home page: "+driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println("Back to Product's add to cart page: "+driver.getCurrentUrl());

		
		driver.quit();
		
	}

}



/*
 
Product's add to cart page: https://www.demoblaze.com/prod.html?idp_=1
Back to home page: https://www.demoblaze.com/
Back to Product's add to cart page: https://www.demoblaze.com/prod.html?idp_=1
  
 
 */

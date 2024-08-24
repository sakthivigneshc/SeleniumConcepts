package selenium_Concepts_I;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSection {
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String parentWindow;

		System.out.println("---------- First link ------------------"+"\n");
		driver.get("https://letcode.in/windows");
		WebElement firstLink = driver.findElement(By.id("home"));
		firstLink.click();
		System.out.println("The Main page title is : " + driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> I2 = windowHandles.iterator();
		parentWindow  = I2.next();
		String child = I2.next();
		driver.switchTo().window(child);
		
		WebElement check = driver.findElement(By.xpath("//div[@class='column']/h1"));
		System.out.println("Title of this page : "+ driver.getTitle() +"\n" + "Heading of this page: "+check.getText());
		Thread.sleep(4000);
		driver.close();
		System.out.println("-------------------------------------------------------" +"\n");

		driver.switchTo().window(parentWindow);
		
		// Second link
		System.out.println("---------- Second link ------------------"+"\n");
		WebElement link2 = driver.findElement(By.id("multi")); 
		link2.click();
		
        Set<String> windowHandles2 = driver.getWindowHandles(); // store the window handles 
        
        List<String> windowURL = new ArrayList<>(); // List to store URL of each window
        
        for (String windowHandle : windowHandles2) { // Iterate through each window handle
            driver.switchTo().window(windowHandle); // Switch to the window
            String currentURL = driver.getCurrentUrl();// Get the url of the window
            windowURL.add(currentURL); // Add title to the list
            
            if (currentURL.equals("https://letcode.in/dropdowns")) {
            	WebElement heading = driver.findElement(By.xpath("//div[@class='container']/h1"));
            	String	headingText = 	heading.getText();
             	System.out.println("******** First child window ********");
            	if(headingText.equals("Dropdown")) {
            		System.out.println("The text is Dropdown is present.");
            	}
            	else {
            		System.out.println("The text is Dropdown is not present.");
            	}
            	driver.close(); }
            
             else if (currentURL.equals("https://letcode.in/alert")) {
             	System.out.println("******** Second child window ********");
                 WebElement heading = driver.findElement(By.id("accept"));
                 heading.click();
                 Thread.sleep(3000);
                 Alert alert = driver.switchTo().alert();		
                 String alertText  = alert.getText();
                 System.out.println("The text present in the alert is: "+ alertText);
                 alert.accept();
                 driver.close();
             } }
        driver.switchTo().window(parentWindow);
        System.out.println("Back to Main page title is : "+ driver.getTitle());
        System.out.println("------------------------------------------------------");
        driver.quit();
        } }
	

		
		
	
		
		
	 

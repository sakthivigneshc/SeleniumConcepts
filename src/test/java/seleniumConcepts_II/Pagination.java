package seleniumConcepts_II;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
        String expectedProduct = "asdf"; // Chocolate
        boolean productFound = false;
        int pageNumber=1;

        while (true) {
            List<WebElement> firstColumn = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
            WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));
            String isDisabled = nextButton.getAttribute("aria-disabled");
          
            for (WebElement firstValue : firstColumn) {
                if (firstValue.getText().equalsIgnoreCase(expectedProduct)) {
                    System.out.println(firstValue.getText() + "product found: "+"at page is :" + pageNumber);
                    productFound = true;
                    break;
                }
            }
            if (productFound) {
                break;
            }
            if (isDisabled != null && isDisabled.equals("true")) {
                System.out.println("Reached last page. Product not found.");
                break;
            } else {
                nextButton.click();
                pageNumber++;
                Thread.sleep(1000); 
            }

        }

        driver.quit();
    }
}

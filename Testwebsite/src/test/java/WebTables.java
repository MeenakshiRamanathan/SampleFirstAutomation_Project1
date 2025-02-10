import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 900)");
		
		
		WebElement rows=driver.findElement(By.xpath("//table[@id='product']"));
				
		
		int rowCount=rows.findElements(By.tagName("tr")).size();
		System.out.println("RowCount"+rowCount);
		
		int columnCount=rows.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
		
		System.out.println("columnCount"+columnCount);
		
		int col=rows.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).size();
		
		List<WebElement> columnMsg=rows.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		for(int i=0;i<col;i++)
		{
			String ss=columnMsg.get(i).getText();
			System.out.println("TextMsg"+ss);
		}
		
		
		
		
		

		//List<WebElement> column=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
		
		//List<WebElement> row=driver.findElements(By.xpath("//table[@id='product']/tbody/tr"));
		
	     
		
		
		
	}
}

		
				
			
			
		

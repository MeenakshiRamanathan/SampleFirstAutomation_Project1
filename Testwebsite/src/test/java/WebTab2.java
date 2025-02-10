import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTab2 {

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
		
		int columnCount=0;
        List<WebElement> column=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
        for(int i=0;i<column.size();i++)
        {
        	columnCount++;
        }
		
        System.out.println("columnCount:"+columnCount);
        
        int rowCount=0;
        WebElement rows=driver.findElement(By.xpath("//table[@id='product']"));
        List<WebElement> rs= rows.findElements(By.tagName("tr"));
        for(int k=0;k<rs.size();k++)
        {
        	rowCount++;
        }
        
       List<WebElement> rr= rows.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
       for(int j=0;j<rr.size();j++)
       {
    	  String msg= rr.get(j).getText();
    	  System.out.println("msg:"+msg);
       
       System.out.println("rowCount:"+rowCount);
	}

}
}


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();
		WebElement check = driver.findElement(By.cssSelector("input[id='checkBoxOption2']"));

		String checkbox = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		System.out.println("result" + checkbox);

		Boolean ss = check.isSelected();
		Assert.assertTrue(ss);

		String save = "";

		WebElement dropdown = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));
		driver.findElement(By.cssSelector("select[id='dropdown-class-example']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(checkbox)) {
				save = list.get(i).getText();

				System.out.println(save);
				list.get(i).click();
				break;

			}
		}

		WebElement alert = driver.findElement(By.cssSelector("input[id='name']"));
		alert.sendKeys(save);

		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		String str = driver.switchTo().alert().getText();
		System.out.println(str);

		String a = str.split(",")[0].trim().split(" ")[1].trim();

		Boolean pp = a.equalsIgnoreCase(save);

		Assert.assertTrue(pp);
		driver.switchTo().alert().accept();

	}

}

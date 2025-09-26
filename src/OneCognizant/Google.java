package OneCognizant;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		
		//Invoke ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Go to the google website and check for the title
		String webTitle =  "https://www.google.com";
		driver.get(webTitle);
		String mainPage = driver.getTitle();
		Assert.assertEquals(mainPage, "Google");
		//System.out.println("TITLE: "+mainPage);
		
		//Go to search tab and search for mobiles
		WebElement searchTab = driver.findElement(By.xpath("//*[@title='Search']"));
		searchTab.sendKeys("Mobiles");
		
		WebElement searchMobiles = driver.findElement(By.xpath("//*[@data-entityname='mobiles']"));
		searchMobiles.click();
		
		Thread.sleep(60000);
		
		//Click on the second search result
		List<WebElement> searchLinks = driver.findElements(By.xpath("//h3")); //There are 12 elements get the second one
		searchLinks.get(2).click();
			
		String secondSearch = driver.getTitle();
		System.out.println(secondSearch);
		//Assert.assertEquals(secondSearch, "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
		Assert.assertNotEquals(secondSearch, mainPage);
		System.out.println("New page loaded");
		
		driver.quit();

	}

}

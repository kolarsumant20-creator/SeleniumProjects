package OneCognizant;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class makeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		//Invoke ChromeDriver
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Go to the google website and check for the title
				String webTitle =  "https://www.makemytrip.com/";
				driver.get(webTitle);
				Assert.assertEquals(driver.getTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
				//System.out.println("TITLE: "+driver.getTitle());
				
				driver.findElement(By.xpath("//*[@data-cy='closeModal']")).click();
				
				//Click on RoundTrip radio button
				WebElement roundTripButton = driver.findElement(By.xpath("//li[@data-cy='roundTrip']"));
				roundTripButton.click();
				
				//Checking for the faretype is Regular
				WebElement regularButton = driver.findElement(By.xpath("//div[text()='Regular fares']"));
				if (regularButton.isSelected()) {
					System.out.println("Regular faretype is checked");
				}
				else {
					regularButton.click();
					System.out.println("Regular faretype is checked now");
				}
				
				//Click on MultiCityTrip radio button
				WebElement multiCityButton = driver.findElement(By.xpath("//li[@data-cy='mulitiCityTrip']"));
				multiCityButton.click();
				
				//Checking for the faretype is 'Govt Employee' available
//				List<WebElement> fareTypes = driver.findElements(By.xpath("//*[@class='fareCardItem ']"));
//				System.out.println(fareTypes);
//				
				//Click on search
				WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
				search.click();
				
				Thread.sleep(5000);
				
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File destination = new File("screenshot.png");
				try {
					FileUtils.copyFile(screenshot,destination);
					System.out.println("screenshot saved successfully!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				driver.quit();

	}

}

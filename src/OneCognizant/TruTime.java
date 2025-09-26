package OneCognizant;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TruTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\kolar\\eclipse-workspace\\TruTime_OneC\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://onecognizant.cognizant.com/Home");
		
		
		
		driver.findElement(By.name("loginfmt")).sendKeys("2165284@cognizant.com");
		driver.findElement(By.id("idSIButton9")).click();
		
		driver.findElement(By.name("passwd")).sendKeys("SUMSUS&20247");
		driver.findElement(By.id("idSIButton9")).click();
		
		driver.quit();*/
		
		String myName = "My name is 'Sumant' and Kolar";
		String[] myNames = myName.split("'");
		System.out.println(myNames[2]);
	}

}

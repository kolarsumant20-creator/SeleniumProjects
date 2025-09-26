package OneCognizant;

import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

public static void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kolar\\eclipse-workspace\\TruTime_OneC\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String webTitle =  "https://www.amazon.in/";
		driver.get(webTitle);
		System.out.println("TITLE: "+driver.getTitle());
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static void main(String[] args) throws InterruptedException {
		
		openBrowser();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kolar\\eclipse-workspace\\TruTime_OneC\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String webTitle =  "https://www.amazon.in/";
		driver.get(webTitle);
		System.out.println("TITLE: "+driver.getTitle());
		
		Thread.sleep(20000);
		
		
		//signing in
		WebElement beforeSignIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		beforeSignIn.click();
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("Mymail@gmail.com");
		WebElement continueBut = driver.findElement(By.className("a-button-input"));
		continueBut.click();
		
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("MyPasscode");
		WebElement continueBut1 = driver.findElement(By.className("a-button-input"));
		continueBut1.click();
		
		//Search for campus shoes
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("campus shoes");
		
		Thread.sleep(2000);
		
		WebElement firstSearch = driver.findElement(By.xpath("//*[@aria-label='campus shoes for man']"));
		firstSearch.click();;
		
		//Window handle to the sub page
		String mainWindowHandle = driver.getWindowHandle();		
		WebElement campusShoe = driver.findElement(By.linkText("North Plus Men's Lace-Up Running Shoes"));
		campusShoe.click();
		Set <String> windowHandles = driver.getWindowHandles();
		
		for(String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
			}
		}
		WebElement NPMShoe = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		List<String> prices = new ArrayList<String>();
		prices.add(NPMShoe.getText());
		System.out.println(prices);
		
		
		driver.close();
		
		driver.quit();

	}

}

package OneCognizant;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormTest {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	//Initialize Browser
	public static void initDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	//Open Forms URL
	public static void openForms(String url) {
		driver.get(url);
		System.out.println("TITLE : "+ driver.getTitle());
	}
	
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public static void main(String[] args) {
		try {
			initDriver();
			openForms("https://demoqa.com/automation-practice-form");
		} finally {
			tearDown();
		}
	}
}
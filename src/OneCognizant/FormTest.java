package OneCognizant;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	
	//Enter Name
	public static void name(String FirstName, String LastName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(FirstName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys(LastName);
		
	}
	
	public static void emailNum(String emailID, String phoneNum) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys(emailID);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNumber"))).sendKeys(phoneNum);
		
	}
	
	public static void dateOfBirth(String year, String month, String date) {
		driver.findElement(By.id("dateOfBirthInput")).click();
		
		WebElement yearDropDown = driver.findElement(By.className("react-datepicker__year-select"));
		Select YearDD = new Select(yearDropDown);
		YearDD.selectByVisibleText(year);
		
		WebElement monthDropDown = driver.findElement(By.className("react-datepicker__month-select"));
		Select MonthDD = new Select(monthDropDown);
		MonthDD.selectByVisibleText(month);
		
		WebElement clickDate = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + date + "']"));
		clickDate.click();
		
	}	
	
	public static void gender(String Gender) {
		
		WebElement selectGender = driver.findElement(By.xpath("//label[@class='custom-control-label' and normalize-space(text())='" + Gender + "']"));
		selectGender.click();
		
	}
	
	public static void submit() {
		
		WebElement submitButton = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		submitButton.click();
	}
	
	public static void screenShot() {
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("SubmittedFile1.png");
		try {
			FileUtils.copyFile(screenshot,destination);
			System.out.println("screenshot saved successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			name("Ramesh","Surname");
			emailNum("MyMail@gmail.com", "9989966699");
			dateOfBirth("2000","January","1");
			gender("Male");
			submit();
			screenShot();
		} finally {
			tearDown();
		}
	}
}
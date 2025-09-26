package OneCognizant;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    // Initialize Browser
    public static void initDriver() {
        WebDriverManager.chromedriver().setup(); // No need for System.setProperty
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Amazon
    public static void openAmazon() {
        String url = "https://www.amazon.in/";
        driver.get(url);
        System.out.println("TITLE: " + driver.getTitle());
    }

    // Sign In
    public static void signIn(String emailId, String password) {
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(emailId);
        driver.findElement(By.id("continue")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
    }

    // Search Product
    public static void searchProduct(String product) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(product);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='campus shoes for man']"))).click();
    }

    // Select Product and Switch to New Tab
    public static void selectProduct(String productLinkText) {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.linkText(productLinkText)).click();

        // Switch to child tab
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
            }
        }
    }

    // Get Product Price
    public static List<String> getProductPrices() {
        List<String> prices = new ArrayList<>();
        WebElement priceElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='a-price-whole'])[1]")));
        prices.add(priceElement.getText());
        return prices;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        try {
            initDriver();
            openAmazon();
            signIn("kolarsumant20@gmail.com", "Sumant@20247");
            searchProduct("campus shoes");
            selectProduct("North Plus Men's Lace-Up Running Shoes");
            List<String> prices = getProductPrices();
            System.out.println("Product Prices: " + prices);
        } finally {
            tearDown();
        }
    }
}

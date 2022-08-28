package variouspackage;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng {
	WebDriver driver;
	String browser;
	String url;

	//String browser1 = null;
	// storing web element( By type element list)

	By usernamefiled = By.xpath("//input[@id='username']");
	By passwordfiled = By.xpath("//input[@id='password']");
	By signinfiled = By.xpath("//button[@class='btn btn-success block full-width']");
	By dashboardfiled = By.xpath("//h2[@style='color: #2F4050; font-size: 16px; font-weight: 400; margin-top: 18px']");
	By transactionfiled = By.xpath("//i[@class='fa fa-database']/following-sibling::span[1]");
	By newdepositfiled = By.xpath("//a[contains(text(),'New Deposit')]");
	By accountfiled = By.xpath("//select[@name='account']");

	By amountfiled = By.xpath("//input[@name='amount']");
	By submitfiled = By.xpath("//button[@id='submit']");
	By descriptionfiled = By.xpath("//input[@name='description']");
	
	@BeforeClass
	public void readingconfig() {
		//inputStrem//BufferedReader //FileReader// Scanner
		
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		
		
		}catch(IOException e)
{	e.printStackTrace();
		}
		}
	

@BeforeMethod
	public void init() {
	
	if(browser.equalsIgnoreCase( "chrome") ){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\diyor\\selenium\\class3\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if (browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\diyor\\selenium\\class5part2\\driver\\geckodriver.exe");
		driver =new FirefoxDriver();
	}
	
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\diyor\\selenium\\class3\\driver\\chromedriver.exe");
//	driver = new ChromeDriver();
//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\diyor\\selenium\\class5part2\\driver\\geckodriver-v0.31.0-win32\\geckodriver.exe");
//	driver =new FirefoxDriver();
//	
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void logintest() {
		System.out.println("testing");
		driver.findElement(usernamefiled).sendKeys("demo@techfios.com");
		driver.findElement(passwordfiled).sendKeys("abc123");
		driver.findElement(signinfiled).click();
		
		Assert.assertEquals(driver.findElement(dashboardfiled),"Dashboard","page not found");
	}
	
//	@Test
//	public void logintest1() {
//		System.out.println("testing");
//		driver.findElement(usernamefiled).sendKeys("demo@techfios.com");
//		driver.findElement(passwordfiled).sendKeys("abc123");
//		driver.findElement(signinfiled).click();
//	}
}

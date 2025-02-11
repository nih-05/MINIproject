package Home;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	WebDriver driver;
	
	@BeforeTest
	
	@Parameters("browser")
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@org.testng.annotations.Test
	public void test01() throws InterruptedException
	{
		page pg=new page(driver);
		
		pg.cart();
		pg.jack();
		pg.purplejac();
		pg.addcart();
		pg.shippingaddress();
	}
	
	@AfterTest
	public void end()
	{
		driver.close();
	}
}

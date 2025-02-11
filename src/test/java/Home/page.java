package Home;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class page {
	
	WebDriver driver;
	
	public page(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//span[text()='Women']"))WebElement women;
    @FindBy(xpath=("//span[text()='Men']"))WebElement men;
    
    @FindBy(xpath=("//a[@title='Radiant Tee']"))WebElement tee;
    @FindBy(xpath=("//div[@option-id='167']"))WebElement size;
    @FindBy(xpath=("//div[@option-id='56']"))WebElement colour;
    @FindBy(id=("qty"))WebElement quantity;
    @FindBy(xpath=("//button[@title='Add to Cart']"))WebElement cart;
    
    @FindBy(xpath=("//span[text()='Tops']"))WebElement top;
    @FindBy(xpath=("//span[text()='Jackets']"))WebElement jac;

	@FindBy(xpath=("//div[text()='Style']"))WebElement style;
	@FindBy(xpath=("//li[@class='item']//child::a"))WebElement insulated;
	@FindBy(xpath=("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/div/strong/a"))WebElement purple;
	
	@FindBy(xpath=("/html/body/div[2]/header/div[2]/div[1]/a"))WebElement mycart;
	@FindBy(xpath=("//button[@title='Proceed to Checkout']"))WebElement checkout;
	
	@FindBy(xpath=("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[1]/fieldset/div/div/input"))WebElement email;
	@FindBy(xpath=("//input[@name='firstname']"))WebElement Fname;
	@FindBy(xpath=("//input[@name='lastname']"))WebElement Lname;
	@FindBy(xpath=("//input[@name='street[0]']"))WebElement address;
	@FindBy(xpath=("//input[@name='city']"))WebElement city;
	@FindBy(xpath=("//select[@name='region_id']"))WebElement state;
	@FindBy(xpath=("//input[@name='postcode']"))WebElement pcode;
	@FindBy(xpath=("//select[@name='country_id']"))WebElement country;
	@FindBy(xpath=("//input[@name='telephone']"))WebElement phonenum;
	
	@FindBy(xpath=("//span[text()='Next']"))WebElement button;
	
	@FindBy(xpath=("//span[text()='Place Order']"))WebElement order;
	
	public void cart()
	{
		tee.click();
		size.click();
		
		colour.click();
		
		quantity.clear();
		quantity.sendKeys("10");
		
		cart.click();
	}
	
	public void jack()
	{
		Actions act=new Actions(driver);
		
		act.moveToElement(women);
		act.moveToElement(top);
		
		act.build().perform();
		
		jac.click();
		style.click();
		insulated.click();
	}
	
	public void purplejac()
	{	
		purple.click();
		size.click();
		colour.click();
		
		quantity.clear();
		quantity.sendKeys("1");
		
		cart.click();
	}
	
	public void addcart()
	{
		mycart.click();
		checkout.click();
	}
	
	public void shippingaddress() throws InterruptedException
	{
		email.sendKeys("test@test.com");
		Fname.sendKeys("Test01");
		Lname.sendKeys("LTest");
		address.sendKeys("TEST124568T");
		city.sendKeys("Testcity");
		
		pcode.sendKeys("682305");
		
		Select coun=new Select(country);
		coun.selectByVisibleText("Tokelau");
		
		phonenum.sendKeys("9875785446");
		
		Thread.sleep(3000);
		
		button.click();
		
		Thread.sleep(5000);
		
		order.click();
	}
}

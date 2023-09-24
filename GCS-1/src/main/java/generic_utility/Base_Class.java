package generic_utility;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import Data_Driven_Frame_Work.Web_Driver_Utility;
import object_repository.Home_Page;
import object_repository.Login_Page;
import object_repository.Time_Sheets;

public class Base_Class 
{
	Web_Driver_Utility WUTIL = new Web_Driver_Utility();
	public WebDriver driver = null ;
	
	//Creating Connection With DataBase
	@BeforeSuite(alwaysRun = true)
	public void establishDbConnection()
	{
		System.out.println("Connecton Establish sucessfull!!");
	}
	
	/**
	 * Launching Browser and GemPrsimManagement
	 * @throws Exception
	 */

	@BeforeClass(alwaysRun = true)
	public void LaunchingBrowser() throws Exception
	{
        driver = new ChromeDriver();
		String URL = WUTIL.getDataFromProperty("url");
		System.out.println("Chrome Browser Launched!!");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();  
	}

	/**
	 * Login GemPrism and credentials taken from properties file
	 * @throws Exception
	*/
	
	@BeforeMethod(alwaysRun = true)
	public void LoginGPM() throws Exception
	{
		String USERNAME = WUTIL.getDataFromProperty("username");
		String PASSWORD = WUTIL.getDataFromProperty("password");
	/*	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
    */
	    Login_Page LOGIN = new Login_Page(driver);
		LOGIN.loginPage(USERNAME,PASSWORD);
		
	     
		Time_Sheets log = new Time_Sheets(driver);
	    log.getLogEffortes();
	    
	    WebElement E1 =   driver.findElement(By.xpath("//div[@title='Log Efforts']"));
	    Thread.sleep(3000);
	    Actions Act = new Actions(driver);
	    Thread.sleep(3000);
	    Act.moveToElement(E1).click().build().perform();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='scale-x']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='New Timesheet']")).click();
		
			
	}
	
	@AfterMethod(alwaysRun = true)
	public void LogoutGPM()
	{
		//driver.findElement(By.xpath("//li[text()='Logout']")).click();
		Home_Page HOME = new Home_Page(driver);
	    HOME.getClickLogout();		    
	}
	
	/**
	 * Close the browser
    */
	
	@AfterClass(alwaysRun = true)
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	/**
	 * close the database connection
	*/
	
	@AfterSuite(alwaysRun = true)
	public void CloseConnection()
	{
		System.out.println("Connection Closed Successfully!!!");
	}
}

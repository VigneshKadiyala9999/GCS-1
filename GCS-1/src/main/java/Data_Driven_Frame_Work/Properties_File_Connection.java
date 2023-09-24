package Data_Driven_Frame_Work;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Properties_File_Connection 
{
	public static void main(String args[]) throws Exception 
	{
      FileInputStream FIS = new FileInputStream("C:\\Users\\vkadiyala\\Desktop\\Manual Testing\\SELENIUM\\LoginCredentilas.properties.txt");
      Properties pob = new Properties(); 
      pob.load(FIS);
      String USERNAME = pob.getProperty("username");
      String PASSWORD = pob.getProperty("password");
      String URL = pob.getProperty("url");
      String BROWSER = pob.getProperty("browser");
      WebDriver driver = new ChromeDriver();
      driver.get(URL);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize(); 
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
	  driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
      
	}
}

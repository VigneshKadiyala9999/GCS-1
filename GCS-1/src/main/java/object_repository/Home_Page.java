package object_repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Home_Page
{
	@FindBy(xpath = "(//div[@class='ant-menu-submenu-title'])[2]")
	private WebElement ClickHome;

	@FindBy(xpath = "//a[@href='/dashboard/employee']")
	private WebElement ClickEmployee;
	
	@FindBy(xpath ="li[text()='Logout']")
	private WebElement ClickLogout;
	

	public Home_Page(WebDriver driver) 
	{
       PageFactory.initElements(driver, this);   
	}

	public WebElement getClickHome() 
	{
		return ClickHome;
	}

	public WebElement getClickEmployee() 
	{
		return ClickEmployee;
	}
	
	public WebElement getClickLogout() 
	{
		return ClickLogout;
	}

	/**
	 * Business Library
	 * @return
	 */
	
	public void ClickonHome()
	{
		getClickHome().click();
	}
	
	public void ClickonEmployee()
	{
		getClickEmployee().click();
	}

    public void ClickOnLogout()
    {
    	getClickLogout().click();
    }
}
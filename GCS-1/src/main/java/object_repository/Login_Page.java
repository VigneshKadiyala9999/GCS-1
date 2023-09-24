package object_repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login_Page
{
	@FindBy(xpath = "//input[@type='text']")
	private WebElement UserName;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement UserPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SignInBtn;

	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName()
	{
		return UserName;
	}
	public WebElement getUserPassword()
	{
		return UserPassword;
	}
	public WebElement getSignInBtn()
	{
		return SignInBtn;
	}
	/**
	 * Business Library
	 * @return
	 */
	public void loginPage(String UserName ,String Password)
	{
		getUserName().sendKeys(UserName);
		getUserPassword().sendKeys(Password);
		getSignInBtn().click();
	}
}
package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Time_Sheets 
{
	@FindBy(xpath = "//div[@title='Log Efforts']")
	private WebElement LogEffortes;

	@FindBy(xpath = "//a[@class='scale-x']")
	private WebElement Submit;

	@FindBy(xpath = "//a[normalize-space()='New Timesheet']")
	private WebElement New_TimeSheet;

	public Time_Sheets(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);   
	}

	/**
	 * @return the logEffortes
	 */
	public WebElement getLogEffortes() 
	{
		return LogEffortes;
	}

	/**
	 * @return the submit
	 */
	public WebElement getSubmit() 
	{
		return Submit;
	}

	/**
	 * @return the new_TimeSheet
	 */
	public WebElement getNew_TimeSheet() 
	{
		return New_TimeSheet;
	}

	/**
	 * Business Library
	 * @return
	 */


	public void LogEffortes()
	{
		getLogEffortes().click();
	}
	public void Submit()
	{
		getSubmit().click();
	}
	public void New_TimeSheets()
	{
		getNew_TimeSheet().click();
	}
}

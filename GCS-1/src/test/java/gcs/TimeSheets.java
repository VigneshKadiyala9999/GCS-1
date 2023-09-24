package gcs;

import org.testng.annotations.Test;

import generic_utility.Base_Class;
import object_repository.Time_Sheets;
public class TimeSheets  extends Base_Class
{
	@Test
	public void GSE() throws Exception
	{
		Time_Sheets log = new Time_Sheets(driver); 
		Thread.sleep(3000);
		log.getLogEffortes();

	}
}

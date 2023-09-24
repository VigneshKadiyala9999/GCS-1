package gcs;
import org.testng.annotations.Test;
import generic_utility.Base_Class;
import object_repository.Home_Page;
public class Home extends Base_Class
{
@Test
public void GSE()
 {
   Home_Page HOME = new Home_Page(driver);  
   HOME.getClickHome();
 }
}
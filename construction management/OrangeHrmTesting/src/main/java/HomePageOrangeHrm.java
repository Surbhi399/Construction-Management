

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageOrangeHrm {
	
	WebDriver driver;
	public HomePageOrangeHrm(WebDriver driver)
	{
		this.driver = driver;
	}
public void ClickOnOrangeHrmLink()
{
	driver.findElement(By.linkText("OrangeHRM, Inc")).click();
}
}

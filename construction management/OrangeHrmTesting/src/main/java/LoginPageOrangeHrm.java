

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOrangeHrm {
	WebDriver driver;
	public LoginPageOrangeHrm(WebDriver driver)
	{
		this.driver = driver;
	}
	public void typeUsername()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		
	}
	public void typePassword()
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	public void clickOnLogin()
	{
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

}

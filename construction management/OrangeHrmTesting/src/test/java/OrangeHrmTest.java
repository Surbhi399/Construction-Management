import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class OrangeHrmTest {

	@Test
	public void DataValidity()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPageOrangeHrm l = new LoginPageOrangeHrm(driver);
		l.typeUsername();
		l.typePassword();
		l.clickOnLogin();
		
		HomePageOrangeHrm h = new HomePageOrangeHrm(driver);
		h.ClickOnOrangeHrmLink();
	}

}

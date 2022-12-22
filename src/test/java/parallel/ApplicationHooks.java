package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.ConfigReader;
import com.qa.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	WebDriver driver ;
	Properties prop;
	
	ConfigReader configreader;
	
	DriverFactory driverfactory;
	
	@Before(order = 0)
	public void getProperty()
	{
		 configreader = new ConfigReader();
		prop = configreader.readConfig();
	}
	
	
	@Before(order = 1)
	public void launchBrowser()
	{
		String browsername = prop.getProperty("browser");
		
		 driverfactory = new DriverFactory();
		 
	 driver = driverfactory.initDriver(browsername);
	}
	
	
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	
	@After(order = 1)
	public void tearDown(Scenario sc)
	{
		if(sc.isFailed())
		{
			String nameofscenario = sc.getName();
			
			String scrname = nameofscenario.replaceAll(" ", "_");
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			
			sc.attach(source, "image/png", scrname);
			
			
		}
	}

}

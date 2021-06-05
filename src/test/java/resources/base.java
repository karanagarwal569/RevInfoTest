package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public base() {
		// TODO Auto-generated constructor stub
	}

	
	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\data.properties");
		prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		//String browserName=System.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			String chomrepath= System.getProperty("user.dir")+"\\src\\test\\java\\resources\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chomrepath );
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);

		}
		else if(browserName.equals("firefox"))
		{
			String firefoxpath= System.getProperty("user.dir")+"\\src\\test\\java\\resources\\gecko.exe";
			
			System.setProperty("webdriver.gecko.driver",firefoxpath );
			driver=new ChromeDriver();
		}
		else if(browserName.equals("IE")) {
			String iepath= System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ie.exe";
			
			System.setProperty("webdriver.ie.driver",iepath);
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenShotPath(String st,WebDriver d) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot) d;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dfile=System.getProperty("user.dir")+"\\reports\\"+st+".png";
		FileUtils.copyFile(source,new File(dfile));
		return dfile;
	}
	
	
}

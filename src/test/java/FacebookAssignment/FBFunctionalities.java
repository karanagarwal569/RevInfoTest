package FacebookAssignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.FBChangePassword;
import pageObjects.FBLogin;
import pageObjects.FBPostStatus;
import resources.ExcelUtilities;
import resources.base;

public class FBFunctionalities extends base {

	public static WebDriver driver;
	public FBFunctionalities() {
		
	}

	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url").toString());
		
	}
	
	@DataProvider
	public String[][] getLoginData()
	{
		String[][] data=new String[1][3];
		
		String excelpath=System.getProperty("user.dir")+"\\src\\test\\java\\resources\\myone.xlsx";
		String sheetname="Sheet1";
		try {
			ExcelUtilities.readExcelFile(excelpath);
			String email= ExcelUtilities.readData(sheetname, "UserEmail", 1);
			String password= ExcelUtilities.readData(sheetname, "Password", 1);
			String username= ExcelUtilities.readData(sheetname, "Username", 1);
			data[0][0]=email;
			data[0][1]=password;
			data[0][2]=username;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="getLoginData",priority=1)
	public void loginIntoFB(String email,String password,String username) throws Exception
	{
		FBLogin fbl=new FBLogin(driver);
		fbl.setEmail(email);
		fbl.setPassword(password);
		fbl.clickLoginBtn();
		//Thread.sleep(30000);
		
		
		
		
	}
	
	@Test(priority=3)
	public void postStatus()
	{
		FBPostStatus fbp=new FBPostStatus(driver);
		//fbp.clickCreateStatus();
		//fbp.setStatus("Hello World");
		//fbp.clickPostStatus();
		
		
	}
	
	@Test(priority=2)
	public void changePassword() throws InterruptedException
	{
		FBChangePassword fbc=new FBChangePassword(driver);
		fbc.clickAccount();
		fbc.clickSettingAndPrivacy();
		fbc.clickPrivacyShortcut();
		Thread.sleep(10000);
		fbc.clickChangePassword();
		fbc.setCurrentPasword("a5s6ihxta");
		fbc.setNewPasword("a5s6ihxtan");
		fbc.setReNewPasword("a5s6ihxtan");
		fbc.clickSaveChanges();
		
	}
	
	
	
	
	
	@AfterTest
	public void teardown()
	{
	//	driver.close();
	}
	
	
}

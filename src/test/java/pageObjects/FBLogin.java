package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBLogin {
	WebDriver driver;
	public FBLogin(WebDriver driver) {
		this.driver=driver;
	}
	By email=By.id("email");
	By password=By.id("pass");
	By loginbtn=By.name("login");
	
	public void setEmail(String Email)
	{
		driver.findElement(email).sendKeys(Email);;
	}
	
	public void setPassword(String Password)
	{
		driver.findElement(password).sendKeys(Password);;
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(loginbtn).click();
	}

}

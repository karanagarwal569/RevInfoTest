package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBPostStatus {
	WebDriver driver;
	public FBPostStatus(WebDriver driver) {
		this.driver=driver;
	}
	By btncreatestatus=By.xpath("//span[contains(text(),'on your mind')]");
	By txtstatus=By.xpath("//*[@id='mount_0_0_8e']/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[2]/div/div/div");
	By btnsendpost=By.xpath("//*[@id='mount_0_0_8e']/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[3]/div[2]/div/div");
	
	public void clickCreateStatus()
	{
		driver.findElement(btncreatestatus).click();
	}
		
	public void setStatus(String Status)
	{
		driver.findElement(txtstatus).sendKeys(Status);;
	}
	
	public void clickPostStatus()
	{
		driver.findElement(btnsendpost).click();
	}
	

}

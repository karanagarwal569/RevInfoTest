package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBPostStatus {
	WebDriver driver;
	public FBPostStatus(WebDriver driver) {
		this.driver=driver;
	}
	By btncreatestatus=By.xpath("//span[contains(text(),'on your mind')]");
	By txtstatus=By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[2]/div/div/div/div");
	By btnsendpost=By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[3]/div[2]/div/div/div[1]");
	By txtpost=By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/div[3]/div/div[4]/div/div[1]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[3]/div/div/div/div");
	
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
	
	public String getPost()
	{
		return driver.findElement(txtpost).getText();
		
	}

}

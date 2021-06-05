package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBChangePassword {

	WebDriver driver;
	public FBChangePassword(WebDriver driver) {
		this.driver=driver;
	}
	
	By btnaccount=By.cssSelector("body._6s5d._71pn._-kb.segoe:nth-child(2) div.rq0escxv.l9j0dhe7.du4w35lb div.ehxjyohh.kr520xx4.poy2od1o.b3onmgus.hv4rvrfc.n7fi1qx3:nth-child(4) div.du4w35lb.l9j0dhe7.byvelhso.rl25f0pe.j83agx80.bp9cbjyn:nth-child(1) span.tojvnm2t.a6sixzi8.abs2jz4q.a8s20v7p.t1p8iaqh.k5wvi7nf.q3lfd5jv.pk4s997a.bipmatt0.cebpdrjk.qowsmv63.owwhemhu.dp1hu0rb.dhp61c6y.iyyx5f41:nth-child(1) div.j83agx80.l9j0dhe7 > div.oajrlxb2.tdjehn4e.qu0x051f.esr5mh6w.e9989ue4.r7d6kgcz.rq0escxv.nhd2j8a9.j83agx80.p7hjln8o.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.jb3vyjys.rz4wbd8a.qt6c0cv9.a8nywdso.i1ao9s8h.esuyzwwr.f1sip0of.lzcic4wl.l9j0dhe7.abiwlrkh.p8dawk7l.bp9cbjyn.s45kfl79.emlxlaya.bkmhp75w.spb7xbtv.rt8b4zig.n8ej3o3l.agehan2d.sk4xxmp2.taijpn5t.qypqp5cg.q676j6op:nth-child(1)");
	By btnsettingandprivacy=By.xpath("//span[contains(text(),'Settings & privacy')]");
	By btnprivacyshortcut=By.xpath("//span[contains(text(),'Privacy shortcuts')]");
	By btnleave=By.xpath("//span[contains(text(),'Leave')]");
	By btnchangepassword=By.xpath("//div[contains(text(),'Change your password')]");
	By currentpwd=By.id("password_old");
	By newpassword=By.id("password_new");
	By renewpassword=By.id("password_confirm");
	By btnsavechanges=By.xpath("//input[@value='Save Changes']");
	By btnStayLogin=By.xpath("//*[@class='_55sh uiInputLabelInput']");
	By btnContinue=By.xpath("//*[contains(text(),'Continue')]");
	
	public void clickAccount()
	{
		driver.findElement(btnaccount).click();
	}
	
	public void clickSettingAndPrivacy()
	{
		driver.findElement(btnsettingandprivacy).click();
	}
	
	public void clickPrivacyShortcut()
	{
		driver.findElement(btnprivacyshortcut).click();
	}
	
	public void clickLeave()
	{
		driver.findElements(btnleave).get(1).click();
	}
	
	public void clickChangePassword()
	{
		driver.switchTo().frame(0);
		driver.findElement(btnchangepassword).click();
		driver.switchTo().parentFrame();
	}
	
	public void setCurrentPasword(String CurrentPassword)
	{
		driver.switchTo().frame(0);
		driver.findElement(currentpwd).sendKeys(CurrentPassword);
	}
	
	public void setNewPasword(String NewPassword)
	{
		driver.findElement(newpassword).sendKeys(NewPassword);
	}
	
	public void setReNewPasword(String ReNewPassword)
	{
		driver.findElement(renewpassword).sendKeys(ReNewPassword);
	}
	
	public void clickSaveChanges()
	{
		driver.findElement(btnsavechanges).click();
	}

	public void clickStayLogin()
	{
		driver.findElements(btnStayLogin).get(5).click();
	}
	
	public void clickContinue()
	{
		driver.findElement(btnContinue).click();
		driver.switchTo().parentFrame();
	}
	
}

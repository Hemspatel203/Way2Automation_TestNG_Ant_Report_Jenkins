package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.RegisterPage;

public class RegisterTest {
	RegisterPage rp = new RegisterPage();

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		rp.openBrowser();
		rp.openSite();
	}
	

	@AfterClass
	public void afterClass() {
		rp.closeBrowser();
	}
	

	@Test(priority=1)
	public void checkOpenRegistrationBoxNewWindow() throws InterruptedException {
		rp.openRegisterPage();
		//System.out.println(rp.checkNewWindowTitle());
		//Assert.assertEquals(rp.checkRegisterBoxText(),"REGISTRATION FORM");
		Thread.sleep(3000);
		Assert.assertTrue(rp.checkPresenceofRegisterBox(), "RegisterBox Present");
		
	
		//System.out.println(rp.registerBox());
	}
	
	@Test(priority=2, dependsOnMethods= {"checkOpenRegistrationBoxNewWindow"})
	public void enterExistingUserRegistrationData() throws InterruptedException {
		rp.enterName();
		rp.enterPhone();
		rp.enterEmail();
		rp.enterCountry();
		rp.enterCity();
		rp.enterUserName();
		rp.enterPassword();
		rp.enterSubmit();
		if(rp.checkPresenceofRegisterBox()) {
			
			Assert.assertEquals(rp.getAlertMessage(),"Username or Password already exists.");
		}
		
	}
	@Test(priority=3, dependsOnMethods= {"enterExistingUserRegistrationData"})
	public void enterLogin() throws InterruptedException {
		rp.getLoginForm();
		rp.enterSignInUsername();
		rp.enterSignInPassword();
		rp.clickSiginInSubmitButton();
		
		Assert.assertEquals(rp.checkPresenceofLoginBox(),true);
	}
	
	

}

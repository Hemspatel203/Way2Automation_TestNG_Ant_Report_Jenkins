package test;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
		rp.closeNewWindow();
	}
	

	@Test
	public void checlOpenRegistrationBoxNewWindow() throws InterruptedException {
		rp.openRegisterPage();
		//System.out.println(rp.checkNewWindowTitle());
		//Assert.assertEquals(rp.checkRegisterBoxText(),"REGISTRATION FORM");
		Thread.sleep(3000);
		Assert.assertTrue(rp.checkPresenceofRegisterBox(), "RegisterBox Present");
		
	
		//System.out.println(rp.registerBox());
	}
	
	@Test
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
	@Test
	public void enterLogin() throws InterruptedException {
		rp.getLoginForm();
		rp.enterSignInUsername();
		rp.enterSignInPassword();
		rp.clickSiginInSubmitButton();
		Assert.assertTrue(rp.checkPresenceofLoginBox(),"Login successfull");
	}
	
	

}

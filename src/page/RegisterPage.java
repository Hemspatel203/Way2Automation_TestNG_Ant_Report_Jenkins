package page;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import data.ReadXlsData;

public class RegisterPage {

	WebDriver driver;

	@FindBy(linkText = "Registration")
	static WebElement registerBox;

	@FindBy(xpath = "(//form[@id='load_form']/h3)[2]")
	static WebElement registerForm;
	
	@FindBy(xpath = "(.//*[@id='load_form'])[1]")
	static WebElement loginForm;
	
	@FindBy(name="name")
	static WebElement name;
	
	@FindBy(name="phone")
	static WebElement phone;
	
	@FindBy(name="email")
	static WebElement email;
	
	@FindBy(name="country")
	static WebElement country;
	
	@FindBy(name="city")
	static WebElement city;
	
	@FindBy(xpath=".//*[@id='load_form']/fieldset[6]/input")
	static WebElement username;
	
	@FindBy(xpath=".//*[@id='load_form']/fieldset[7]/input")
	static WebElement password;
	
	@FindBy(xpath="(.//*[@id='load_form'])[2]/div/div[2]/input")
	static WebElement submitButton;
	
	@FindBy(xpath=".//*[@id='alert']")
	static WebElement alert;
	
	@FindBy(xpath="(.//*[@id='load_form'])[2]/div/div[1]/p/a")
	static WebElement signInButton;
	
	@FindBy(xpath="(.//*[@id='load_form'])[2]/fieldset[1]/input")
	static WebElement signInUserName;
	
	@FindBy(xpath="(.//*[@id='load_form'])[2]/fieldset[2]/input")
	static WebElement signInPassword;

	@FindBy(xpath="(.//*[@id='load_form'])[2]/div/div[2]/input")
	static WebElement signInSubmit;
	
	
	static String error = "Username or Password already exists";
	
	public void openBrowser() {

		if (ReadXlsData.browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (ReadXlsData.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/SeleniumJars/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		PageFactory.initElements(driver, this);
	}

	public void closeBrowser() {

		driver.quit();
	}

	

	public void openSite() throws InterruptedException {

		driver.get(ReadXlsData.siteName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	public void openRegisterPage() throws InterruptedException {
		registerBox.click();
		Thread.sleep(3000);
	}

	public void newWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String mainwindow = iter.next();
		String childWindow = iter.next();
		
		driver.switchTo().window(childWindow);
	}

	public boolean checkPresenceofRegisterBox()
	{
		newWindow();
		return registerForm.isDisplayed();
	}
	
	public boolean checkPresenceofLoginBox()
	{
		newWindow();
		return loginForm.isDisplayed();
	}

//	public String checkRegisterBoxText() {
//		newWindow();
//		return registerForm.getText();
//	}
	
	public void enterName() {
		newWindow();
		
		name.sendKeys(ReadXlsData.name);
	}
	
	public void enterPhone() {
		newWindow();
		phone.sendKeys(ReadXlsData.phone);
	}
	public void enterEmail() {
		newWindow();
		email.sendKeys(ReadXlsData.email);
	}
	public void enterCountry() {
		newWindow();
		Select selectCountry = new Select(country);
		selectCountry.selectByValue("Canada");
	}
	public void enterCity() {
		newWindow();
		city.sendKeys(ReadXlsData.city);
	}
	public void enterUserName() {
		newWindow();
		username.sendKeys(ReadXlsData.uname);
	}
	public void enterPassword() {
		newWindow();
		password.sendKeys(ReadXlsData.pass);
	}
	
	public void enterSubmit() throws InterruptedException {
		newWindow();
		submitButton.click();
		Thread.sleep(2000);
	}
	
	public String getAlertMessage() {
		newWindow();
		return alert.getText();
	}
	
	public void getLoginForm() {
		newWindow();
		signInButton.click();
	}
	
	public void enterSignInUsername() {
		newWindow();
		signInUserName.sendKeys(ReadXlsData.uname);
	}
	
	public void enterSignInPassword() {
		newWindow();
		signInPassword.sendKeys(ReadXlsData.pass);
	}
	public void clickSiginInSubmitButton() throws InterruptedException {
		newWindow();
		signInButton.click();
		Thread.sleep(5000);
	}
}

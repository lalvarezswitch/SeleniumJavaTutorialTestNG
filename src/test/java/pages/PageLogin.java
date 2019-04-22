package pages;

//import java.io.File;
//import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	
	@FindBy(how=How.NAME,using="userName") //utilizando PageFactory
	private WebElement userFieldElement;
	//private By userField;
	@FindBy(how=How.NAME,using="password") //utilizando PageFactory
	private WebElement passwordFieldElement;
	//private By passwordField;
	private By loginButton;
	private By fields;
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		//userField = By.name("userName"); //Se elimina el utilizar PageFactory
		//passwordField = By.name("password"); //Se elimina el utilizar PageFactory
		loginButton = By.name("login");
		fields = By.tagName("input");
		PageFactory.initElements(driver, this); //utliizando PageFactory
	}
	
	public void login(String user, String pass) {
		userFieldElement.sendKeys(user); //utilizando PageFactory		
		//driver.findElement(userField).sendKeys(user);
		passwordFieldElement.sendKeys(pass); //utilizando PageFactory
		//driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(loginButton).click();
		//Para poder exportar imagenes del test
		/*File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("LOGIN "+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Esto se sustituye por los Implicit Wait
		//Helpers helper = new Helpers();
		//helper.sleepSeconds(4);
	}
	
	public void fields_login(String user, String pass) {
		List<WebElement> loginFields = driver.findElements(fields);
		loginFields.get(1).sendKeys(user);
		loginFields.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyFields() {
		List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(loginFields.size());
		Assert.assertTrue(loginFields.size()==5);
	}
}

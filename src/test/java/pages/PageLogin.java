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
	
	@FindBy(how=How.NAME,using="userName") //utilizando PageFactory, aqui se busca ya el elemento.
	//@FindBy(name="userName") //también se puede utilizar así, pero la de arriba es más explícita
	private WebElement userFieldElement;
	//private By userField;
	@FindBy(how=How.NAME,using="password") //utilizando PageFactory
	private WebElement passwordFieldElement;
	//private By passwordField;
	@FindBy(how=How.NAME,using="login") //utilizando PageFactory
	private WebElement loginButtonElement;
	//private By loginButton;
	@FindBy(how=How.TAG_NAME,using="input") //utilizando Pagefactory
	private List<WebElement> fields;
	//private By fields;
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		//userField = By.name("userName"); //Se elimina el utilizar PageFactory
		//passwordField = By.name("password"); //Se elimina el utilizar PageFactory
		//loginButton = By.name("login"); //Se elimina el utilizar PageFactory
		//fields = By.tagName("input"); /Se elimina el utilizar PageFactory
		PageFactory.initElements(driver, this); //utilizando PageFactory
	}
	
	public void login(String user, String pass) {
		userFieldElement.sendKeys(user); //utilizando PageFactory		
		//driver.findElement(userField).sendKeys(user);
		passwordFieldElement.sendKeys(pass); //utilizando PageFactory
		//driver.findElement(passwordField).sendKeys(pass);
		loginButtonElement.click();
		//driver.findElement(loginButton).click(); 
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
		//List<WebElement> loginFields = driver.findElements(fields); //al utilizar el Page factory ya no hace falta
		fields.get(1).sendKeys(user);
		fields.get(2).sendKeys(pass);
		//loginFields.get(1).sendKeys(user); //al utilizar el Page factory ya no hace falta
		//loginFields.get(2).sendKeys(pass); //al utilizar el Page factory ya no hace falta
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyFields() {
		//List<WebElement> loginFields = driver.findElements(fields); //al utilizar el Page factory ya no hace falta
		//System.out.println(fields.size());
		Assert.assertTrue(fields.size()==5);
		//System.out.println(loginFields.size()); //al utilizar el Page factory ya no hace falta
		//Assert.assertTrue(loginFields.size()==5);  //al utilizar el Page factory ya no hace falta
	}
	
	public void putTitleInUserField() {
		String title = driver.getTitle();
		userFieldElement.sendKeys(title);
		Assert.assertEquals("Welcome: Mercury Tours", title);
	}
}

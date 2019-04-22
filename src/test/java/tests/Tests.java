package tests;

//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Screenshooter;
import helpers.WebDriverManager;
//import helpers.Helpers;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Tests {
	private WebDriver driver;
	ArrayList<String> tabs;
	
	@BeforeMethod
	public void setUp() {
		//DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize(); //esto es para maximizar la ventana del navegador
		//driver.manage().window().fullscreen(); //esto es para poner en fullscreen la ventana del navegador
		/*driver.manage().window().setSize(new Dimension(200,200));
		for (int i = 0; i <= 800; i++) {
			driver.manage().window().setPosition(new Point(i,i));
		}*/
		//driver.manage().window().setPosition(new Point(800,200)); //posicionando la ventana del navegador
		driver.navigate().to("http://newtours.demoaut.com/");
		//Este codigo de abajo permite abrir otra ventana en el navegador
		//JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		//String googleWindow = "window.open('http://www.google.com')";
		//javaScriptExecutor.executeScript(googleWindow);
		//tabs = new ArrayList<String> (driver.getWindowHandles());
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		//Helpers helper = new Helpers();
		//helper.sleepSeconds(4);
	}
	
	@Test
	public void loginIncorrecto() {
		WebDriverManager.setWindowSize(driver, "maximized");
		//Aca estoy manejando los tabs del navegador
		//driver.switchTo().window(tabs.get(1)).navigate().to("http://www.youtube.com/user/Draculinio");
		//driver.switchTo().window(tabs.get(0));
		//***código A****
		PageLogin pageLogin = new PageLogin(driver);
		PageLogon pageLogon =  new PageLogon(driver);
		pageLogin.login("user", "user");
		pageLogon.assertLogonPage();
		//***este código se cambió por A***
		/*driver.findElement(By.name("userName")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("login")).click();*/
		//****todo este código que se repite se cambió por B****
		/*try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		//****código B****
		/*Helpers helper = new Helpers();
		helper.sleepSeconds(4);*/
		//Este codigo paso a la Page Object, Page Logon
		//Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText().contains("Welcome back to"));
	}
	
	@Test
	public void login() {
		//WebDriverManager.setWindowSize(driver, "fullscreen");
		//****codigo A****
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation =  new PageReservation(driver);
		pageLogin.login("mercury", "imercury");
		pageReservation.assertPage();
		//****Este código se cambió por A****
		/*driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();*/
		//******todo este código que se repite se cambió por B****
		/*try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		//****código B****
		/*Helpers helper = new Helpers();
		helper.sleepSeconds(4);*/
		//este codigo pasa a la Page Object(page reservation)
		//Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText().contains("Flight Finder to search"));
	}
	
	@Test
	public void pruebaTres() {
		//WebDriverManager.setWindowSize(driver,400,400);
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation =  new PageReservation(driver);
		pageLogin.login("mercury", "mercury");
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("London");
	}
	
	@Test
	public void pruebaCantidadDeCampos() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()) {
			Screenshooter.takeScreenshot("Error", driver);
			//todo esto pasa a ser manejado en la clase Screenshooter
			/*File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(myScreenshot, new File("Error "+System.currentTimeMillis()+".png"));				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();*/
			}
		driver.close();
		//driver.switchTo().window(tabs.get(1)).close();
		//driver.switchTo().window(tabs.get(0)).close();
	}

}

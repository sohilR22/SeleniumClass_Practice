package com.StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Mercuryhomepage {

	// webdriver instance
	public static WebDriver driver;

	@Given("^open the chrome browser$")
	public void open_the_chrome_browser() {

		openChromeDriver();

	}

	@And("^user shold navigate to mercury home page successfully$")
	public void user_shold_navigate_to_mercury_home_page_successfully() {

		driver.get("https://demo.guru99.com/test/newtours/");

	}

	@And("^user Should  provide  validate credentional$")
	public void user_Should_provide_validate_credentional() throws Exception {

		WebElement userName = driver.findElement(By.cssSelector("[type='text']"));
		userName.click();
		userName.clear();
		userName.sendKeys("mercury");

		// Thread.sleep(5000);

		WebElement password = driver.findElement(By.cssSelector("[type='password']"));
		password.click();
		password.sendKeys("mercury");
		
		Mercuryhomepage.captureMultipleScreenShots(driver, "Home_Page");
		
	

	}

	@And("^user should click to the login button$")
	public void user_should_click_to_the_login_button() throws Exception {

		driver.findElement(By.cssSelector("[type='submit']")).click();

		String Login = driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]")).getText();
		System.out.println("Log-in successfully Text:   " + Login);
		
		Mercuryhomepage.captureMultipleScreenShots(driver, "Login_Page");
	
		// driver.quit();
		driver.close();

	}

	@And("^Validation of Home button$")
	public void validation_of_Home_button() throws Exception {

		WebDriverWait ExplicitWait = new WebDriverWait(driver, 30);
		ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Home')]"))).click();

		driver.navigate().back();
  
		Mercuryhomepage.captureMultipleScreenShots(driver, "Home page");
	}

	@And("^Validation of Flighs button$")
	public void validation_of_Flighs_button() throws Exception {

		try {

			driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();

		} catch (Exception error) {

			error.printStackTrace();

		}
          Mercuryhomepage.captureMultipleScreenShots(driver, "Flights button");
	}

	@When("^user provide his/her contact informaton$")
	public void user_provide_his_her_contact_informaton() {

		try {
			// driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

			WebDriverWait registerExplicitWait = new WebDriverWait(driver, 30);
			registerExplicitWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'REGISTER')]")))
					.click();

			WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
			FirstName.click();
			FirstName.clear();
			FirstName.sendKeys("ahamd");

			WebElement Lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
			Lastname.click();
			Lastname.clear();
			Lastname.sendKeys("Dawoodzie");

			WebElement Phone = driver.findElement(By.xpath("//input[@name='phone']"));
			Phone.click();
			Phone.sendKeys("444-333-9988");

			WebDriverWait ExplicitWait = new WebDriverWait(driver, 30);
			ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='userName']")))
					.sendKeys("ahamad.fahim@gmail.com");
			
             
			/*
			 * WebElement Email = driver.findElement(By.xpath("//input[@name='userName']"));
			 * Email.click(); Email.sendKeys("ahamad.fahim@gmail.com");
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user provide his\\/her mailling address")
	public void user_provide_his_her_mailling_address() {

		WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
		address.click();
		address.sendKeys("5500 ascot court unit 112");

		WebElement City = driver.findElement(By.xpath("//input[@name='city']"));
		City.click();
		City.sendKeys("Alexandira");

		WebElement State = driver.findElement(By.xpath("//input[@name='state']"));
		State.click();
		State.sendKeys("United State of America");

		WebElement Postalcode = driver.findElement(By.xpath("//input[@name='postalCode']"));
		Postalcode.click();
		Postalcode.sendKeys("22392");

		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select dropdowncountry = new Select(country);
		dropdowncountry.selectByVisibleText("ALGERIA");

	}

	@Then("^customer provide his/her user informaton$")
	public void customer_provide_his_her_user_informaton() {
		WebElement Username = driver.findElement(By.xpath("//input[@name='email']"));
		Username.click();
		Username.sendKeys("ahamd2");

		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		Password.click();
		Password.sendKeys("test123");

		WebElement confirmedpassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		confirmedpassword.click();
		confirmedpassword.sendKeys("test123");

		driver.findElement(By.xpath("//input[@name='submit']")).click();

		driver.close();

	}

	@When("user provide flight detail information")
	public void user_provide_flight_detail_information() {

		try {
			driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();

			WebElement passengerButton = driver.findElement(By.xpath("//select[@name='passCount']"));
			Select dropDown = new Select(passengerButton); // By using Select class we are able to implement the
			dropDown.selectByIndex(2); // OR this dropdwon perform the action

			WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
			Select dropdownDeparting = new Select(departingFrom);
			dropdownDeparting.selectByVisibleText("New York");

			WebElement month = driver.findElement(By.xpath("//select[@name='toMonth']"));
			Select dropdownForMonth = new Select(month);
			dropdownForMonth.selectByVisibleText("February");

			Thread.sleep(5000);

			WebElement Day = driver.findElement(By.xpath("//select[@name='toDay']"));
			Select dropdownDay = new Select(Day);
			dropdownDay.selectByIndex(15);

			WebElement Arrivingin = driver.findElement(By.xpath("//select[@name='toPort']"));
			Select dropdownArrivingin = new Select(Arrivingin);
			dropdownArrivingin.selectByVisibleText("Portland");

			WebElement returningMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
			Select dropdownReturining = new Select(returningMonth);
			dropdownReturining.selectByVisibleText("September");

			WebElement returningDay = driver.findElement(By.xpath("//select[@name='toDay']"));
			Select dropdownreturningDay = new Select(returningDay);
			dropdownreturningDay.selectByIndex(7);

		} catch (Exception error) {
			error.printStackTrace();
		}

	}

	@Then("user choose prefernces for flight catagories")
	public void user_choose_prefernces_for_flight_catagories() {
		WebElement radiobuttonforeconomyclass = driver.findElement(By.xpath("//input[@Value='Coach']"));
		radiobuttonforeconomyclass.click();
		System.out.println(radiobuttonforeconomyclass.isSelected());

		WebElement radiobuttonforbusinessclass = driver.findElement(By.xpath("//input[@Value='Business']"));
		radiobuttonforbusinessclass.click();
		System.out.println(radiobuttonforbusinessclass.isSelected());

		WebElement radiobuttonforfirstclass = driver.findElement(By.xpath("//input[@value='First']"));
		radiobuttonforfirstclass.click();
		radiobuttonforfirstclass.isSelected();
		radiobuttonforfirstclass.isDisplayed(); // is used for roadio button
		System.out.println(radiobuttonforfirstclass.isSelected());

	}

	@And("user choose airline")
	public void user_choose_airline() {
		WebElement Airline = driver.findElement(By.xpath("//select[@name='airline']"));
		Select dropdownAirline = new Select(Airline);
		dropdownAirline.selectByVisibleText("Pangea Airlines");

		driver.findElement(By.xpath("//input[@name='findFlights']")).click();

		driver.close();

	}

	@And("^Validation of Hotels button$")
	public void validation_of_Hotels_button() throws Exception {

		try {

			// Thread.sleep(3000);

			// driver.findElement(By.xpath("//a[contains(text(),'Hotels')]")).click();

			WebDriverWait ExplicitWait = new WebDriverWait(driver, 30);
			ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Hotels')]"))).click();
			
			

		} catch (Exception error) {

			error.printStackTrace();

		}
		Mercuryhomepage.captureMultipleScreenShots(driver, "Hotel button");
	}

	@And("^Validation of Car Rentals button$")
	public void validation_of_Car_Rentals_button() {

		try {

			// Thread.sleep(3000);
			// driver.findElement(By.xpath("//a[contains(text(),'Car Rentals')]")).click();

			WebDriverWait ExplicitWait = new WebDriverWait(driver, 30);
			ExplicitWait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Car Rentals')]")))
					.click();

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

	@And("^Validation of Cruises button$")
	public void validation_of_Cruises_button() throws Exception {

		try {

			WebDriverWait ExplicitWait = new WebDriverWait(driver, 30);
			ExplicitWait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Cruises')]")))
					.click();

			// driver.findElement(By.xpath("//a[contains(text(),'Cruises')]")).click();

		} catch (Exception error) {

			error.printStackTrace();

		}
        Mercuryhomepage.captureMultipleScreenShots(driver, "Cruises button");
	}

	@And("^Validation of Destinations$")
	public void validation_of_Destinations() {

		try {
			driver.findElement(By.xpath("//a[contains(text(),'Destinations')]")).click();

		} catch (Exception error) {

			error.printStackTrace();

		}

	}

	@And("^Validation of Vacation$")
	public void validation_of_Vacation() {
		driver.findElement(By.xpath("//a[contains(text(),'Vacations')]")).click();
		

		driver.close();

	}

	public static void fireFoxDriver() {

		// Executable path
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");

		// Instance for the webdriver and fireFoxdriver
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@SuppressWarnings("deprecation")
	public static void openChromeDriver() {

		// Thread.sleep(10000);

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void getURL() {

		driver.get("https://demo.guru99.com/test/newtours/");

	}

	public static WebElement windowhandle() {
		WebElement handle = null;

		driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);
		}

		return handle;

	}

	public static void captureMultipleScreenShots(WebDriver driver, String name) throws Exception {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("screenshots/"+System.currentTimeMillis()+ "____"+name+".png"));
	}

}

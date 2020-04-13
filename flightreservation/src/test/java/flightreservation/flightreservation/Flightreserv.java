package flightreservation.flightreservation;

import java.util.Iterator;
import java.util.Set;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
//import org.omg.CORBA.portable.ValueBase;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class Flightreserv {
	public static void main(String[] args) throws InterruptedException {
		// Setting up the system property.Running the script through the chrome driver
		// and set its location
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\K T KUMAR\\Desktop\\Masters\\second semester\\chromedriver_win32\\chromedriver.exe");

		// Instantiation of Chrome driver
		WebDriver driver = new ChromeDriver();

		// Passing the URL_Web aPplication that needs to be launched for testing
		driver.get("http://demo.guru99.com/test/newtours/");

		// Maximizes the chrome browser after launching the URL
		driver.manage().window().maximize();

		// Setting the browser to wait for 5 seconds to ensure the script is synchronous
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// TC_01_Verify whether the User is able to Login Successfuly with Valid default
		// Credentials

		// identified web element using By.Name and passing the user name
		driver.findElement(By.name("userName")).sendKeys("mercury");
		// identified web element using By.Name and passing the password
		driver.findElement(By.name("password")).sendKeys("mercury");
		// identified web element using By.Name and performing click action to navigate
		// to next page
		driver.findElement(By.name("submit")).click();

		// Storing the title of the Successfully logged in page
		String title = driver.getTitle();
		// Validation-Using if else to validate the successful login of the page-
		if (title.contentEquals("Login: Mercury Tours")) {
			System.out.println("PASS: TC_01_User should be able to login succesfully using default credentials");

		} else {
			System.out.println(
					"FAIL: TC_01_User should be able to login succesfully has Failed using defaukt credentials");
		}

		// Using Locator Linktext to Signoff from website
		driver.findElement(By.linkText("SIGN-OFF")).click();
		System.out.println("Sign off succesfully");

		// Setting the browser to wait for 5 seconds to ensure the script is synchronous
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// *****************************************END
		// TC_01***************************************************************

		// TC_02_Verify whether the User is able to Register Successfuly by providing
		// the details in the register page

		driver.findElement(By.linkText("REGISTER")).click();
		// Enter the first name
		driver.findElement(By.name("firstName")).sendKeys("hari");

		// Enter the last name
		driver.findElement(By.name("lastName")).sendKeys("hari");

		// Enter the phone
		driver.findElement(By.name("phone")).sendKeys("123456789");

		// Enter the email
		driver.findElement(By.id("userName")).sendKeys("hthia@mail.usf.edu");

		// Enter the address1
		driver.findElement(By.name("address1")).sendKeys("USF");

		// Enter the city
		driver.findElement(By.name("city")).sendKeys("tampa");

		// Enter the state
		driver.findElement(By.name("state")).sendKeys("Florida");

		// Enter the postal code
		driver.findElement(By.name("postalCode")).sendKeys("33705");

		// Finding the element country and keeping it in webelement instance
		WebElement country = driver.findElement(By.name("country"));

		// Passing the country object into the Select instance in order to select an
		// option from the dropdown list
		Select sel = new Select(country);
		sel.selectByVisibleText("UNITED STATES");

		// Registering with User name password and reenetering the password
		driver.findElement(By.id("email")).sendKeys("automation");

		driver.findElement(By.name("password")).sendKeys("automation");

		driver.findElement(By.name("confirmPassword")).sendKeys("automation");

		driver.findElement(By.name("submit")).click();

		// Validation of Registration using getCurrentURL which matches the URL while
		// running the script
		// with the URL given:
		if (driver.getCurrentUrl().contentEquals("http://demo.guru99.com/test/newtours/register_sucess.php")) {
			System.out.println("PASS:TC_02_User Account Registration has been sucessfully created ");
		} else {
			System.out.println("Fail:TC_02_User Acoount Registration has failed");
		}
		driver.findElement(By.linkText("sign-in")).click();
		// *****************************************END
		// TC_02***************************************************************

		// TC_03_Verify whether the User is able to Register Successfuly by providing
		// the details in the register page

		// Entering the registered account credentials
		driver.findElement(By.name("userName")).sendKeys("automation");
		driver.findElement(By.name("password")).sendKeys("automation");
		driver.findElement(By.name("submit")).click();
		// Validating the succesfull login of the page using the method getCurrentURL
		if (driver.getCurrentUrl().contentEquals("http://demo.guru99.com/test/newtours/login_sucess.php")) {
			System.out.println("PASS:TC_03_User Login succesfully using registered credentials ");
		} else {
			System.out.println("Fail:TC_03_User Login failed using registered credentials");
		}

		// *****************************************END
		// TC_03***************************************************************

		// TC_04_Verify whether the User is able to search for Flight details

		driver.findElement(By.linkText("Flights")).click();

		// Selecting the trip type using Xpath
		driver.findElement(By.xpath(".//input[@name='tripType' and @value='oneway']")).click();

		// Select the number of passengers
		WebElement passengers = driver.findElement(By.name("passCount"));
		Select sel1 = new Select(passengers);
		sel1.selectByVisibleText("2");

		// Select the Departure place
		WebElement from = driver.findElement(By.name("fromPort"));
		Select sel2 = new Select(from);
		sel2.selectByVisibleText("Frankfurt");

		// Select the Departure month
		WebElement frommonth = driver.findElement(By.name("fromMonth"));
		Select sel4 = new Select(frommonth);
		sel4.selectByVisibleText("April");

		// Select the Arrival place
		WebElement to = driver.findElement(By.name("toPort"));
		Select sel3 = new Select(to);
		sel3.selectByVisibleText("London");

		/*
		 * driver.findElement(By.id("closeBtn")).click(); Alert
		 * alert=driver.switchTo().alert(); alert.dismiss(); ChromeOptions option=new
		 * ChromeOptions(); option.add* Set<String> set = driver.getWindowHandles();
		 * set.iterator();
		 * 
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("document.getElementById('closeBtn').click();");
		 */

		// Select the Departure month
		WebElement tomonth = driver.findElement(By.name("toMonth"));
		Select sel5 = new Select(tomonth);
		sel5.selectByVisibleText("June");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
		driver.switchTo().defaultContent();

		// Selecting the Service type using Xpath for business class
		driver.findElement(By.xpath(".//input[@name='servClass' and @value='Business']")).click();

		// Select the Departure month
		WebElement airways = driver.findElement(By.name("airline"));
		Select sel6 = new Select(airways);
		sel6.selectByVisibleText("Blue Skies Airlines");

		driver.findElement(By.name("findFlights")).click();

		if (driver.getCurrentUrl().contentEquals("http://demo.guru99.com/test/newtours/reservation2.php")) {
			System.out.println("PASS:TC_04_Flight search has been succesfull for the user details ");
		} else {
			System.out.println("Fail:TC_04_Flight search has not been succesfull for the entered user details");
		}

		// *****************************************END
		// TC_04***************************************************************

		driver.findElement(By.xpath("//img[@src='images/home.gif']")).click();

		// identified web element using By.Name and passing the user name
		driver.findElement(By.name("userName")).sendKeys("automation");
		// identified web element using By.Name and passing the password
		driver.findElement(By.name("password")).sendKeys("auto");
		// identified web element using By.Name and performing click action to navigate
		// to next page
		driver.findElement(By.name("submit")).click();
		try {
			String error = driver.findElement(By.tagName("span")).getText();
			System.out.println(error);
			String errormsg = "Enter your userName and password correct";

			if (errormsg.equals(error)) {
				System.out.println("pass ");
			} else {
				System.out.println("fail");

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("dhkajhfajlfakl");
		}
	}

}

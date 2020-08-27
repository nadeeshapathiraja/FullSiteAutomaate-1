import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage {

	private WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		
		//For Chrome
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nadeesha\\Downloads\\Software\\Sel\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//For Firefox
		
		System.setProperty("webdriver.gecko.driver", "D:\\Eclipse Workspace\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://accounts.lambdatest.com/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
//		Check Correct Page
		WebElement text = driver.findElement(By.xpath("//h1[text()='Welcome Back !']"));
		String title =text.getText();
		if(title.equals("Welcome Back !")) {
			
			//Locating the email field element via Name tag and storing it in the webelement
	        WebElement email_field=driver.findElement(By.name("email"));
	        //Entering text into the email field
	        email_field.sendKeys("pdncpathiraja95@gmail.com");
	        
	        Thread.sleep(5000); 
	        
	        //Locating the password field element via Name tag and storing it in the webelement
	        WebElement password_field=driver.findElement(By.name("password"));	        
	        //Entering text into the password field
	        password_field.sendKeys("ucsc@123");
	        
	        //Clicking on the login button to login to the application   
	        driver.findElement(By.xpath("//button[text()='Login']")).click();

	        //Confirm for Go to the Correct Site
	        String titleNew = driver.getTitle();
	        if(titleNew.equals("Welcome - LambdaTest")) {
	        	System.out.println("LogIn Success");
	        }else {
	        	System.out.println("LogIn Fail");
	        }
	        
	        //After 5s Press Logout For back
	        Thread.sleep(5000); 
	        driver.findElement(By.xpath("//li[@class='nav-item dropdown user-name']//a[@id='navbarDropdown']//*[local-name()='svg']")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//a[text()='Logout']")).click();     
	        Thread.sleep(10000);
	        
	      //Confirm for Go back the Correct Site after press Logout
	        String titleBack = driver.getTitle();
	        if(titleBack.equals("Welcome Back !")) {
	        	System.out.println("LogOut Success");
	        }else {
	        	System.out.println("LogOut Fail");
	        }
	        
	        //Check Remember Me button
	        
	        
	        driver.findElement(By.xpath("//a[@class='googleSignInBtn']")).click();
	        Thread.sleep(5000);
	        
	      //Locating the password field element via Name tag and storing it in the webelement
	        WebElement Realemail = driver.findElement(By.xpath("//input[@type='email'][@name='identifier']"));
	        Realemail.sendKeys("nadeesha.ceilanco@gmail.com");
	        //click next button
	        driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
	        
	        WebElement RealPassword = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
	        Realemail.sendKeys("pdnc16381");

	      //click next button
	        driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
	        

	        
		}else {
			System.out.println("Wrong Page");
		}

		
		Thread.sleep(10000);
		// Close the Browser
		driver.close();

	}

	
}
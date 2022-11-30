package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F_TC1 {
	WebDriver driver;
	@Given("Open the browser")
	public void open_the_browser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 this.driver=new ChromeDriver();
		 driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	    //throw new io.cucumber.java.PendingException();
	}

	@And("user is able to login {string} and {string}")
	public void user_is_able_to_login_and(String string, String string2) {
		//username
		
				WebElement mobileno=driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
				mobileno.sendKeys(string);
				
			
				
			//password	
				WebElement password=driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
				password.sendKeys(string2);
				driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
	   // throw new io.cucumber.java.PendingException();
	}

	@Given("User enters {string} in search box")
	public void user_enters_in_search_box(String string) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[.='Login']")));
			

			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(string);
		
			driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	       
	    //throw new io.cucumber.java.PendingException();
	}

	@When("click on wishlist icon")
	public void click_on_wishlist_icon() {
		 WebElement icon=driver.findElement(By.xpath("(//div[@class='_36FSn5'])[1]"));
         
	        if(icon.isEnabled())
	        {
	        	System.out.println("Button is clickable");
	        }
	        else
	        	System.out.println("Button is not clickable");
	        driver.quit();
			
			
	   // throw new io.cucumber.java.PendingException();
	}

	@When("Wishlist icon should be clickable")
	public void wishlist_icon_should_be_clickable() {
		driver.findElement(By.xpath("(//div[@class='_36FSn5'])[1]")).click();
		
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("confirmation message should be displayed")
	public void confirmation_message_should_be_displayed() {
		String Confirmation=new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.className("_2sKwjB"))).getText();
		if(Confirmation.contains("Added to your Wishlist"))
		{
			System.out.println("Confirmation messege is displayed");
		}else
			System.out.println("Confirmation messege is not displayed");
	    //throw new io.cucumber.java.PendingException();
	}
String product;
	@Then("Product should be Added in wishlist")
	public void product_should_be_added_in_wishlist() {
		 this.product=driver.findElement(By.xpath("//div[@class='_4rR01T']")).getText();
		 driver.get("https://www.flipkart.com/wishlist?link=home_wishlist");
		 driver.navigate().refresh();
		 driver.navigate().refresh();

		
		String add=driver.findElement(By.xpath("(//div[@class='_3hscEA'])[1]")).getText();
		if(product.contains(add))
		{
			System.out.println("Added successfully");
		}else
			System.out.println("not added");
		
	   // throw new io.cucumber.java.PendingException();
	}
}

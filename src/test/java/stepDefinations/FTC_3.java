package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FTC_3 {
	WebDriver driver;
	@Given("Search product {string}")
	public void search_product(String string) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mac book");
	    //throw new io.cucumber.java.PendingException();
	}
	WebElement loginPage;
	@When("Login page should be displayed")
	public void login_page_should_be_displayed() {
		 this.loginPage=driver.findElement(By.className("_2MlkI1"));
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Product should not be added in wishlist")
	public void product_should_not_be_added_in_wishlist() {
		if(loginPage.isDisplayed())
		{
			System.out.println("user is not able to add product in wishlist without login");
		}
		else
			System.out.println("user is able to add product in wishlist without login");
		driver.quit();
	    //throw new io.cucumber.java.PendingException();
	}
}

package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F_TC2 {
	WebDriver driver;
	@Given("User is login {string} and {string}")
	public void user_is_login_and(String string, String string2) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(string);
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(string2);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();

	   // throw new io.cucumber.java.PendingException();
	}

	@And("Open the wishlist page")
	public void open_the_wishlist_page() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Login']")));
		driver.get("https://www.flipkart.com/wishlist?link=home_wishlist");
	    //throw new io.cucumber.java.PendingException();
	}
	String l1;

	@When("Click on delete button and cancel")
	public void click_on_delete_button_and_cancel() {
		try {
			WebElement list = driver.findElement(By.className("_3Juh7R"));
			if (list.isDisplayed()) {
				System.out.println("Wishlist is empty");
			}
		}catch (NoSuchElementException n) {
			WebElement deleteButton = driver.findElement(By.xpath("(//img[@class='_2Nq6Qc'])[1]"));
			if (deleteButton.isEnabled()) {
				System.out.println("Delete button is clickable");
			} else
				System.out.println("Delete button is not clickable");

			driver.findElement(By.xpath("(//img[@class='_2Nq6Qc'])[1]")).click();
			 this.l1 = driver.findElement(By.xpath("//div[@class='_3hscEA']")).getText();

			driver.findElement(By.xpath("//button[text()='CANCEL']")).click();
			}

	   // throw new io.cucumber.java.PendingException();
	}

	@And("Product should not be deleted")
	public void product_should_not_be_deleted() {
		driver.navigate().refresh();
		String l2 = driver.findElement(By.xpath("//div[@class='_3hscEA']")).getText();

		if (l1.equalsIgnoreCase(l2)) {
			System.out.println("cancel button is working");
		} else
			System.out.println("cancel button is not working");
	    //throw new io.cucumber.java.PendingException();
	}
	String l3;
	@And("Click on yes,confirm")
	public void click_on_yes_confirm() {
		 this.l3 = driver.findElement(By.xpath("//div[@class='_3hscEA']")).getText();
		driver.findElement(By.xpath("(//img[@class='_2Nq6Qc'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='YES, REMOVE']")).click();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Product should be deleted")
	public void product_should_be_deleted() {
		driver.navigate().refresh();
		driver.navigate().refresh();

		String l4 = driver.findElement(By.xpath("//div[@class='_3hscEA'][1]")).getText();

		if (l3.equalsIgnoreCase(l4)) {
			System.out.println("delete button is not working");
		} else
			System.out.println("delete button is working");

		driver.navigate().refresh();
	    //throw new io.cucumber.java.PendingException();
	}

}

package stepDefiniation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Steps {
	WebDriver driver;

	@Given("we should be in the home page")
	public void we_should_be_in_the_home_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AnandKR\\Desktop\\SDET Course\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Opened Browser");
		driver.get("http://elearningm1.upskills.in/index.php");
		System.out.println("Navigate to Login page");
	}

	@When("Enter the valid name {string}")
	public void enter_the_valid_name(String string) {
		driver.findElement(By.id("login")).sendKeys(string);
		System.out.println("Entered Username");
	}

	@When("Enter the valid password {string}")
	public void enter_the_valid_password(String string) {
		driver.findElement(By.id("password")).sendKeys(string);
		System.out.println("Entered Password");
	}

	@When("Click on the Validbutton")
	public void click_on_the_validbutton() {
		driver.findElement(By.id("form-login_submitAuth")).click();
		System.out.println("Clicked on Login Button");
	}

	@When("I see the name as {string}")
	public void i_see_the_name_as(String string) {
		driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/a")).click();
		System.out.println("Clicked on Login Button");
		String email = driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/ul/li[1]/div/p")).getText();
		if (string.contentEquals(email))
			System.out.println("Email is Matching :" + email);
		else
			System.out.println("Email is not Matching :" + email);
	}

	@When("go to compose")
	public void go_to_compose() {
		String text = driver.findElement(By.xpath("//*[@id='profile_block']/div[1]/a")).getAttribute("aria-expanded");
		if (text.contains("true")) {
			driver.findElement(By.xpath("//*[@id='profile_block']/div[1]/a")).click();
		}
		driver.findElement(By.xpath("//*[@id='profileCollapse']/div/ul/li[2]/a")).click();
		System.out.println("Clicked on Compose");
	}

	@When("Enter the send to")
	public void enter_the_send_to() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='compose_message']/fieldset/div[1]/div[1]/span/span[1]/span/ul/li/input"))
				.sendKeys("Naveen");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='compose_message']/fieldset/div[1]/div[1]/span/span[1]/span/ul/li/input"))
				.sendKeys(Keys.ENTER);
		System.out.println("Entered and selected the SEND TO");
	}

	@When("Enter the subject")
	public void enter_the_subject() throws InterruptedException {
		driver.findElement(By.id("compose_message_title")).sendKeys("Hi for Testing");
		Thread.sleep(5000);
		System.out.println("Entered the Subject");
	}

	@When("Add the body message {string}")
	public void add_the_body_message(String string) {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body")).sendKeys(string);
		driver.switchTo().defaultContent();
		System.out.println("Entered BODY message");
	}

	@SuppressWarnings("deprecation")
	@Then("Click on send message")
	public void click_on_send_message() throws Exception {
		driver.findElement(By.id("compose_message_compose")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/div/div[1]")).getText();
		if (text.contains("The message has been sent")) {
			System.out.println("The message has been sent Successfully");
			driver.close();
		} else {
			driver.close();
			throw new Exception("Failed to send the meassage");
		}
		System.out.println("Clicked on SEND MESSAGE button");
	}
}

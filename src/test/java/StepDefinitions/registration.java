package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class registration {
	
	WebDriver driver=null;
	
	
	public static void main(String[] args) throws InterruptedException {
		registration Registration = new registration();
		Registration.openLandingPage();
		Registration.Signin();
		Registration.createaccount();
		Registration.create_account();
		Registration.create_an_account();
		Registration.user_information();
		Registration.user_info();
		Registration.enter_details();
		Registration.click_register();
		Registration.user_homepage();
		
			}
	
	@Given("^user is on landing page$")
	public void openLandingPage() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().window().maximize();		
		driver.navigate().to("http://automationpractice.com/index.php");
		
	}
	
	@When("^user has clicked on the signin$")
	public void Signin() throws InterruptedException {
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);
	}
	@Then("^user can see login and registration page$")
	public void createaccount() throws InterruptedException {
		driver.getPageSource().contains("Create an account");
		Thread.sleep(2000);
		}
	
	@When("user enters valid email address")
	public void create_account() throws InterruptedException {
		driver.findElement(By.id("email_create")).sendKeys("etempuser@test.com");
	}
	
	@And("clicks on create account link")
	public void create_an_account() throws InterruptedException {
		driver.findElement(By.id("SubmitCreate")).click();
	}
	
	@Then("user should see personal information page")
	public void user_information() throws InterruptedException {
		driver.getPageSource().contains("YOUR PERSONAL INFORMATION");
		Thread.sleep(2000);
	}
	
	@Given("User is on the personal information page")
	public void user_info() throws InterruptedException {
		driver.getPageSource().contains("YOUR PERSONAL INFORMATION");
		Thread.sleep(2000);
	}
	
	@When("user provides valid details")
	public void enter_details() throws InterruptedException {
		
		driver.findElement(By.id("customer_firstname")).sendKeys("etemp");
		driver.findElement(By.id("customer_lastname")).sendKeys("user");
		driver.findElement(By.id("passwd")).sendKeys("password1");
		driver.findElement(By.id("address1")).sendKeys("1 seadrive");
		driver.findElement(By.id("city")).sendKeys("Florida");
		Select dropdown= new Select(driver.findElement(By.id("id_state")));
		dropdown.selectByValue("9");
		driver.findElement(By.id("postcode")).sendKeys("20090");
		driver.findElement(By.id("phone_mobile")).sendKeys("1234506789");
		Thread.sleep(2000);
		}
	
	@And("user clicks on register button")
	public void click_register() throws InterruptedException {
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);
	}
	
	@Then("User should see homepage with username and last name on the page")
	public void user_homepage() throws InterruptedException {
		String userdetails = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
		String ExpectedText = "etemp user";
		Assert.assertEquals(ExpectedText, userdetails);
		System.out.println(userdetails+" Registration completed successfully");
		Thread.sleep(2000);
		driver.close();
	}
}

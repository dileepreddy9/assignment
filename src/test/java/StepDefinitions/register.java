package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;


public class register {

	WebDriver driver=null;
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().window().maximize();		
		driver.navigate().to("http://automationpractice.com/index.php");
		
	    
	}

	@When("User clicks on Signin button")
	public void user_clicks_on_signin_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);
	    
	}
	
	@When("User creates an account with valid {string}")
	public void user_creates_an_account_with_valid(String EmailId) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("email_create")).sendKeys(EmailId);
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
		
		
	   
	}

	@When("Provide personal details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void provide_personal_details(String Title, String Firstname, String Lastname, String Password, String Birthday, String Birthmonth, String Birthyear, String Address, String City, String State, String Zip, String Mobile) {
	    // Write code here that turns the phrase above into concrete actions
	   /* WebElement Mr = driver.findElement(By.id("id_gender1"));
	    WebElement Mrs = driver.findElement(By.id("id_gender2"));
	    if(String Title="Mr") {
	    */
		driver.findElement(By.id("customer_firstname")).sendKeys(Firstname);
		driver.findElement(By.id("customer_lastname")).sendKeys(Lastname);
		driver.findElement(By.id("passwd")).sendKeys(Password);
		new Select(driver.findElement(By.id("days"))).selectByVisibleText(Birthday);
		new Select(driver.findElement(By.id("months"))).selectByVisibleText(Birthmonth);
		new Select(driver.findElement(By.id("years"))).selectByVisibleText(Birthyear);
		driver.findElement(By.id("address1")).sendKeys(Address);
		driver.findElement(By.id("city")).sendKeys(City);
		new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(State);
		driver.findElement(By.id("postcode")).sendKeys(Zip);
		driver.findElement(By.id("phone_mobile")).sendKeys(Mobile);
	    }
	

	@When("Click on Register button")
	public void click_on_register_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@id='SubmitCreate']/span")).click();
	}

	@Then("User validates {string}, {string} are correct")
	public void user_validates_are_correct(String Firstname, String Lastname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String actual_uname = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
		String expected_uname = Firstname + " " + Lastname;
		Assert.assertEquals(actual_uname, expected_uname);
		Thread.sleep(2000);	
	}

	@When("User clicks on Sign out button")
	public void user_clicks_on_sign_out_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(2000);
	}

	@Then("User logs off successfully")
	public void user_logs_off_successfully() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.getPageSource().contains("Sign in");
	    Thread.sleep(2000);
	}

	@When("User logs in with valid {string}, {string}")
	public void user_logs_in_with_valid(String EmailId, String Password) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("email")).sendKeys(EmailId);
		driver.findElement(By.id("passwd")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
	}
	
	@When("user navigates to tshirts and adds a product to cart")
	public void user_navigates_to_tshirts_and_adds_a_product_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
		driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
		String prod_name = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")).getText();
		String prod_price = driver.findElement(By.id("our_price_display")).getText();
		String prod_quantity = driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).getAttribute("value");
		String prod_color = driver.findElement(By.xpath("//*[@id=\"color_13\"]")).getAttribute("name");
		driver.findElement(By.xpath("//p[@id='add_to_cart']/button/span")).click();
		
		System.out.println(prod_name);
		System.out.println(prod_price);
		System.out.println(prod_quantity);
		System.out.println(prod_color);
	}
	
	
}

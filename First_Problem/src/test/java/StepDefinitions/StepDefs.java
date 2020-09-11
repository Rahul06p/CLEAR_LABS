package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	WebDriver driver;

	@Given("user is on Home Page")
	public void user_is_on_Home_Page() throws IOException{
		System.setProperty("webdriver.chrome.driver","H:\\Rahul\\First_Problem\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.orbitz.com");

		//File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(source_file, new File("H:\\screenshot.png"));
	}

	@When("user search for hotels")
	public void user_search_for_hotels() {

		driver.findElement(By.xpath("//*[@id=\"tab-hotel-tab-hp\"]")).click();
		System.out.println("Hotels tab clicked");
	}

	@When("user enters San Francisco in search bar")
	public void user_enters_San_Francisco_in_search_bar() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"hotel-destination-hp-hotel\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"hotel-destination-hp-hotel\"]")).sendKeys("San Francisco");
		driver.findElement(By.xpath("//*[@id=\"hotel-destination-hp-hotel\"]")).sendKeys(Keys.ENTER);
		System.out.println("San Francisco Entered");
	}

	@Then("user sees website logo")
	public void user_sees_website_logo() throws InterruptedException {


		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/header/section/div/div/a/img"));
		Thread.sleep(10000);
		System.out.println("3 Assertions for check- Logo, Support tab and Login tab");
		System.out.println("Logo displayed");
	}

	@Then("user sees support in header")
	public void user_sees_support_in_header() {

		driver.findElement(By.xpath("//*[@id=\"support-cs\"]/div"));

		System.out.println("Support Displayed");
	}

	@Then("user sees login option in header")
	public void user_sees_login_option_in_header() {

		driver.findElement(By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/button/div"));
		System.out.println("Login displayed");
	}

	@Then("user closes browser")
	public void user_closes_browser() {

		driver.quit();
	}

}

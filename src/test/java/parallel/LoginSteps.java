package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	String title;
	
	@Given("user is on landing page")
	public void user_is_on_landing_page() {
	   
		DriverFactory.getDriver().navigate().to("https://www.amazon.in/");
		
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
	   title = loginpage.getLoginPageTitle();
	  
	 System.out.println("Title of page is " + title);
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String titleofpage) {
	 boolean value= title.contains(titleofpage);
		Assert.assertTrue(value);
	}

	@Then("orders section should get display")
	public void orders_section_should_get_display() {
		boolean isorderdisplay = loginpage.isOrdersDisplayed();
		
		Assert.assertTrue(isorderdisplay);
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String string) {
	    loginpage.enterUsername();
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String string) {
		loginpage.enterPassword();
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginpage.clickOnSignin();
	}



}

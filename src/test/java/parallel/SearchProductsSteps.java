package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.SearchProducts;
import com.qa.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductsSteps {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	SearchProducts searchproduct;

	@Given("user should already be logged in with {string} and {string}")
	public void user_should_already_be_logged_in(String username, String password) {
		DriverFactory.getDriver().get("https://www.amazon.in/");
		searchproduct = loginpage.doLogin(username, password);

	}

	@When("user enter the text - {string} and search")
	public void user_enter_the_text_and_search(String text) {
		searchproduct.enterText(text);
	}

	@Then("mobile phone should get display")
	public void mobile_phone_should_get_display() {

		String titleofpage = searchproduct.titleOfPage();

		boolean ispresent = titleofpage.contains("mobile");

		Assert.assertTrue(ispresent);

	}

}

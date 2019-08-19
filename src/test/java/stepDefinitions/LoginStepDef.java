package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.LoginPage;

public class LoginStepDef {
	@Steps
	LoginPage loginPage;

	@Given("^Enter url into address bar in the browser$")
	public void user_is_able_to_launch_Grpevine_url() {
		loginPage.openUrl();
	}
	
	@Given("^Verify Login screen is displayed$")
	public void verify_Login_screen_is_displayed() {
		loginPage.verifyUserOnLoginScreen();
	}

	@When("^Enter valid email address and password$")
	public void input_user_id() {
		loginPage.inputEmail();
		loginPage.inputPassword();
	}
	
	@When("Enter invalid email address and password")
	public void enter_invalid_credentials() {
		loginPage.inputEmail();
		loginPage.inputInvalidPassword();
	}

	@When("^Click on I agree & sign in button$")
	public void click_on_Login() {
		loginPage.clickSignInButton();
	}

	@Then("^Verify home screen is displayed$")
	public void user_is_on_homepage() {
		loginPage.verifyUserIsOnHomePage();
	}
	
	@Then("^Verify appropriate error message is displayed$")
	public void exceptionOnLoginScreen() {
	    loginPage.exceptionOnLoginScreenInvalidPassword();
	}
	
	@Then("Verify Copyright message is displaying in left down corner in Login screen")
	public void verify_Copyright_message_is_displaying_in_left_down_corner_in_Login_screen() {
	    loginPage.verifyCopyrightMessageOnLogin();
	}

	@Then("Verify Copyright message is displaying in left down corner in all screens")
	public void verify_Copyright_message_is_displaying_in_left_down_corner_in_all_screens() {
	   loginPage.verifyCopyrightMessageOnAllPages();
	}
	
	@Then("Verify Year which is displaying in Copyright message is dynamic from server")
	public void verify_Year_which_is_displaying_in_Copyright_message_is_dynamic_from_server() {
	    loginPage.verifyCopyrightMessageIfDynamic();
	}
}

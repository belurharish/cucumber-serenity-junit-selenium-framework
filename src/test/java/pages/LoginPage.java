package pages;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import dataReader.PropertyReader;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

@DefaultUrl("https://parallax.ci.tmxdev.com/")
public class LoginPage extends PageObject {
	@FindBy(xpath = "//input[@type='email']")
	WebElementFacade email;

	@FindBy(xpath = "//input[@type='password']")
	WebElementFacade password;

	@FindBy(id = "sign-in")
	WebElementFacade signIn;

	@FindBy(xpath = "//span[text()='E-mail address/password is incorrect. Please try again.']")
	WebElementFacade invalidCredentialError;
	
	//##################################################################
	ETFFactSheetPage etfFactSheet;
	@Steps
	CommonPage commonPage;
	
	@Step("Open the application URL")
	public void openUrl() {
		this.openUrl(PropertyReader.read("app.url"));
	}
	
	@Step("Input the the email id")
	public void inputEmail() {
		email.waitUntilEnabled().sendKeys(PropertyReader.read("app.email"));
	}
	
	@Step("Input the password")
	public void inputPassword() {
		password.sendKeys(PropertyReader.read("app.password"));
	}
	
	@Step("Input the invalid password")
	public void inputInvalidPassword() {
		password.sendKeys("123436");
	}

	@Step("Click on 'Sign in' link")
	public void clickSignInButton() {
		signIn.click();
	}
	
	@Step("Verify that the user is on Home Page")
	public void verifyUserIsOnHomePage() {
		assertTrue(etfFactSheet.reactTable.waitUntilClickable().isVisible());
	}
	
	@Step("Exception on Login screen")
	public void exceptionOnLoginScreenInvalidPassword() {
		assertTrue(this.invalidCredentialError.waitUntilClickable().isDisplayed());
	}
	
	@Step
	public void loginToApp() {
		openUrl();
		inputEmail();
		inputPassword();
		clickSignInButton();
		verifyUserIsOnHomePage();
	}
	
	@Step
	public void verifyUserOnLoginScreen() {
		assertTrue(email.waitUntilVisible().isDisplayed());
	}
	
	@Step
	public void verifyCopyrightMessageOnLogin() {
		assertThat(commonPage.copyrightMsg.waitUntilVisible().isDisplayed(), is(true));
	}
	
	@Step
	public void verifyCopyrightMessageOnAllPages() {
		assertThat(commonPage.copyrightMsg.waitUntilVisible().isDisplayed(), is(true));
		commonPage.navigateToGrapevine();
		assertThat(commonPage.copyrightMsg.waitUntilVisible().isDisplayed(), is(true));
		commonPage.navigateToETFBrokerDashboard();
		assertThat(commonPage.copyrightMsg.waitUntilVisible().isDisplayed(), is(true));
		commonPage.navigateToOrderBookVisualizer();
		assertThat(commonPage.copyrightMsg.waitUntilVisible().isDisplayed(), is(true));
	}
	
	@Step
	public void verifyCopyrightMessageIfDynamic() {
		assertThat(commonPage.copyrightMsg.waitUntilVisible().getTextContent(), is("Copyright © "+ LocalDate.now().getYear()+" TSX Inc. All rights reserved."));
	}
}

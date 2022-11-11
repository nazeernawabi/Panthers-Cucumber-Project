package tek.sdet.framework.steps;

import org.junit.Assert;
import java.util.Map;
import java.util.List;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilties.CommonUtility;

public class SignInSteps extends CommonUtility {

	
	POMFactory factory = new POMFactory();
	
	
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
	click(factory.homePage().signIn);
	logger.info("user clicked on sign In option");
	
	}
	
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password)  {
		sendText(factory.signInPage().emailField,email);
		sendText(factory.signInPage().passwordField,password);
		logger.info("user entered email" +email+"and password"+password);
		
		
	}
	
	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.signInPage().loginButton);
		logger.info("user clicked on login button");
		
		
	}
	
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().account));
		logger.info("user logged in into the account");
	}
	
	@And("User click on create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().newAccountButton);
		logger.info("user clicked on Create New Account button");
	}
	
	@And("User fill the signUp informaton with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable data) {
		List<Map<String,String>>signUpData = data.asMaps(String.class,String.class);
		sendText(factory.signInPage().nameInput,signUpData.get(0).get("name"));
		sendText(factory.signInPage().emailInput,signUpData.get(0).get("email"));
		sendText(factory.signInPage().passwordInput,signUpData.get(0).get("password"));
		sendText(factory.signInPage().confirmPasswordInput,signUpData.get(0).get("confirmPassword"));
		logger.info("user entered required information into sign up form");
	}
	
	@And("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signInPage().signUpButton);
		logger.info("user clicked on sign up Button");
	}
	
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().profileImage));
		Assert.assertTrue(isElementDisplayed(factory.homePage().account));
		logger.info("Account was created");
	}
	
}
package stepDefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SignUpPage;
import pages.LoginPage;
import utils.DriverManager;
import utils.TestDataManager;
import org.testng.Assert;

public class SignUpSteps {
    private HomePage homePage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;
    public String testEmail;
    public String testPassword;
    
    
    
    @Given("User login to the Magento homepage")
    public void user_login_to_the_magento_homepage() {
        DriverManager.setDriver("chrome");
        homePage = new HomePage();
        homePage.navigateToHomePage();
    }
    
    @When("User click on Create an Account")
    public void user_click_on_create_an_account() {
        homePage.clickCreateAccount();
        signUpPage = new SignUpPage();
    }
    
    @When("User fill the signup form with valid details")
    public void user_fill_the_signup_form_with_valid_details() {
    	 String testEmail = "testuser" + (int)(Math.random() * 10000) + "@example.com";
         String testPassword = "TestPass123!";
         
         TestDataManager.setRegisteredCredentials(testEmail, testPassword);
         
         signUpPage.fillSignUpForm("John", "Doe", testEmail, testPassword);
    }
    
    @When("User click on Create an Account button")
    public void user_click_on_create_an_account_button() {
        signUpPage.clickCreateAccount();
    }
    
    @Then("User verify the account created successfully")
    public void user_verify_the_account_created_successfully() {
        Assert.assertTrue(signUpPage.isAccountCreated(), "Account creation failed");
        DriverManager.quitDriver();
    }
    
    @When("User click on Sign In")
    public void user_click_on_sign_in() {
        homePage.clickSignIn();
        loginPage = new LoginPage();
    }
    
    @When("User enter valid login credentials")
    public void user_enter_valid_login_credentials() {
    	
    	 String email = TestDataManager.getRegisteredEmail();
         String password = TestDataManager.getRegisteredPassword();
         loginPage.fillLoginForm(email, password);
    }
    
    @When("User click on Sign In button")
    public void user_click_on_sign_in_button() {
        loginPage.clickSignIn();
    }
    
    @Then("User Verify able to logged in successfully")
    public void user_verify_able_to_logged_in_successfully() {
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login failed");
        DriverManager.quitDriver();
    }
}
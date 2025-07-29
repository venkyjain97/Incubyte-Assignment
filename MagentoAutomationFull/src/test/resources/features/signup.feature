Feature: SignUp and Sign In
  As a new user
  I want to create an account and sign in
  So that I can access the website features

  @signup
  Scenario: Verify User is able to Create a new account successfully
    Given User login to the Magento homepage
    When User click on Create an Account
    And User fill the signup form with valid details
    And User click on Create an Account button
    Then User verify the account created successfully

  @signin
  Scenario: Verify User is able to Sign in with created account
    Given User login to the Magento homepage
    When User click on Sign In
    And User enter valid login credentials
    And User click on Sign In button
    Then User Verify able to logged in successfully
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    
    @FindBy(id = "firstname")
    private WebElement firstNameField;
    
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    
    @FindBy(id = "email_address")
    private WebElement emailField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;
    
    @FindBy(css = "button[title='Create an Account']")
    private WebElement createAccountButton;
    
    @FindBy(css = ".message-success")
    private WebElement successMessage;
    
    public void fillSignUpForm(String firstName, String lastName, String email, String password) {
        waitForElementToBeVisible(firstNameField);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }
    
    public void clickCreateAccount() {
        waitForElementToBeClickable(createAccountButton);
        createAccountButton.click();
    }
    
    public boolean isAccountCreated() {
        try {
            waitForElementToBeVisible(successMessage);
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
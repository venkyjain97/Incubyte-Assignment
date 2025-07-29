package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    
    @FindBy(id = "email")
    private WebElement emailField;
    
    @FindBy(id = "pass")
    private WebElement passwordField;
    
    @FindBy(id = "send2")
    private WebElement signInButton;
    
    public void fillLoginForm(String email, String password) {
        waitForElementToBeVisible(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }
    
    public void clickSignIn() {
        waitForElementToBeClickable(signInButton);
        signInButton.click();
    }
}
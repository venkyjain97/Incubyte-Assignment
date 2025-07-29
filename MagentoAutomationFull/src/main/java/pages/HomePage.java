package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;
    
    @FindBy(linkText = "Sign In")
    private WebElement signInLink;
    
    @FindBy(css = ".logged-in")
    private WebElement welcomeMessage;
    
    @FindBy(xpath="//span[text()='Open']/preceding::div/span[text()='Close']")
    public WebElement advClose;
    
    public void navigateToHomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
       
    }
    
    public void clickCreateAccount() {
        waitForElementToBeClickable(createAccountLink);
        createAccountLink.click();
        
        try {
        	if(advClose.isDisplayed()) {
            	advClose.click();
            }
        }catch(Exception e){
        	
        }
    }
    
    public void clickSignIn() {
        waitForElementToBeClickable(signInLink);
        signInLink.click();
    }
    
    public boolean isUserLoggedIn() {
        try {
            waitForElementToBeVisible(welcomeMessage);
            return welcomeMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
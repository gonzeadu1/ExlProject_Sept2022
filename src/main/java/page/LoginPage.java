package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Elements
    @FindBy(how = How.XPATH, using = "//*[@id=\"username\"]") WebElement USER_NAME_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
    @FindBy(how = How.XPATH, using =  "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_BUTTON_ELEMENT;



    //Interactable Methods
    public void enterUserName(String username){
        USER_NAME_ELEMENT.sendKeys(username);
    }

    public void insertPassword(String password){
        PASSWORD_ELEMENT.sendKeys(password);
    }
    public void clickOnSigninButton(){
        SIGNIN_BUTTON_ELEMENT.click();
    }
}

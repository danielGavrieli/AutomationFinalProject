package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy (id = "user-name")
    public WebElement txt_username;

    @FindBy (id = "password")
    public WebElement txt_password;

    @FindBy (id = "login-button")
    public WebElement btn_login;

}

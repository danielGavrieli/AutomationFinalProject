package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
    @FindBy (id = "first-name")
    public WebElement txt_firstName;

    @FindBy (id = "last-name")
    public WebElement txt_lastName;

    @FindBy (id = "postal-code")
    public WebElement txt_postalCode;

    @FindBy (className = "checkout_info")
    public WebElement form_Checkout;

    @FindBy (id = "cancel")
    public WebElement btn_cancel;

    @FindBy (id = "continue")
    public WebElement btn_continue;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement btn_menu;

    @FindBy (id = "shopping_cart_container")
    public WebElement btn_Cart;

    @FindBy (xpath = "//div[@class='header_secondary_container']/span")
    public WebElement head_Checkout;
}

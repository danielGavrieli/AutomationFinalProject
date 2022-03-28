package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage {
    @FindBy(xpath = "//div[@class='header_secondary_container']/span")
    public WebElement head_CheckoutComplete;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement btn_Menu;

    @FindBy (id = "shopping_cart_container")
    public WebElement btn_Cart;

    @FindBy (id = "back-to-products")
    public WebElement btn_BackHome;

    @FindBy (className = "complete-header")
    public WebElement txt_thankYou;
}

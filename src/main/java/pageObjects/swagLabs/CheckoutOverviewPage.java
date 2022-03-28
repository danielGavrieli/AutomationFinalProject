package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage {
    @FindBy(xpath = "//div[@class='header_secondary_container']/span")
    public WebElement head_CheckoutOverview;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement btn_menu;

    @FindBy (id = "shopping_cart_container")
    public WebElement btn_Cart;

    @FindBy (id = "cancel")
    public WebElement btn_cancel;

    @FindBy (id = "finish")
    public WebElement btn_finish;

    @FindBy (xpath = "//div[@class='cart_item']/div/a/div[@class='inventory_item_name']")
    public List<WebElement> txt_nameOfItemsInCheckoutOverview;

    @FindBy (xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> txt_pricesOfItemsInCheckoutOverview;
}

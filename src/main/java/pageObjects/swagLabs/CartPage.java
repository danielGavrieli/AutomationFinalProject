package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage {
    @FindBy (className = "title")
    public WebElement head_Cart;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement btn_Menu; // ask yoni how not to repeat an element that shown in 2 pages.

    @FindBy (id = "checkout")
    public WebElement btn_Checkout;

    @FindBy (id = "continue-shopping")
    public WebElement btn_ContinueShopping;

    @FindBy (className = "inventory_item_name")
    public WebElement lbl_Item;

    @FindBy (xpath = "//div[@class='cart_item']/div/a/div[@class='inventory_item_name']")
    public List<WebElement> txt_nameOfItemsInCart; //List of item names in cart

    @FindBy (xpath = "//div[@class='item_pricebar']/button")
    public List<WebElement> list_btn_Remove; //List of remove buttons

    @FindBy (xpath = "//div[@class='cart_list']/div[@class='cart_item']")
    public List<WebElement> list_ItemsInCart; //List of items in cart

    @FindBy (xpath = "//div[@class='removed_cart_item']")
    public List<WebElement> list_RemovedItems; //DOM keeps items that has been removed

    @FindBy (className = "shopping_cart_badge")
    public WebElement bdg_ItemsInCart; //Displayed when items in cart > 0

    @FindBy (className = "shopping_cart_link")
    public List<WebElement> numOfItemsBadge; //When cart is empty, size = 1

    @FindBy (xpath = "//div[@class='cart_item']/div/a/div[@class='inventory_item_name']")
    public WebElement txt_itemName;

    @FindBy (xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> txt_pricesOfItemsInCheckoutOverview;

}

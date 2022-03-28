package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    public final String mainPageURL = "https://www.saucedemo.com/inventory.html";

    @FindBy (className = "title")
    public WebElement head_Products;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement btn_Menu;

    @FindBy (id = "shopping_cart_container")
    public WebElement btn_Cart;

    @FindBy (className = "product_sort_container")
    public WebElement cb_selectFilter;

}

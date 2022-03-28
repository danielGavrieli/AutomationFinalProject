package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage {
    
    @FindBy (xpath = "//div[@class='inventory_list']/div")
    public List<WebElement> list_Items; //List of all items in inventory

    @FindBy (xpath = "//div[@class='pricebar']/button")
    public List<WebElement> list_btn_addToCart; //List of add to cart buttons

    @FindBy (xpath = "//div[@class='inventory_item_label']/a/div[@class='inventory_item_name']")
    public List<WebElement> list_itemName;

//    @FindBy (xpath = "//div[@class='inventory_list']/div[@class='inventory_item']/div[@class='inventory_item_description']/div[@class='pricebar']/div[@class='inventory_item_price']")
//    public WebElement list_Prices;

    @FindBy (xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> list_Prices;


}

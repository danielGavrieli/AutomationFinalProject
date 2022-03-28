package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login to swagLabs")
    public static void login(String username, String password) {
        UIActions.updateText(swagLabsLogin.txt_username, username);
        UIActions.updateText(swagLabsLogin.txt_password, password);
        UIActions.click(swagLabsLogin.btn_login);
    }

    @Step("Business Flow: Login to swagLabs with DB credentials")
    public static void loginDB() {
        WebFlows.logout();
        String query = "SELECT name, password from Employees where id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(swagLabsLogin.txt_username, cred.get(0));
        UIActions.updateText(swagLabsLogin.txt_password, cred.get(1));
        UIActions.click(swagLabsLogin.btn_login);
    }

    @Step("Business Flow: Add All Items")
    public static void addAllItems(List<WebElement> itemsList) {
        for (int i = 0; i < itemsList.size(); i++) {
            UIActions.click(swagLabsInventory.list_btn_addToCart.get(i));
        }
    }

    @Step("Business Flow: Add Item By Name")
    public static void addItemByName(List<WebElement> elements, String itemName) {
        for (int i = 0; i < elements.size(); i++) {
            try {
                if (elements.get(i).getText().equalsIgnoreCase(itemName))
                    UIActions.click(swagLabsInventory.list_btn_addToCart.get(i));
            }
            catch (Exception e) {
                Assert.fail("Item " + itemName + " not found in inventory");
            }
        }
    }

    @Step("Business Flow: Remove Item By Name")
    public static void removeItemByName(List<WebElement> elements, String itemName) {
        for (int i = 0; i < elements.size(); i++) {
//            try {
                if (elements.get(i).getText().equalsIgnoreCase(itemName)) {
                    UIActions.click(swagLabsCart.list_btn_Remove.get(0));
                } else
//            }
//            catch(Exception e){
                    Assert.fail("Item " + itemName + " not found in cart" );
                }
            }

    @Step("Business Flow: Remove All Items")
    public static void removeAllItems() {
        int numOfItems = swagLabsCart.list_ItemsInCart.size();
        for (int i = 0; i < numOfItems; i++) {
            UIActions.click(swagLabsCart.list_btn_Remove.get(0));
        }
    }

    @Step("Business Flow: Logout")
    public static void logout() {
        if(platform.equalsIgnoreCase("web")) {
            UIActions.navigate(swagLabsMain.mainPageURL);
            UIActions.click(swagLabsMain.btn_Menu);
            UIActions.click(swagLabsLeftMenu.btn_Logout);
        }
    }


    @Step("Go to cart")
    public static void gotoCart() {
        UIActions.click(swagLabsMain.btn_Cart);
    }

    @Step("Go to inventory")
    public static void gotoInventory() {
        WebFlows.openMenu();
        UIActions.click(swagLabsLeftMenu.btn_All);
    }

    @Step("Go to login page")
    public static void gotoLogin() {
        UIActions.navigate("https://www.saucedemo.com/");
    }

    @Step("Open menu")
    public static void openMenu() {
        UIActions.click(swagLabsCart.btn_Menu);
    }

    @Step("Business Flow: Checkout")
    public static void checkout(List<WebElement> elements, String itemName) {
        WebFlows.addItemByName(elements, itemName);
        Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);
        WebFlows.gotoCart();
        Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);
        UIActions.click(swagLabsCart.btn_Checkout);
        WebFlows.checkoutInfo("Daniel", "Gavrieli", "123456");
        UIActions.click(swagLabsCheckout.btn_continue);
        UIActions.click(swagLabsCheckoutOverview.btn_finish);
        UIActions.click(swagLabsCheckoutComplete.head_CheckoutComplete);
    }

    @Step("Business Flow: Fill in checkout information")
    public static void checkoutInfo(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOf(swagLabsCheckout.form_Checkout));
        UIActions.updateText(swagLabsCheckout.txt_firstName, firstName);
        UIActions.updateText(swagLabsCheckout.txt_lastName, lastName);
        UIActions.updateText(swagLabsCheckout.txt_postalCode, postalCode);
    }

    @Step("Business Flow: Filter price low to high")
    public static void priceLowToHigh() {
        WebFlows.gotoInventory();
        wait.until(ExpectedConditions.elementToBeClickable(swagLabsMain.cb_selectFilter));
        UIActions.updateDropDown(swagLabsMain.cb_selectFilter, "Price (low to high)");
    }

}

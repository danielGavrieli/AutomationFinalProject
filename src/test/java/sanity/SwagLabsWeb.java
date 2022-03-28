package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SwagLabsWeb extends CommonOps {

    @Test(description = "Test 01 - Verify Header")
    @Description("This test logs in and verifies the main header")
    @Attachment(value = "Test 01 Screenshot", type = "image/png")
    public void test01_verifyHeader() {
        Verifications.verifyTextInElement(swagLabsMain.head_Products, "PRODUCTS");
    }

    @Test(description = "Test 02 - Verify All Items Added")
    @Description("This test adds all items and verifies it")
    @Attachment(value = "Test 02 Screenshot", type = "image/png")
    public void test02_verifyAllItemsAdded() {
        WebFlows.addAllItems(swagLabsInventory.list_Items);
        WebFlows.gotoCart();
        Verifications.verifyItemsAdded(swagLabsCart.list_ItemsInCart, 6);
        Verifications.verifyTextInElement(swagLabsCart.bdg_ItemsInCart, "6");
    }

    @Test(description = "Test 03 - Verify All Items Removed")
    @Description("This test removes 3 items and verifies it")
    @Attachment(value = "Test 03 Screenshot", type = "image/png")
    public void test03_verifyAllItemsRemoved() {
        WebFlows.removeAllItems();
        Verifications.verifyItemsRemoved(swagLabsCart.list_RemovedItems, 6);
        Verifications.invisibilityOfElement(swagLabsCart.numOfItemsBadge, 1);
        WebFlows.gotoInventory();
    }

    @Test(description = "Test 06 - Verify Menu Buttons")
    @Description("This test opens left menu and verifies the existence of all buttons (using soft assertion)")
    @Attachment(value = "Test 06 Screenshot", type = "image/png")
    public void test06_verifyMenuElements() {
        UIActions.click(swagLabsMain.btn_Menu);
        Verifications.visibilityOfElements(swagLabsLeftMenu.list_btn_Menu);
    }

    @Test(description = "Test 04 - Verify Name Of Item Added")
    @Description("This test adds item by its name and verifies it")
    @Attachment(value = "Test 04 Screenshot", type = "image/png")
    public void test04_verifyNameOfItemAdded() {
        WebFlows.addItemByName(swagLabsInventory.list_itemName, "Sauce Labs Onesie");
        WebFlows.gotoCart();
        Verifications.verifyTextInElement(swagLabsCart.txt_itemName, "Sauce Labs Onesie");
    }

    @Test(description = "Test 05 - Verify Name Of Item Removed")
    @Description("This test removes an item that has been added by its name and verifies it")
    @Attachment(value = "Test 05 Screenshot", type = "image/png")
    public void test05_verifyNameOfItemRemoved() {
        WebFlows.removeItemByName(swagLabsCart.txt_nameOfItemsInCart, "Sauce Labs Onesie");
        Verifications.verifyItemsRemoved(swagLabsCart.list_RemovedItems, 1);
        Verifications.invisibilityOfElement(swagLabsCart.numOfItemsBadge, 1);
        WebFlows.gotoInventory();
    }

    @Test(description = "Test 07 - Verify Checkout Complete Image")
    @Description("This test commits an e2e checkout and verifies the image at the end")
    @Attachment(value = "Test 07 Screenshot", type = "image/png")
    public void test07_verifyCheckoutSuccess() {
        WebFlows.checkout(swagLabsInventory.list_itemName, "Sauce Labs Onesie");
        Verifications.visualElement("checkout-complete");
        Verifications.visibilityOfElement(swagLabsCheckoutComplete.btn_BackHome);
    }

    @Test(description = "Test 08 - Verify Price Sort Low To High")
    @Description("This test selects 'low to high' and validates the prices are sort low to high")
    @Attachment(value = "Test 08 Screenshot", type = "image/png")
    public void test08_verifyPriceLowToHigh() {
        WebFlows.priceLowToHigh();
        Verifications.verifyLowToHigh(swagLabsInventory.list_Prices);
    }

    @Test(description = "This 09 - Perform login using DDT", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test logs in using DDT")
    @Attachment(value = "Test 09 Screenshot", type = "image/png")
    public void test09_loginDDT(String username, String password) {
        WebFlows.gotoLogin();
        WebFlows.login(username, password);
        Verifications.visibilityOfElementDDT(swagLabsMain.btn_Menu);
        // Second Iteration of this test should fail and take a screenshot
    }
}

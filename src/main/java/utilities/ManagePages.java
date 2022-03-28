package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    public static void initSwagLabs() {
        swagLabsMain = PageFactory.initElements(driver, pageObjects.swagLabs.MainPage.class);
        swagLabsLogin = PageFactory.initElements(driver, pageObjects.swagLabs.LoginPage.class);
        swagLabsCart = PageFactory.initElements(driver, pageObjects.swagLabs.CartPage.class);
        swagLabsLeftMenu = PageFactory.initElements(driver, pageObjects.swagLabs.LeftMenuPage.class);
        swagLabsInventory = PageFactory.initElements(driver, pageObjects.swagLabs.InventoryPage.class);
        swagLabsCheckout = PageFactory.initElements(driver, pageObjects.swagLabs.CheckoutPage.class);
        swagLabsCheckoutComplete = PageFactory.initElements(driver, pageObjects.swagLabs.CheckoutCompletePage.class);
        swagLabsCheckoutOverview = PageFactory.initElements(driver, pageObjects.swagLabs.CheckoutOverviewPage.class);
    }

    public static void initMortgage() {
        mortgageCalculatorMain = new pageObjects.mortgageCalculator.MainPage(mobileDriver);
    }

    public static void initToDo() {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}

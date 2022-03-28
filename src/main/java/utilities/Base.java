package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.restassured.response.Response;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.sikuli.script.Screen;
import pageObjects.swagLabs.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    // General
    protected static WebDriver driver;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    //Web
    protected static WebDriverWait wait;
    protected static JavascriptExecutor javascriptExecutor;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Page Objects - Web
    protected static LoginPage swagLabsLogin;
    protected static pageObjects.swagLabs.MainPage swagLabsMain;
    protected static CartPage swagLabsCart;
    protected static LeftMenuPage swagLabsLeftMenu;
    protected static InventoryPage swagLabsInventory;
    protected static CheckoutPage swagLabsCheckout;
    protected static CheckoutOverviewPage swagLabsCheckoutOverview;
    protected static CheckoutCompletePage swagLabsCheckoutComplete;

    // Page Objects - Mobile
    protected static pageObjects.mortgageCalculator.MainPage mortgageCalculatorMain;

    // Page Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;

    // Page Objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

}

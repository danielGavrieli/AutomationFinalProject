package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy (xpath = "//*[@AutomationId='num1Button']")
    public WebElement btn_one;

    @FindBy (xpath = "//*[@AutomationId='num2Button']")
    public WebElement btn_two;

    @FindBy (xpath = "//*[@AutomationId='num3Button']")
    public WebElement btn_three;

    @FindBy (xpath = "//*[@AutomationId='num4Button']")
    public WebElement btn_four;

    @FindBy (xpath = "//*[@AutomationId='plusButton']")
    public WebElement btn_plus;

    @FindBy (xpath = "//*[@AutomationId='equalButton']")
    public WebElement btn_equal;

    @FindBy (xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

    @FindBy (xpath = "//*[@AutomationId='clearButton']")
    public WebElement btn_clear;

    @FindBy (xpath = "//*[@AutomationId='minusButton']")
    public WebElement btn_minus;

    @FindBy (xpath = "//*[@AutomationId='multiplyButton']")
    public WebElement btn_multiply;

    @FindBy (xpath = "//*[@AutomationId='divideButton']")
    public WebElement btn_divide;


}

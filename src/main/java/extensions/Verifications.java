package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class Verifications extends UIActions{

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Items Added")
    public static void verifyItemsAdded(List<WebElement> elements, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        assertEquals(elements.size(), expected);
    }

    @Step("Verify Items Removed")
    public static void verifyItemsRemoved(List<WebElement> elements, int expected) {
        assertEquals(elements.size(), expected);
    }

    @Step("Verify Visibility Of Element")
    public static void visibilityOfElement(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify Visibility Of Element in DDT")
    public static void visibilityOfElementDDT(WebElement elem) {
        softAssert.assertTrue(elem.isDisplayed());
    }

    @Step("Verify Invisibility Of Element")
    public static void invisibilityOfElement(List<WebElement> elements, int expected) {
        assertEquals(elements.size(), expected);
    }

    @Step("Verify Visibility Of Multiple Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elements) {
        for (WebElement elem : elements) {
            wait.until(ExpectedConditions.visibilityOf(elem));
            softAssert.assertTrue(elem.isDisplayed(), elem.getText() + " not displayed");
        }
        softAssert.assertAll("Some elements weren't displayed");
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImgName) {
        try {
            screen.find(getData("ImageRepo") + expectedImgName + ".png");
        } catch (FindFailed findFailed) {
            fail("Error Comparing Image File: " + findFailed);
        }
    }

    @Step("Verify prices sort from low to high")
    public static void verifyLowToHigh(List<WebElement> elements) {
        double tempPrice;
        double newPrice = 0;
        for (int i = 0; i < elements.size(); i++) {
            tempPrice = Double.parseDouble(elements.get(i).getText().substring(1));
            if (tempPrice >= newPrice) {
                newPrice = tempPrice;
            } else
                fail("Price isn't sort from low to high");
        }
    }

    @Step("Verify text with text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual,expected);
    }

    @Step("Verify number with number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual,expected);
    }

    @Step("Verify status code")
    public static void verifyStatusCode(int actual, int expected) {
        assertEquals(actual, expected);
    }




}

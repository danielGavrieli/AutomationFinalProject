package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click on element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update text as human")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }

    @Step("Insert keys")
    public static void insertKeys(WebElement elem, Keys value) {
        elem.sendKeys(value);
    }

    @Step("Update dropDown element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse hover element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse hover element")
    public static void mouseHover(WebElement elem1) {
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Navigate to given url")
    public static void navigate(String url) {
        driver.get(url);
    }

    @Step("Drag and drop")
    public static void dragDrop(WebElement draggable, WebElement droppable) {
        action.dragAndDrop(draggable,droppable).build().perform();
    }

    @Step("Select multiple elements")
    public static void multiSelect(List<WebElement> elements, int fromIndex, int toIndex) {
        action.clickAndHold(elements.get(fromIndex)).clickAndHold(elements.get(toIndex))
                .build().perform();
    }

    @Step("Double click on element")
    public static void doubleClick(WebElement elem) {
        action.doubleClick(elem).build().perform();
    }

    @Step("Scroll page")
    public static void scrollPage(WebElement elem) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    @Step("Popup accept")
    public static void popupAccept() {
        Alert popup = driver.switchTo().alert();
        popup.accept();
    }

    @Step("Popup dismiss")
    public static void popupDismiss() {
        Alert popup = driver.switchTo().alert();
        popup.dismiss();
    }

    @Step("Update text in popup")
    public static void updateTextPopup(String text) {
        Alert popup = driver.switchTo().alert();
        popup.sendKeys(text);
    }

    @Step("Switch to iFrame element")
    public static void switchToIFrame(WebElement iFrameElem) {
        driver.switchTo().frame(iFrameElem);
    }

    @Step("Switch to default content")
    public static void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Step("Date picker")
    public static void datePicker(List<WebElement> dateWidgetCells, int date) {
        wait.until(ExpectedConditions.visibilityOfAllElements(dateWidgetCells));
        for (WebElement cell : dateWidgetCells) {
            if (cell.getText().equals(date)) {
                cell.click();
                break;
            }
        }
    }

    @Step("Upload file") //Element type="file"
    public static void uploadFile(WebElement btnElem, String filePath) {
        btnElem.sendKeys(filePath);
    }
}

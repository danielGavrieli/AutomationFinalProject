package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy (xpath = "//input[@placeholder='Create a task']")
    public WebElement txt_create;

    @FindBy (className = "view_2Ow90")
    public List<WebElement> list_tasks;

    @FindBy (className = "destroy_19w1q")
    public WebElement btn_delete;

    @FindBy (className = "toggleIconsWrapper_2kpi8")
    public WebElement rb_complete;

    @FindBy (className = "allCompletedIconWrapper_2rCqr")
    public WebElement rb_completeAll;

}

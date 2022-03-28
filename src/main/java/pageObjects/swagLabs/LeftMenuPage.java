package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMenuPage {
    @FindBy (xpath = "//nav/a[1]")
    public WebElement btn_All;

    @FindBy (id = "about_sidebar_link")
    public WebElement btn_About;

    @FindBy (id = "logout_sidebar_link")
    public WebElement btn_Logout;

    @FindBy (id = "reset_sidebar_link")
    public WebElement btn_Reset;

    @FindBy (className = "bm-item-list")
    public List<WebElement> list_btn_Menu;
}

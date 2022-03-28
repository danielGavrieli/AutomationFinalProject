package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: Add new task to the list")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMain.txt_create, taskName);
        UIActions.insertKeys(todoMain.txt_create, Keys.RETURN);
    }

    @Step("Business Flow: Count and return number of tasks in list")
    public static int getNumberOfTasks() {
        return todoMain.list_tasks.size();
    }

    @Step("Business Flow: Return list of all tasks")
    public static List<WebElement> getTaskList() {
        return todoMain.list_tasks;
    }

    @Step("Business Flow: Empty lists from tasks")
    public static void emptyList() {
        for (int i = 0; i <= getNumberOfTasks(); i++) {
            UIActions.mouseHover(todoMain.btn_delete);
        }
    }

    @Step("Business Flow: Mark all tasks completed")
    public static void markAllTasks() {
        UIActions.click(todoMain.rb_completeAll);
    }

    @Step("Business Flow: Mark task completed by index")
    public static void markTaskByName(String taskName, List<WebElement> tasks) {
        for (int i = 0; i < getNumberOfTasks(); i++) {
            if (tasks.get(i).getText().equalsIgnoreCase(taskName)) {
                UIActions.click(todoMain.rb_complete);
            }
        }
    }


}




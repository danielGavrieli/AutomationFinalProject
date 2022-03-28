package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;
import io.qameta.allure.Attachment;

import java.util.concurrent.TimeUnit;


@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test 01 - Add and verify new task")
    @Description("This test adds a new task and verifies it in the list of tasks")
    @Attachment(value = "Test 01 Screenshot", type = "image/png")
    public void test01_addAndVerifyNewTask() {
        ElectronFlows.addNewTask("Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
    }

    @Test
    public void test02_addAndVerifyNewTasks() {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn Python");
        ElectronFlows.addNewTask("Learn C#");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 3);
    }

    @Test
    public void test03_markAllComplete() {
        ElectronFlows.addNewTask("AAA");
        ElectronFlows.addNewTask("AAA");
        ElectronFlows.addNewTask("AAA");
        ElectronFlows.markAllTasks();
        //TODO Add verification...
    }

    @Test
    public void test04_markCompleteByName() {
        ElectronFlows.addNewTask("AAA");
        ElectronFlows.addNewTask("BBB");
        ElectronFlows.addNewTask("CCC");
        ElectronFlows.markTaskByName("BBB", ElectronFlows.getTaskList());
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }
}


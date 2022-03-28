package sanity;

import io.qameta.allure.Description;
import extensions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test 01 - Verify addition command")
    @Description("This test verifies the addition command")
    public void test01_verifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result, "התצוגה היא 4");
    }

    @Test(description = "Test 02 - Verify decrementation command")
    @Description("This test verifies the decrementation command")
    public void test02_verifyDecrementationCommand() {
        DesktopFlows.calculateDecrementation();
        Verifications.verifyTextInElement(calcMain.field_result, "התצוגה היא 2");
    }

    @Test(description = "Test 03 - Verify Division command")
    @Description("This test verifies the Division command")
    public void test03_verifyDivisionCommand() {
        DesktopFlows.calculateDivision();
        Verifications.verifyTextInElement(calcMain.field_result, "התצוגה היא 2");
    }

    @Test(description = "Test 04 - Verify Multiplication command")
    @Description("This test verifies the Multiplication command")
    public void test04_verifyMultiplicationCommand() {
        DesktopFlows.calculateMultiplication();
        Verifications.verifyTextInElement(calcMain.field_result, "התצוגה היא 6");
    }

}

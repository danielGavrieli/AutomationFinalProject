package sanity;

import io.qameta.allure.Description;
import extensions.Verifications;
import org.testng.annotations.Listeners;
import io.qameta.allure.Attachment;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageCalculatorMobile extends CommonOps {

    @Test(description = "Test 01 - Verify Mortgage Repayment")
    @Description("This test fills in mortgage field and calculates repayment")
    @Attachment(value = "Test 01 Screenshot", type = "image/png")
    public void test01_verifyMortgage() {
        MobileFlows.calculateMortgage("1000", "3", "4");
        Verifications.verifyTextInElement(mortgageCalculatorMain.txt_repayment, "£32.03");
    }
}

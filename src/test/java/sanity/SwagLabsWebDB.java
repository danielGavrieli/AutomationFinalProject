package sanity;

import extensions.Verifications;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SwagLabsWebDB extends CommonOps {

    @Test(description = "Test 01 - Login to sauceLabs with DB credentials")
    @Description("This test logs in with DB credentials and verifies the header")
    @Attachment(value = "Test 01 Screenshot", type = "image/png")
    public void test01_loginDBAndVerifyHeader() {
        WebFlows.loginDB();
        Verifications.verifyTextInElement(swagLabsMain.head_Products, "PRODUCTS");
    }
}

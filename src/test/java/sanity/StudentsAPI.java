package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class StudentsAPI extends CommonOps {

    @Test(description = "Test 01 - Get Student Name")
    @Description("This Test Verifies Students Name")
    public void test01_verifyStudentName() {
        Verifications.verifyText(ApiFlows.getStudentName("[99].firstName"), "Oscar");
    }

    @Test(description = "Test 02 - Add Student And Verify")
    @Description("This Test Adds a Student And Verifies The Name")
    public void test02_addStudentAndVerify() {
        ApiFlows.postStudent("Daniel", "Gavrieli", "kstxdsktlarkuexdvq@bvhrs.com", "Manual QA");
        Verifications.verifyText(ApiFlows.getStudentName("[100].firstName"), "Daniel");
    }

    @Test(description = "Test 03 - Update Student And Verify")
    @Description("This Test Updates a Student And Verifies The Programme")
    public void test03_updateStudentAndVerify() {
        String id = ApiFlows.getStudentName("[100].id");
        ApiFlows.updateStudent(id,"Daniel", "Gavrieli", "kstxdsktlarkuexdvq@bvhrs.com", "Automation Engineer");
        Verifications.verifyText(ApiFlows.getStudentName("[100].programme"), "Automation Engineer");
    }

    @Test(description = "Test 04 - Delete Student And Verify")
    @Description("This Test Deletes a Student And Verifies The Status code")
    public void test04_deleteStudentAndVerify() {
        String id = ApiFlows.getStudentName("[100].id");
        ApiFlows.deleteStudent(id);
        Verifications.verifyStatusCode(response.getStatusCode(), 204);
    }
}

package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Student Name")
    public static String getStudentName (String jPath) {
        response = ApiActions.get("student/list");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Student")
    public static void postStudent(String firstName, String lastName, String email, String programme) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", email);
        ApiActions.post(params, "/student");
    }

    @Step("Business Flow: Update Existing Student")
    public static void updateStudent(String id, String firstName, String lastName, String email, String programme) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        ApiActions.put(params, "/student/" + id);
    }

    @Step("Business Flow: Delete Existing Student")
    public static void deleteStudent(String id) {
        ApiActions.delete(id);
    }
}

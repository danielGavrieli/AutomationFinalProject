package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Calculator addition")
    public static void calculateAddition() {
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_one);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_three);
        UIActions.click(calcMain.btn_equal);
    }

    @Step("Business Flow: Calculator decrementation")
    public static void calculateDecrementation() {
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_four);
        UIActions.click(calcMain.btn_minus);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_equal);
    }

    @Step("Calculator division")
    public static void calculateDivision() {
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_four);
        UIActions.click(calcMain.btn_divide);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_equal);
    }

    @Step("Calculator multiplication")
    public static void calculateMultiplication() {
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_multiply);
        UIActions.click(calcMain.btn_three);
        UIActions.click(calcMain.btn_equal);
    }
}

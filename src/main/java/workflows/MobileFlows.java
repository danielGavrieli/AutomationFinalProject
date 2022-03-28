package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill form and calculate mortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileActions.updateText(mortgageCalculatorMain.txt_amount, amount);
        MobileActions.updateText(mortgageCalculatorMain.txt_term, term);
        MobileActions.updateText(mortgageCalculatorMain.txt_rate, rate);
        MobileActions.tap(mortgageCalculatorMain.btn_calculate);
    }
}

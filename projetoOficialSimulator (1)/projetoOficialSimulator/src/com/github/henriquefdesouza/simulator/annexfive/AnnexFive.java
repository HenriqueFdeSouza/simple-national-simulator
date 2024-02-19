package com.github.henriquefdesouza.simulator.annexfive;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.annexthree.AnnexThree;
import com.github.henriquefdesouza.simulator.panel.InputManager;
import com.github.henriquefdesouza.simulator.piscofisicms.AllTaxes;

import java.util.Arrays;
import java.util.List;

public class AnnexFive extends AllTaxes implements Annexs {
    public List<Double> aliquot() {
        return Arrays.asList(0.1550, 0.18, 0.1950, 0.2050, 0.23, 0.3050);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 4500.0, 9900.0, 17100.0, 62100.0, 540000.0);
    }

    public List<Double> taxes(int range) {
        if (range == 1) return Arrays.asList(0.14, 0.1410, 0.0305, 0.2885, 0.15, 0.25);
        if (range == 2) return Arrays.asList(0.17, 0.1410, 0.0305, 0.2785, 0.15, 0.23);
        if (range == 3) return Arrays.asList(0.19, 0.1492, 0.0323, 0.2385, 0.15, 0.24);
        if (range == 4) return Arrays.asList(0.21, 0.1574, 0.0341, 0.2385, 0.15, 0.21);
        if (range == 5) return Arrays.asList(0.2350, 0.1410, 0.0305, 0.2385, 0.1250, 0.23);
        return Arrays.asList(0.0, 0.1644, 0.0356, 0.2950, 0.1550, 0.35);
    }

    public List<String> namesTaxes() {
        return Arrays.asList("ISS: ", "COFINS: ", "PIS: ", "CPP: ", "CSLL: ", "IRPJ: ");
    }

    public boolean calculateFactorR() {
        payrollSum += InputManager.questionFactorR();
        return payrollSum / valueRbt12 >= 0.28;
    }

    @Override
    public void printFullData() {
        if (calculateFactorR()) {
            Annexs annexs = new AnnexThree();
            annexs.printFullData();
        } else {
            iss += InputManager.test(InputManager.questionIss());
            printTaxes();
        }
    }
}

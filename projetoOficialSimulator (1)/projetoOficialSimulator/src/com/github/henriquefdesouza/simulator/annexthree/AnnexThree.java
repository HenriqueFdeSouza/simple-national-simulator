package com.github.henriquefdesouza.simulator.annexthree;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.panel.InputManager;
import com.github.henriquefdesouza.simulator.piscofisicms.AllTaxes;

import java.util.Arrays;
import java.util.List;

public class AnnexThree extends AllTaxes implements Annexs {

    public List<Double> aliquot() {
        return Arrays.asList(0.06, 0.112, 0.135, 0.16, 0.21, 0.33);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 9360.0, 17640.0, 35640.0, 125640.0, 648000.0);
    }

    public List<Double> taxes(int range) {
        if (range == 1 || range == 5) return Arrays.asList(0.335, 0.1282, 0.0278, 0.434, 0.035, 0.04);
        if (range == 2) return Arrays.asList(0.32, 0.1405, 0.0305, 0.434, 0.035, 0.04);
        if (range < 4) return Arrays.asList(0.325, 0.1364, 0.0296, 0.4340, 0.035, 0.04);
        return Arrays.asList(0.0, 0.1603, 0.0347, 0.3050, 0.15, 0.35);
    }

    public List<String> namesTaxes() {
        return Arrays.asList("ISS: ", "COFINS: ", "PIS: ", "CPP: ", "CSLL: ", "IRPJ: ");
    }

    @Override
    public void printFullData() {
        iss += InputManager.test(InputManager.questionIss());
        printTaxes();
    }
}
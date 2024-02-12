package com.github.henriquefdesouza.simulator.annexone;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.Icms;
import com.github.henriquefdesouza.simulator.InputManager;

import java.util.Arrays;
import java.util.List;

public class AnnexOne implements Annexs {
    private double icmsSt;

    public List<Double> aliquot() {
        return Arrays.asList(0.04, 0.073, 0.095, 0.107, 0.143, 0.19);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 5940.0, 13860.0, 22500.0, 87300.0, 378000.0);
    }

    public List<Double> taxes(int track) {
        if (track <= 2) return Arrays.asList(0.415, 0.035, 0.34, 0.055, 0.1274, 0.0276);
        if (track <= 5) return Arrays.asList(0.42, 0.035, 0.335, 0.055, 0.1274, 0.0276);
        return Arrays.asList(0.421, 0.10, 0.135, 0.2827, 0.0613);
    }

    @Override
    public List<String> namesTaxes() {
        return Arrays.asList("CPP: ", "CSLL: ", "ICMS: ", "IRPJ: ", "COFINS: ", "PIS: ");
    }

    public void getIcmsSt() {
        icmsSt += InputManager.icmsSt();
    }

    @Override
    public double getRevenue() {
        return revenue - icmsSt;
    }

    @Override
    public void printFullData() {
        getIcmsSt();
        if (icmsSt == 0) {
            printAll();
        } else {
            Icms icms = new Icms(this, icmsSt);
            double valueGuide = calculatorValueGuide() + icms.valueIcmsSt();
            printGuide(valueGuide);
            printAliquot(calculatorAliquot());
            icms.printTaxesIcms();
        }
    }
}
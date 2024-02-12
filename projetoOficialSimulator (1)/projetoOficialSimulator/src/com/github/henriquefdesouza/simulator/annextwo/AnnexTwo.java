package com.github.henriquefdesouza.simulator.annextwo;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.Icms;
import com.github.henriquefdesouza.simulator.InputManager;

import java.util.Arrays;
import java.util.List;

public class AnnexTwo implements Annexs {
    private double icmsSt;

    public List<Double> aliquot() {
        return Arrays.asList(0.045, 0.078, 0.10, 0.112, 0.147, 0.30);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 5940.0, 13860.0, 22500.0, 85500.0, 720000.0);
    }

    public List<Double> taxes(int track) {
        if (track <= 5) return Arrays.asList(0.375, 0.075, 0.32, 0.035, 0.055, 0.1151, 0.0249);
        return Arrays.asList(0.235, 0.35, 0.0, 0.075, 0.085, 0.2096, 0.0454);
    }

    @Override
    public List<String> namesTaxes() {
        return Arrays.asList("CPP: ", "IPI: ", "ICMS: ", "CSLL: ", "IRPJ: ", "COFINS: ", "PIS: ");
    }

    @Override
    public double getRevenue() {
        return revenue - icmsSt;
    }

    public void getIcmsSt() {
        icmsSt += InputManager.icmsSt();
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

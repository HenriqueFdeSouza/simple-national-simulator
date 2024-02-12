package com.github.henriquefdesouza.simulator.annextwo;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.piscofisicms.AllTaxes;
import com.github.henriquefdesouza.simulator.panel.InputManager;

import java.util.Arrays;
import java.util.List;

public class AnnexTwo implements Annexs {
    private double icmsSt;
    private double pisCofins;

    public List<Double> aliquot() {
        return Arrays.asList(0.045, 0.078, 0.10, 0.112, 0.147, 0.30);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 5940.0, 13860.0, 22500.0, 85500.0, 720000.0);
    }

    public List<Double> taxes(int track) {
        if (track <= 5) return Arrays.asList(0.375, 0.075, 0.32, 0.035, 0.1151, 0.0249, 0.055);
        return Arrays.asList(0.235, 0.35, 0.0, 0.075, 0.085, 0.2096, 0.0454);
    }

    @Override
    public List<String> namesTaxes() {
        return Arrays.asList("CPP: ", "IPI: ", "ICMS: ", "CSLL: ", "COFINS: ", "PIS: ", "IRPJ: ");
    }

    public void getIcmsSt() {
        icmsSt += InputManager.icmsSt();
    }

    public void getPisCofins() {
        pisCofins += InputManager.pisCofins();
    }

    @Override
    public double getRevenue() {
        return revenue - icmsSt - pisCofins;
    }

    @Override
    public void printFullData() {
        getIcmsSt();
        getPisCofins();
        if (icmsSt != 0 || pisCofins != 0) {
            AllTaxes allTaxes = new AllTaxes(this, icmsSt, pisCofins);
            double valueGuide = calculatorValueGuide() + allTaxes.valueIcmsSt() + allTaxes.valuePisCofins();
            printGuide(valueGuide);
            printAliquot(calculatorAliquot());
            allTaxes.printTaxes();
        } else {
            printAll();
        }
    }
}
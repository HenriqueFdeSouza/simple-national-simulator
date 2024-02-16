package com.github.henriquefdesouza.simulator.annextwo;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.panel.InputManager;
import com.github.henriquefdesouza.simulator.piscofisicms.AllTaxes;

import java.util.Arrays;
import java.util.List;

public class AnnexTwo extends AllTaxes implements Annexs {

    public List<Double> aliquot() {
        return Arrays.asList(0.045, 0.078, 0.10, 0.112, 0.147, 0.30);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 5940.0, 13860.0, 22500.0, 85500.0, 720000.0);
    }

    public List<Double> taxes(int track) {
        if (track <= 5) return Arrays.asList(0.32, 0.1151, 0.0249, 0.375, 0.075, 0.035, 0.055);
        return Arrays.asList(0.0, 0.085, 0.2096, 0.235, 0.35, 0.075, 0.0454);
    }

    @Override
    public List<String> namesTaxes() {
        return Arrays.asList("ICMS: ", "COFINS: ", "PIS: ", "CPP: ", "IPI: ", "CSLL: ", "IRPJ: ");
    }

    @Override
    public double getRevenue() {
        return revenue - icmsSt - pisCofins;
    }

    @Override
    public void printFullData() {
        icmsSt += InputManager.icmsSt();
        pisCofins += InputManager.pisCofins();
        printGuideAndAliquot(sumTaxes(), calculatorAliquot());
        printTaxes();
    }
}
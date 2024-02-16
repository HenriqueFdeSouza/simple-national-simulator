package com.github.henriquefdesouza.simulator.annexone;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.panel.InputManager;
import com.github.henriquefdesouza.simulator.piscofisicms.AllTaxes;

import java.util.Arrays;
import java.util.List;

public class AnnexOne extends AllTaxes implements Annexs {
    public List<Double> aliquot() {
        return Arrays.asList(0.04, 0.073, 0.095, 0.107, 0.143, 0.19);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 5940.0, 13860.0, 22500.0, 87300.0, 378000.0);
    }

    public List<Double> taxes(int track) {
        if (track <= 2) return Arrays.asList(0.34, 0.1274, 0.0276, 0.415, 0.035, 0.055);
        if (track <= 5) return Arrays.asList(0.335, 0.1274, 0.0276, 0.42, 0.035, 0.055);
        return Arrays.asList(0.2827, 0.0613, 0.421, 0.10, 0.135);
    }

    @Override
    public List<String> namesTaxes() {
        return Arrays.asList("ICMS: ", "COFINS: ", "PIS: ", "CPP: ", "CSLL: ", "IRPJ: ");
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
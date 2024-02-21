package com.github.henriquefdesouza.simulator.annexs;

import com.github.henriquefdesouza.simulator.panel.InputManager;
import com.github.henriquefdesouza.simulator.piscofisicms.AllTaxes;

import java.util.Arrays;
import java.util.List;

public class AnnexFour extends AllTaxes implements Annex {

    public List<Double> aliquot() {
        return Arrays.asList(0.045, 0.09, 0.102, 0.14, 0.22, 0.33);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 8100.0, 12420.0, 39780.0, 183780.0, 828000.0);
    }

    public List<Double> taxes(int range) {
        if (range == 1) return Arrays.asList(0.445, 0.152, 0.1880, 0.1767, 0.0383);
        if (range == 2) return Arrays.asList(0.40, 0.152, 0.1980, 0.2055, 0.0445);
        if (range == 3) return Arrays.asList(0.40, 0.152, 0.2080, 0.1973, 0.0427);
        if (range == 4) return Arrays.asList(0.40, 0.1920, 0.1780, 0.1890, 0.0410);
        if (range == 5) return Arrays.asList(0.40, 0.1920, 0.1880, 0.1808, 0.0392);
        return Arrays.asList(0.0, 0.2150, 0.5350, 0.2055, 0.0445);
    }

    public List<String> namesTaxes() {
        return Arrays.asList("ISS: ", "CSLL: ", "IRPJ: ", "COFINS: ", "PIS: ");
    }

    @Override
    public void printFullData() {
        iss += InputManager.valueTaxe(InputManager.questionIss());
        printTaxes();
    }
}
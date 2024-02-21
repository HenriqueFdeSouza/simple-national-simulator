package com.github.henriquefdesouza.simulator.annexs;

import com.github.henriquefdesouza.simulator.piscofisicms.AllTaxes;

import java.util.Arrays;
import java.util.List;

public class AnnexExterior extends AllTaxes implements Annex {

    private final Annex annex = new AnnexThree();

    @Override
    public List<String> namesTaxes() {
        return annex.namesTaxes();
    }

    @Override
    public List<Double> aliquot() {
        return annex.aliquot();
    }

    @Override
    public List<Double> deductionValue() {
        return annex.deductionValue();
    }

    @Override
    public List<Double> taxes(int range) {
        if (range == 1 || range == 5) return Arrays.asList(0.0, 0.0, 0.0, 0.434, 0.035, 0.04);
        if (range == 2) return Arrays.asList(0.0, 0.0, 0.0, 0.434, 0.035, 0.04);
        if (range < 4) return Arrays.asList(0.0, 0.0, 0.0, 0.4340, 0.035, 0.04);
        return Arrays.asList(0.0, 0.0, 0.0, 0.3050, 0.15, 0.35);
    }

    @Override
    public void printFullData() {
        printTaxes();
    }
}
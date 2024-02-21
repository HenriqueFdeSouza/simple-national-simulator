package com.github.henriquefdesouza.simulator.piscofisicms;

import com.github.henriquefdesouza.simulator.annexs.Annex;

import java.util.List;

public abstract class AllTaxes implements Annex {
    public double icmsSt;
    public double pisCofins;
    public double iss;
    public double payrollSum;

    @Override
    public double getRevenue() {
        return revenue - icmsSt - pisCofins - iss;
    }

    private Double recalculateTaxePisCofins(int i) {
        List<Double> listTaxes = taxes(checkRange());
        listTaxes.set(1, 0.0);
        listTaxes.set(2, 0.0);
        return calculationTaxes(listTaxes, pisCofins).get(i);
    }

    private Double recalculateTaxeIcms(int i) {
        List<Double> listTaxes = taxes(checkRange());
        listTaxes.set(0, 0.0);
        return calculationTaxes(listTaxes, icmsSt).get(i);
    }

    private Double recalculateTaxeIss(int i) {
        List<Double> listTaxes = taxes(checkRange());
        listTaxes.set(0, 0.0);
        return calculationTaxes(listTaxes, iss).get(i);
    }

    private Double fullTaxes(int i) {
        return calculationTaxes(taxes(checkRange()), getRevenue()).get(i);
    }

    public void printTaxes() {
        List<String> listTaxes = namesTaxes();
        double guide = 0;
        for (int i = 0; i < listTaxes.size(); i++) {
            double sumTaxes = recalculateTaxeIcms(i) + recalculateTaxePisCofins(i) + fullTaxes(i) + recalculateTaxeIss(i);
            System.out.printf("(%.2f %%) %s%.2f%n", (calculatorAliquot() * taxes(checkRange()).get(i)), listTaxes.get(i), sumTaxes);
            guide += sumTaxes;
        }
        System.out.printf("Valor da guia: R$ %.2f%n", guide);
        System.out.printf("Porcentagem aliquota: %.3f %%%n", calculatorAliquot());
    }
}
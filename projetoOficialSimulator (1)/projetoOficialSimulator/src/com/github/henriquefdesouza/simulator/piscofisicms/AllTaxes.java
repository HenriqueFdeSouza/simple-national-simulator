package com.github.henriquefdesouza.simulator.piscofisicms;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.panel.InputManager;

import java.util.List;

public abstract class AllTaxes implements Annexs {
    public double icmsSt;
    public double pisCofins;
    public double iss;
    public double payrollSum;

    public Double recalculateTaxePisCofins(int i) {
        List<Double> listTaxes = taxes(checkRange());
        listTaxes.set(1, 0.0);
        listTaxes.set(2, 0.0);
        return calculationTaxes(listTaxes, pisCofins).get(i);
    }

    public Double recalculateTaxeIcms(int i) {
        List<Double> listTaxes = taxes(checkRange());
        listTaxes.set(0, 0.0);
        return calculationTaxes(listTaxes, icmsSt).get(i);
    }

    public Double recalculateTaxeIss(int i) {
        List<Double> listTaxes = taxes(checkRange());
        listTaxes.set(0, 0.0);
        return calculationTaxes(listTaxes, iss).get(i);
    }

    private Double fullTaxes(int i) {
        return calculationTaxes(taxes(checkRange()), getRevenue()).get(i);
    }

    public void printTaxes() {
        List<String> listTaxes = namesTaxes();
        for (int i = 0; i < listTaxes.size(); i++) {
            double sumTaxes = recalculateTaxeIcms(i) + recalculateTaxePisCofins(i) + fullTaxes(i) + recalculateTaxeIss(i);
            System.out.printf("(%.2f %%) %s%.2f%n", (calculatorAliquot() * taxes(checkRange()).get(i)), listTaxes.get(i), sumTaxes);
        }
    }

    public double sumTaxes() {
        return calculatorValueGuide() + valueIcmsSt() + valuePisCofins() + valueIss();
    }

    public double valueIss() {
        return (calculatorAliquot() - aliquotIss()) / 100 * iss;
    }

    public double valueIcmsSt() {
        return (calculatorAliquot() - aliquotIcms()) / 100 * icmsSt;
    }

    public double valuePisCofins() {
        return (calculatorAliquot() - (aliquotCofins() + aliquotPis())) / 100 * pisCofins;
    }


}
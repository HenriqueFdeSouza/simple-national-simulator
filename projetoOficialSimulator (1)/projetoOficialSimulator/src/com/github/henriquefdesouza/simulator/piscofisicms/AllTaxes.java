package com.github.henriquefdesouza.simulator.piscofisicms;

import com.github.henriquefdesouza.simulator.Annexs;

import java.util.List;

public record AllTaxes(Annexs annexs, double icmsSt, double pisCofins) {

    public List<Double> removeTaxePisCofins() {
        List<Double> listTaxes = annexs.taxes(annexs.checkRange());
        listTaxes.set(4, 0.0);
        listTaxes.set(5, 0.0);
        return listTaxes;
    }

    public List<Double> removeTaxeIcms() {
        List<Double> listTaxes = annexs.taxes(annexs.checkRange());
        listTaxes.set(2, 0.0);
        return listTaxes;
    }

    public void printTaxes() {
        List<String> listTaxes = annexs.namesTaxes();
        for (int i = 0; i < listTaxes.size(); i++) {
            double sumTaxes = annexs.calculationTaxes(removeTaxeIcms(), icmsSt).get(i) +
                    annexs.calculationTaxes(removeTaxePisCofins(), pisCofins).get(i) +
                    annexs.calculationTaxes(annexs.taxes(annexs.checkRange()),
                            annexs.getRevenue()).get(i);
            System.out.printf("(%.2f %%) %s%.2f%n", (annexs.calculatorAliquot() * annexs.taxes(annexs.checkRange()).get(i)), listTaxes.get(i),
                    sumTaxes);
        }
    }

    public double valueIcmsSt() {
        return (annexs.calculatorAliquot() - aliquotIcms()) / 100 * icmsSt;
    }

    private double aliquotIcms() {
        return annexs.calculatorAliquot() * annexs.taxes(annexs.checkRange()).get(2);
    }

    public double valuePisCofins() {
        return (annexs.calculatorAliquot() - (aliquotCofins() + aliquotPis())) / 100 * pisCofins;
    }

    private double aliquotCofins() {
        return (annexs.calculatorAliquot() * annexs.taxes(annexs.checkRange()).get(4));
    }

    private double aliquotPis() {
        return (annexs.calculatorAliquot() * annexs.taxes(annexs.checkRange()).get(5));
    }
}

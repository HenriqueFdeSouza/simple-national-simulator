package com.github.henriquefdesouza.simulator;

import java.util.List;

public record Icms(Annexs annexs, double icmsSt) {

    public void printTaxesIcms() {
        List<Double> listTaxes = annexs.taxes(annexs.checkRange());
        listTaxes.set(2, 0.0);
        for (int i = 0; i < annexs.namesTaxes().size(); i++) {
            double sumOfTaxes = annexs.calculationTaxes(listTaxes, icmsSt).get(i) + annexs.calculationTaxes(annexs.taxes(annexs.checkRange()),
                    annexs.getRevenue()).get(i);
            System.out.printf("(%.2f %%) %s%.2f%n", (annexs.calculatorAliquot() * annexs.taxes(annexs.checkRange()).get(i)), annexs.namesTaxes().get(i),
                    sumOfTaxes);
        }
    }

    public double valueIcmsSt() {
        return (annexs.calculatorAliquot() - (annexs.calculatorAliquot() * annexs.taxes(annexs.checkRange()).get(2))) / 100 * icmsSt;
    }
}

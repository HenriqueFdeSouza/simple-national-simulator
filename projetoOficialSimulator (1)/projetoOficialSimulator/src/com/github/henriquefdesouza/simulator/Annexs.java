package com.github.henriquefdesouza.simulator;

import java.util.ArrayList;
import java.util.List;

public interface Annexs {

    double valueRbt12 = InputManager.rbt12();
    double revenue = InputManager.revenueValue();

    double getRevenue();

    List<String> namesTaxes();

    List<Double> aliquot();

    List<Double> deductionValue();

    List<Double> taxes(int track);

    void printFullData();


    default int checkRange() {
        if (valueRbt12 <= 0) return 0;
        if (valueRbt12 <= 180_000) return 1;
        if (valueRbt12 <= 360_000) return 2;
        if (valueRbt12 <= 720_000) return 3;
        if (valueRbt12 <= 1_800_000) return 4;
        if (valueRbt12 <= 3_600_000) return 5;
        return 6;
    }

    default double calculatorAliquot() {
        return (valueRbt12 * aliquot().get(checkRange() - 1) -
                deductionValue().get(checkRange() - 1)) / valueRbt12 * 100;
    }

    default double calculatorValueGuide() {
        return calculatorAliquot() / 100 * getRevenue();
    }

    default ArrayList<Double> calculationTaxes(List<Double> taxes, double revenue) {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < taxes(checkRange()).size(); i++) {
            double calc = calculatorAliquot() * taxes.get(i) / 100 * revenue;
            list.add(calc);
        }
        return list;
    }

    default void printGuide(double valueGuide) {
        System.out.println("Valor da guia: " + valueGuide);
    }

    default void printAliquot(double valueAliquot) {
        System.out.printf("Porcentagem aliquota: %.3f %%%n", valueAliquot);
    }

    default void printTaxes() {
        for (int i = 0; i < namesTaxes().size(); i++) {
            System.out.printf("(%.2f %%) %s%.2f%n", (calculatorAliquot() * taxes(checkRange()).get(i)), namesTaxes().get(i),
                    calculationTaxes(taxes(checkRange()), revenue).get(i));
        }
    }

    default void printAll() {
        printGuide(calculatorValueGuide());
        printAliquot(calculatorAliquot());
        printTaxes();
    }

}

package com.github.henriquefdesouza.simulator.annexthree;

import com.github.henriquefdesouza.simulator.Annexs;

import java.util.Arrays;
import java.util.List;

public class AnnexThree implements Annexs {
    public List<Double> aliquot() {
        return Arrays.asList(0.06, 0.112, 0.135, 0.16, 0.21, 0.33);
    }

    public List<Double> deductionValue() {
        return Arrays.asList(0.0, 9360.0, 17640.0, 35640.0, 125640.0, 648000.0);
    }

    public List<Double> taxes(int track) {
        if (track == 1 || track == 5) return Arrays.asList(0.434, 0.335, 0.035, 0.04, 0.1282, 0.0278);
        if (track == 2) return Arrays.asList(0.434, 0.32, 0.035, 0.04, 0.1405, 0.0305);
        if (track < 4) return Arrays.asList(0.4340, 0.325, 0.035, 0.04, 0.1364, 0.0296);
        return Arrays.asList(0.3050, 0.0, 0.15, 0.35, 0.1603, 0.0347);
    }

    @Override
    public void printFullData() {
        printAll();
    }

    @Override
    public double getRevenue() {
        return revenue;
    }

    @Override
    public List<String> namesTaxes() {
        return Arrays.asList("CPP: ", "ISS: ", "CSLL: ", "IRPJ: ", "COFINS: ", "PIS: ");
    }
}
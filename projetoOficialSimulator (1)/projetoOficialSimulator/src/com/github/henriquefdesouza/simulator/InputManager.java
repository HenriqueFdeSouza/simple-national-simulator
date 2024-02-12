package com.github.henriquefdesouza.simulator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class InputManager {
    static Scanner sc = new Scanner(System.in);
    static NumberFormat numberFormat = new DecimalFormat("#,##0.000");

    public static double rbt12() {
        return readInput("Rbt12");
    }

    public static double revenueValue() {
        return readInput("Receita");
    }

    public static String questionIcms() {
        System.out.print("Tem Receita com ICMS retido por Substituição ICMS? (Sim/Não): ");
        return sc.nextLine();
    }

    public static double icmsSt() {
        if (questionIcms().equalsIgnoreCase("sim")) {
            return readInput("Por favor, insira o valor correspondente ICMS ST");
        }
        return 0;
    }

    public static double readInput(String prompt) {
        System.out.print(prompt + " : ");
        String input = sc.nextLine();
        try {
            return numberFormat.parse(input).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException("Numero digitado está incorreto!");
        }
    }

}

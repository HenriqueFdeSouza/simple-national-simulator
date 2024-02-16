package com.github.henriquefdesouza.simulator.panel;

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

    public static double questionFactorR() {
        return readInput("Digite o somatório da folha de pagamento dos últimos 12 meses");
    }

    public static String questionIcms() {
        System.out.print("Tem Receita com ICMS retido por Substituição ICMS? (Sim/Não): ");
        return sc.nextLine();
    }

    public static String questionPisAndCofins() {
        System.out.print("Tem Receita com Pis e Cofins monofásico? (Sim/Não): ");
        return sc.nextLine();
    }

    public static String questionIss() {
        System.out.print("Tem Receita com ISS retido? (Sim/Não): ");
        return sc.nextLine();
    }

    public static double iss() {
        if (questionIss().equalsIgnoreCase("sim")) {
            return readInput("Por favor, inclua o valor correspondente ao ISS Retido");
        }
        return 0;
    }

    public static double pisCofins() {
        if (questionPisAndCofins().equalsIgnoreCase("sim")) {
            return readInput("Por favor, inclua o valor correspondente ao Pis e Cofins monofásico");
        }
        return 0;
    }

    public static double icmsSt() {
        if (questionIcms().equalsIgnoreCase("sim")) {
            return readInput("Por favor, inclua o valor correspondente ao ICMS Substituição Tributária");
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

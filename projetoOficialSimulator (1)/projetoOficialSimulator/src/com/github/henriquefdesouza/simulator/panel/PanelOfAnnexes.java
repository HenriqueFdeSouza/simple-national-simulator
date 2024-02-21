package com.github.henriquefdesouza.simulator.panel;

import com.github.henriquefdesouza.simulator.annexs.*;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PanelOfAnnexes {
    Scanner sc = new Scanner(System.in);

    public void choiceAnnex() {
        System.out.print("""
                Seja Bem vindo ao Simulador!
                Escolha um anexo:\s
                1 - Anexo I
                2 - Anexo II
                3 - Anexo III
                4 - Anexo IV
                5 - Anexo V
                6 - Anexo Exterior
                Digite sua opção:\s """);
        int option = sc.nextInt();
        printGuideAliquot(option);
    }

    private Annex annexs(int option) {
        List<Annex> listAnnex = Arrays.asList(new AnnexOne(), new AnnexTwo(), new AnnexThree(), new AnnexFour(), new AnnexFive(),
                new AnnexExterior());
        return listAnnex.get(option - 1);
    }

    private void printGuideAliquot(int option) {
        annexs(option).printFullData();
    }
}

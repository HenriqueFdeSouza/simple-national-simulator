package com.github.henriquefdesouza.simulator.panel;

import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.annexfive.AnnexFive;
import com.github.henriquefdesouza.simulator.annexfour.AnnexFour;
import com.github.henriquefdesouza.simulator.annexone.AnnexOne;
import com.github.henriquefdesouza.simulator.annexthree.AnnexThree;
import com.github.henriquefdesouza.simulator.annextwo.AnnexTwo;


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
                Digite sua opção:\s """);
        int option = sc.nextInt();
        printGuideAliquot(option);
    }

    private Annexs annexs(int option) {
        List<Annexs> listAnnex = Arrays.asList(new AnnexOne(), new AnnexTwo(), new AnnexThree(), new AnnexFour(), new AnnexFive());
        return listAnnex.get(option - 1);
    }

    private void printGuideAliquot(int option) {
        annexs(option).printFullData();
    }
}

package Tabela1;

import java.util.HashMap;
import java.util.Map;

public class CauculoTabela1 {
    final static double[][] tabela = {
            {76, 0.85, 53.8, 0.1771, 1.5447},
            {152, 1.52, 110.4, 0.3812, 1.530},
            {229, 2.55, 251.9, 0.5354, 1.530},
            {305, 3.11, 455.6, 0.6909, 1.522},
            {457, 4.25, 696.2, 1.0560, 1.538},
            {610, 11.89, 936.7, 1.4290, 1.550},
            {915, 17.26, 1426, 2.1840, 1.5666},
            {1220, 36.79, 1921, 2.9630, 1.5738},
            {1525, 62.80, 2422, 3.7320, 1.587}
    };

    public static int defineIndice(double vazao) {
        for (int i = 0; i < tabela.length; i++) {
            double Vminima = tabela[i][1];
            double Vmaxima = tabela[i][2];

            if (vazao >= Vminima && vazao <= Vmaxima) {
                return i;
            }
        }

        return -1;
    }

    public static double[] retornaValores(int indice) {
        if (indice < 0 || indice >= tabela.length) {
            System.out.println("Item não encontrado na tabela");
            return null;
        }

        return tabela[indice];
    }
}

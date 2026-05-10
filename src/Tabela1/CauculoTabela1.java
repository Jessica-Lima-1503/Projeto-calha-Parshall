package Tabela1;

import java.util.HashMap;
import java.util.Map;

public class CauculoTabela1 {

    public static double[] selecionarCalha(double vazao){

        Map<Integer, double[]> tabela = new HashMap<>();

        tabela.put(1, new double[]{76, 0.85, 53.8, 0.1771, 1.5447});
        tabela.put(2, new double[]{152, 1.52, 110.4, 0.3812, 1.530});
        tabela.put(3, new double[]{229, 2.55, 251.9, 0.5354, 1.530});
        tabela.put(4, new double[]{305, 3.11, 455.6, 0.6909, 1.522});
        tabela.put(5, new double[]{457, 4.25, 696.2, 1.0560, 1.538});
        tabela.put(6, new double[]{610, 11.89, 936.7, 1.4290, 1.550});
        tabela.put(7, new double[]{915, 17.26, 1426, 2.1840, 1.5666});
        tabela.put(8, new double[]{1220, 36.79, 1921, 2.9630, 1.5738});
        tabela.put(9, new double[]{1525, 62.80, 2422, 3.7320, 1.587});

        for (double[] linha : tabela.values()) {

            double W = linha[0];
            double Vminima = linha[1];
            double Vmaxima = linha[2];
            double K = linha[3];
            double n = linha[4];

            if (vazao >= Vminima && vazao <= Vmaxima) {
                return new double[]{W, K, n};
            }
        }

        return null;
    }
}

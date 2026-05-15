package Tabela2;

import java.util.HashMap;
import java.util.Map;

public class CalculoTabela2 {

    public static final double[][] tabela = {
            {1, 22.9},
            {3, 38.1},
            {6, 45.7},
            {9, 61.0},
            {10, 91.5},
            {15, 91.5},
            {20, 91.5},
            {30, 91.5},
            {40, 91.5},
            {60, 91.5},
            {70, 91.5},
            {80, 91.5},
            {100, 122.0}
            // aonde é polegada permanece o valor normal, aonde é pé eu multipliquei por 100
    };

    public static double pegarE(int polegadas) {
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i][0] == polegadas) {
                return tabela[i][1];
            }
        }
        return -1; // Retorna -1 se o valor não for encontrado
    }
}
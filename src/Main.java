import java.util.Scanner;

import CalculoH.CalculoH;
import Consumo.ConsumoAgua;
import Tabela1.CalculoTabela1;
import Tabela2.CalculoTabela2;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean maiorQue70 = true;

        System.out.println("\nCÁLCULO CALHA PARSHALL ");

        System.out.print("\nDigite a população: ");
        int populacao = scanner.nextInt();

        System.out.print("Digite o consumo por habitante (L/dia): ");
        double consumoPorHabitante = scanner.nextDouble();

        // Calculo da vazao aqui
        double vazaoQ = ConsumoAgua.calcularConsumo(populacao, consumoPorHabitante);

        System.out.printf("\nVazão calculada: %.4f L/s%n", vazaoQ);

        // indice para localizar na tebela
        int indice = CalculoTabela1.defineIndice(vazaoQ);

        if (indice == -1) {
            System.out.println("Nenhum valor encontrado na tabela.");
            return;
        }

        while (maiorQue70) {
            // aqui vai pegar os dados da tabela
            double[] dadosTabela = CalculoTabela1.retornaValores(indice);

            // vai calcular o h
            // aqui vai pegar o k e o n
            double k = dadosTabela[4];
            double n = dadosTabela[5];
            // Converte vazão de L/s para m³/s
            double vazaoEmMetrosCubicos = vazaoQ / 1000.0;
            double h = CalculoH.calcularH(vazaoEmMetrosCubicos, k, n);

            // resultado no terminal
            System.out.println("\nRESULTADOS BRUTOS: ");

            System.out.printf("K: %.4f%n", k);
            System.out.printf("N: %.4f%n", n);
            System.out.printf("H calculado: %.4f%n", h);

            System.out.println("Indice da tabela 1: " + indice);

            double valorE = CalculoTabela2.pegarE((int) dadosTabela[1]);

            double hEmCm = h * 100;

            System.out.printf("H calculado: %.2f cm%n", hEmCm);

            if (hEmCm < (valorE * 0.70)) {
                System.out.printf("H (%.2f cm) < 70%% de E (%.2f cm) → APROVADA%n",
                        hEmCm, valorE * 0.70);
                maiorQue70 = false;
            } else {
                System.out.printf("H (%.2f cm) >= 70%% de E (%.2f cm) → REPROVADA%n", hEmCm, valorE * 0.70);
                System.out.println("\nRecalculando com nova vazão.");
                if (indice < CalculoTabela1.tamanhoTabela() - 1) {
                    indice++;
                } else {
                    System.out.println(
                            "Não há mais opções na tabela para recalcular. Não será possível aprovar a calha Parshall.");
                    break;
                }
            }
        }

        scanner.close();
    }
}

// para voce na hora de fazer o proximo passo(nao esqueca de apagar em)
// double[] dados = CalculoTabela1.getTabela()[i];
//
// double larguraCalha = dados[0];
// double area = dados[1];
// double vazaoMinima = dados[2];
// double vazaoMaxima = dados[3];
// double k = dados[4];
// double n = dados[5];
// double alturaE = dados[6];
//
// double alturaH = CalculoH.calcularH(vazaoQ, k, n) * 100;
//
// double limite70 = alturaE * 0.70;
//
// boolean aprovado = alturaH <= limite70;